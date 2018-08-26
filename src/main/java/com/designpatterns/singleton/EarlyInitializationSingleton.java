package com.designpatterns.singleton;

public final class EarlyInitializationSingleton {
    private static final EarlyInitializationSingleton EARLY_INITIALIZATION_SINGLETON = new EarlyInitializationSingleton();

    private EarlyInitializationSingleton() {
    }

    public static final EarlyInitializationSingleton getInstance() {
        return EARLY_INITIALIZATION_SINGLETON;
    }
}