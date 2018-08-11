package com.design.samples.deadlock.com.design.samples.deadlock.e1;

public class DeadLockThreadImplementation implements Runnable {
    /**
     * Demonstration of deadlock
     * <p>
     * This class holds 2 objects both have only synchronized
     * methods. Which means they can only be accessed sequentially.
     * Now I have done their implementations as such that they call
     * each other internally to each other. If 2 theads calls
     * resourceAObject and resourceBObject concurrently they will
     * go for deadlock as both threads have locks over current thread
     * and racing to achieve lock over other dependent thread.
     */

    private ResourceAObject resourceAObject = new ResourceAObject();
    private ResourceBObject resourceBObject = new ResourceBObject();

    public void run() {
        resourceBObject.updateCurrentFromResource(resourceAObject);
    }

    public void directMethod() {
        DeadLockThreadImplementation deadLockEntryPoint = new DeadLockThreadImplementation();
        Thread thread = new Thread(deadLockEntryPoint);
        thread.start();

        resourceAObject.updateCurrentFromResource(resourceBObject);
    }
}
