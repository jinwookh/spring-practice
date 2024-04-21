package org.example.reflection;

public class Main {
    public static void main(String[] args) {
        Example object = ContainerService.getObject(Example.class);
        System.out.println(object);
        System.out.println(object.hello);
    }
}
