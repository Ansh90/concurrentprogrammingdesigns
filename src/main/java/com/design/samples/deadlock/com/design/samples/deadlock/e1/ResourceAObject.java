package com.design.samples.deadlock.com.design.samples.deadlock.e1;

public class ResourceAObject implements Resource {

    private ResourceBObject resource = null;

    /**
     * When this synchronized method is called com.design.samples.deadlock.com.design.samples.deadlock.e1.ResourceAObject
     * will be locked by calling thread.
     *
     * @param resource
     */
    public synchronized void updateCurrentFromResource(ResourceBObject resource) {

        this.resource = resource;

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
        try {
            Thread.sleep(1000);
            System.out.println("Reached post sleep");
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
        this.resource.getString();
    }

    public synchronized String getString() {
        String str = "From Resource A Object";
        System.out.println(str);
        return str;
    }
}
