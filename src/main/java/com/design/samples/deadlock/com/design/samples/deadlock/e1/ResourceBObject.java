package com.design.samples.deadlock.com.design.samples.deadlock.e1;

public class ResourceBObject implements Resource {

    ResourceAObject resource = null;

    /**
     * When this synchronized method is called com.design.samples.deadlock.com.design.samples.deadlock.e1.ResourceAObject
     * will be locked by calling thread.
     *
     * @param resource
     */
    public synchronized void updateCurrentFromResource(ResourceAObject resource) {

        this.resource = resource;

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        try {
            Thread.sleep(1000);
            System.out.println("B Object Reached post sleep");
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
        this.resource.getString();
    }

    public synchronized String getString() {
        String toString = "From Resource B Object";

        System.out.println(toString);
        return toString;
    }
}
