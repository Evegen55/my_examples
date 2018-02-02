package DesignPatterns.Multithreading;

import java.time.LocalDateTime;

public class Invoker {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        Invoked invoked = new Invoked();
        System.out.println(LocalDateTime.now());
        new Invoked();
        System.out.println(LocalDateTime.now());
        System.out.println(invoked.hashCode());
    }
}
