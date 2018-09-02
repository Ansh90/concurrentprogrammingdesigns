package com.lambda.expressions;


@FunctionalInterface
public interface MyFunctionalInteface<T> {

    /**
     * Lambda expression will be used to provide
     * implementation of this interface.
     * <p>
     * This interface is to copy Predicate<T> interface..
     *
     * @param s
     * @return
     */
    boolean test(T s);
}