package main.util.concurrecy;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synchronized {

    public static void main(String[] args) throws InterruptedException {
        Synchronized sync = new Synchronized();

        Thread waitThread = new Thread(() -> {
            try {
                Thread.sleep(1_000);
                sync.ready.set(true);
                System.out.println("ready to roll");
                sync.blockUntilRoll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread rollThread = new Thread(() -> {
            try {
                sync.rollNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        waitThread.start();

        while (!sync.ready.get()) {
            System.out.println("not ready to roll");
            Thread.sleep(100L);
        }

        rollThread.start();
    }

    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    private final AtomicBoolean ready = new AtomicBoolean(false);

    private final Random random = new Random();

    public void rollNumber() throws InterruptedException {
        lock.lock();
        System.out.println("rollNumber lock acquired");
        int result = 0;

        while(result != 37) {
            Thread.sleep(10L);
            result = random.nextInt(100);
            System.out.println("rollNumber rolled " + result);
        }

        condition.signalAll();
        lock.unlock();
        System.out.println("rollNumber lock released");
    }

    public void blockUntilRoll() throws InterruptedException {
        lock.lock();
        System.out.println("blockUntilRoll lock()");
        condition.await();
        System.out.println("blockUntilRoll woken up");
        lock.unlock();
        System.out.println("blockUntilRoll unlock()");
    }

}
