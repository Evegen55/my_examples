package DesignPatterns.prototype;

public class PrototypeClient {

    public static void main(String arg[]) throws CloneNotSupportedException {
        Prototype prototype1 = new ConcretePrototype1();
        Prototype prototype2 = prototype1.clone();
        System.out.println(prototype1.equals(prototype2));
    }
}
