package com.serialization.singleton;

import java.io.Serializable;

public class SerializationWithSingleton implements Serializable {

    public static final long serialVersionUID = -8784787384874983477L;

    private static SerializationWithSingleton serializationWithSingleton;

    private SerializationWithSingleton() {
    }

    public static final SerializationWithSingleton getInstance() {
        if (serializationWithSingleton == null) {
            synchronized (SerializationWithSingleton.class) {
                if (serializationWithSingleton == null)
                    serializationWithSingleton = new SerializationWithSingleton();
            }
        }
        return serializationWithSingleton;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
