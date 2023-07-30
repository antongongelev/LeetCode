package main.util.concurrecy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class EmailFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(EmailFuture::getEmail).thenAccept(s -> sendToEmail("My text", s));
        future.get();

    }

    public static String getEmail() {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException ignored) {
        }
        return "e_mail";
    }

    public static void sendToEmail(String text, String email) {
        System.out.println(text + " has been send on " + email);
    }
}

