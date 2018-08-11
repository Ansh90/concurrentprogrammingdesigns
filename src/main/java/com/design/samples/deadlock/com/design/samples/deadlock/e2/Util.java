package com.design.samples.deadlock.com.design.samples.deadlock.e2;

// Java program to illustrate Deadlock
// in multithreading.
public class Util {
    // Util class to sleep a thread
    static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
