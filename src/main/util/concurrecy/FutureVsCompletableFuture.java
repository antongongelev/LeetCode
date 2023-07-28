package main.util.concurrecy;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureVsCompletableFuture {

    private static class MyCallable implements Callable<String> {

        public static MyCallable of(String result) {
            return new MyCallable(result);
        }

        private final String result;

        private MyCallable(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(1_000);
            return result;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Pass Callable to ExecutorService to get 1 Future
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> submit = executor.submit(MyCallable.of("Future result of one thread"));
        String integer = submit.get();
        System.out.println(integer);
        executor.shutdown();

        // Pass Callable to ExecutorService to get 2 Futures
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        Future<String> fixedSubmitOne = fixedThreadPool.submit(MyCallable.of("1st future result of Pool thread"));
        Future<String> fixedSubmitTwo = fixedThreadPool.submit(MyCallable.of("2st future result of Pool thread"));
        String integerOne = fixedSubmitOne.get();
        String integerTwo = fixedSubmitTwo.get();
        System.out.println(integerOne);
        System.out.println(integerTwo);
        fixedThreadPool.shutdown();

        // Pass Callable to FutureTask to run in new Thread
        FutureTask<String> futureTask = new FutureTask<>(MyCallable.of("Future task result"));
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

        // Simple Completable future - 2nd invocation of 'complete' will get 1st result
        CompletableFuture<String> simpleCompletable = new CompletableFuture<>();
        // Call getNow()
        String now = simpleCompletable.getNow("Now result");
        System.out.println(now + ". IsDone is " + simpleCompletable.isDone());
        // Call complete() 1st time
        boolean a = simpleCompletable.complete("1st Completable future result");
        System.out.println(simpleCompletable.get() + ". Result is " + a + ". IsDone is " + simpleCompletable.isDone());
        // Call complete() 2nd time
        boolean b = simpleCompletable.complete("2nd completable future result");
        System.out.println(simpleCompletable.get() + ". Result is " + b + ". IsDone is " + simpleCompletable.isDone());

        // Chain 2 futures and wait for both then accept
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
                                                              try {
                                                                  Thread.sleep(2_000);
                                                              } catch (InterruptedException ignored) {
                                                              }
                                                              return "Hello";
                                                          })
                                                          .thenAcceptBoth(CompletableFuture.supplyAsync(() -> {
                                                              try {
                                                                  Thread.sleep(2_000);
                                                              } catch (InterruptedException ignored) {
                                                              }
                                                              return " World";
                                                          }), (s1, s2) -> System.out.println(s1 + s2));
        CompletableFuture<Void> future1
                = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000);
                throw new RuntimeException("My Exception");
            } catch (InterruptedException ignored) {
            }
        });

        // Chain 3 futures and wait for all. 1st future produces exception
        CompletableFuture<Void> future2
                = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000);
                System.out.println("F2 is complete");
            } catch (InterruptedException ignored) {

            }
        });
        CompletableFuture<Void> future3
                = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1_000);
                System.out.println("F3 is complete");
            } catch (InterruptedException ignored) {

            }
        });

        System.out.println("F1 is done: " + future1.isDone());
        System.out.println("F2 is done: " + future1.isDone());
        System.out.println("F3 is done: " + future1.isDone());

        try {
            CompletableFuture.allOf(future1, future2, future3).get();
        } catch (ExecutionException ignored) {
        }

        System.out.println("F1 is done: " + future1.isDone());
        System.out.println("F2 is done: " + future1.isDone());
        System.out.println("F3 is done: " + future1.isDone());

    }

}
