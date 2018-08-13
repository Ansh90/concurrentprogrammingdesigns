package com.design.samples.deadlock.com.design.samples.deadlock.e2;

// This class is shared by both threads
public class Shared {
    // first synchronized method
    public synchronized void test1(Shared s2) {
        System.out.println("test1-begin");
        Util.sleep(100);

        // taking object lock of s2 enters
        // into test2 method
        s2.test2(this);
        System.out.println("test1-end");
    }

    // second synchronized method
    public synchronized void test2(Shared s1) {
        System.out.println("test2-begin");
        Util.sleep(100);

        // taking object lock of s1 enters
        // into test1 method
        s1.test1(this);
        System.out.println("test2-end");
    }
}
