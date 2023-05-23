package main.util.concurrecy;


import java.util.ArrayList;
import java.util.List;

public class MyBlockingQueue {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Runnable task = queue.get();
                    task.run();
                } catch (InterruptedException e) {
                    System.out.println("Ошибка на этапе ожидания задачи");
                    Thread.currentThread().interrupt();
                }
            }
        });
        worker.start();

        for (int i = 1; i <= 12; i++) {
            queue.put(getTask(i));
            System.out.println("Put " + i + " task");
        }

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Кидаем ошибку");
        worker.interrupt();
    }

    public static Runnable getTask(int i) {
        return () -> {
            System.out.println(i + " task started");
            try {
                Thread.sleep(1000);
                System.out.println(i + " task finished");
            } catch (InterruptedException e) {
                System.out.println("Ошибка на этапе выполения задачи");
                Thread.currentThread().interrupt();
                System.out.println(i + " task interrupted");
            }
        };
    }

    static class BlockingQueue {
        final Object lock = new Object();
        List<Runnable> tasks = new ArrayList<>();

        public Runnable get() throws InterruptedException {
            while (tasks.isEmpty()) {
                synchronized (lock) {
                    lock.wait();
                }
            }
            Runnable task = tasks.get(0);
            tasks.remove(task);
            return task;
        }

        public void put(Runnable task) {
            synchronized (lock) {
                tasks.add(task);
                lock.notify();
            }
        }
    }
}