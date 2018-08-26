package com.designpatterns.singleton;

public enum EnumSingleton {
    INSTANCENUM_SINGLETON, ABC;

    public void doSomething() {
        System.out.println("Using enum instance");
    }
}
