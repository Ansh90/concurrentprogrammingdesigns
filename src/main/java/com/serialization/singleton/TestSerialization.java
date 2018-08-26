package com.serialization.singleton;

import java.io.*;

public class TestSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializationWithSingleton serializationWithSingleton = SerializationWithSingleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("serializedObject.ser"));
        out.writeObject(serializationWithSingleton);
        out.close();
        ObjectInput input = new ObjectInputStream(new FileInputStream("serializedObject.ser"));
        SerializationWithSingleton instanceTwo = (SerializationWithSingleton) input.readObject();
        input.close();
        System.out.println(serializationWithSingleton.hashCode());
        System.out.println(instanceTwo.hashCode());

    }
}
