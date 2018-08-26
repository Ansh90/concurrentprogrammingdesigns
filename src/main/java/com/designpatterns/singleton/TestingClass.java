package com.designpatterns.singleton;

public class TestingClass {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCENUM_SINGLETON;
        enumSingleton.doSomething();
    }
}
