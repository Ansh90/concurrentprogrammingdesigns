package com.collections;

import java.util.Iterator;

class MyCollection<T> implements Iterable<T> {

    private volatile T[] object;

    public MyCollection(int size) {
        this.object = (T[]) new Object[size];
    }

    private volatile int nElem = 0;

    public int size() {
        return nElem;
    }

    public void add(T val) {
        synchronized (this) {
            this.object[nElem++] = val;
        }
    }

    public T remove(T val) {
        for (int i = 0; i < size(); i++) {
            if (val.equals(object[i])) {
                synchronized (this) {
                    nElem--;
                    return removeAndMove(object, i);
                }
            }
        }
        return null;
    }

    private T removeAndMove(T[] object, int i) {
        T temp;
        if (i == size()) {
            temp = object[i];
            object[i] = null;
            return temp;
        }
        temp = object[i];
        for (int idx = i; i < size(); i++) {
            object[idx] = object[idx + 1];
        }

        return temp;
    }

    public T get(int i) {
        return object[i];
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private volatile int index = 0;

        public boolean hasNext() {
            return index < size();
        }

        public T next() {
            return get(index++);
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");

        }
    }
}
