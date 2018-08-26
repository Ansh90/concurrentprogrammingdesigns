package com.collections;

import java.util.Iterator;

public class MyCollectionUser {
    public static void main(String[] args) {
        MyCollection<Integer> collection = new MyCollection<>(10);

        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }

        Iterator itr = collection.iterator();

        for (Integer i : collection) {
            System.out.println(i);
        }
    }
}
