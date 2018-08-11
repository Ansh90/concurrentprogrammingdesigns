package com.design.samples.deadlock.com.design.samples.deadlock.e1;

public class DeadLockEntryPoint {

    public static void main(String[] args) {
        DeadLockThreadImplementation deadLockEntryPoint = new DeadLockThreadImplementation();
        Thread thread = new Thread(deadLockEntryPoint);
        deadLockEntryPoint.directMethod();
    }
}
