package org.example.proxy;

import org.example.reflection.Hello;

public class HelloImplementation implements HelloInterface {
    @Override
    public void print() {
        System.out.println("hello");
    }
}
