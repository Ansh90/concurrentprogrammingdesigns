package com.designpatterns.singleton;

import javax.swing.*;

public final class LazyInitializationSingleton {
    private static LazyInitializationSingleton LAZY_INITIALIZATION_SINGLETON;

    private LazyInitializationSingleton() {
    }

    /**
     * Double checking machanism helps when multiple theads wait to acquire synchronized block.
     *
     * @return
     */
    public static LazyInitializationSingleton getInstance() {
        if (LAZY_INITIALIZATION_SINGLETON == null) {
            synchronized (LazyInitializationSingleton.class) {
                if (LAZY_INITIALIZATION_SINGLETON == null)
                    LAZY_INITIALIZATION_SINGLETON = new LazyInitializationSingleton();
            }
        }
        return LAZY_INITIALIZATION_SINGLETON;
    }
}
