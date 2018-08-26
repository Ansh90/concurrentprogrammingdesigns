package com.designpatterns.singleton;

public final class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class Singleton {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static final InnerClassSingleton getInstance() {
        return Singleton.INSTANCE;
    }
}
