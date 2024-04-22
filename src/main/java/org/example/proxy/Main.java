package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        HelloInterface hello = (HelloInterface) Proxy.newProxyInstance(HelloInterface.class.getClassLoader(), new Class[]{HelloInterface.class},
                new InvocationHandler() {
                    HelloInterface hello = new HelloImplementation();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("proxy intercepted");
                        Object invoke = method.invoke(hello, args);
                        System.out.println("proxy gone");
                        return invoke;
                    }
                }
        );
        hello.print();
    }
}
