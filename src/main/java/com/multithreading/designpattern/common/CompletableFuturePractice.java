package com.multithreading.designpattern.common;

import java.util.concurrent.*;
import java.util.function.Supplier;


public class CompletableFuturePractice {

    public static void main(String[] args) {

        MyThread myThread = new CompletableFuturePractice().new MyThread();
        myThread.setPriority(10);
        myThread.start();


        ExecutorService executorService = Executors.newFixedThreadPool(4);

        /**
         * If you have runnable task which neither throw checked exception
         * neither required to return anything
         */
        Runnable runnable = () -> {
            System.out.println("Talking from runnable currently running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Future<?> futureObj1 = executorService.submit(runnable);

        /**
         * If you have a task which either throws checked exception or require
         * to return something in Future object or both then use callable.
         */
        Callable<String> callable = () -> {
            String messege = "Babes Its supplier " + Thread.currentThread().getName();
            System.out.println(messege);
            try {
                Thread.sleep(10 * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return messege;
        };
        Future<String> futureObj2 = executorService.submit(callable);
        try {
            String returnObject = futureObj2.get();
            System.out.println(returnObject + "  -----> printed sometime in future");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        /**
         * This is a parallel way to run task through CompletableFuture. Since I have passed
         * runnable task there will be no returned object in completableFuture.
         */
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(runnable);

        /**
         * CompletableFuture doesn't take Callable object so if you need future object holds
         * returned object or some kind of exception we need to use Supplier instead of Callable
         * and use supplyAsync(Supplier type) method to execute supplier in some thread in jvm
         * fork thread pool
         *
         * Note: Supplier doesn't help to propage exception as Callable does.
         *  If you want supplier to run on custom executor pool then use overloaded method as below.
         */
        Supplier<String> supplier = () -> {
            String messege = "Babes Its supplier " + Thread.currentThread().getName();
            System.out.println(messege);
            try {
                Thread.sleep(10 * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return messege;
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executorService);

        /**
         * These 2 variation result shows that Completable Future by default uses ForkJoinPool to run
         * supplier or runnable. But if you pass your own executor then it uses given executor pool
         * to run task.
         */
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(supplier, executorService);

        executorService.shutdown();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am My Thread running on " + Thread.currentThread().getName());
            try {
                Thread.sleep(10 * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
