package DesignPatterns.Multithreading;

public class Derivative extends Invoked {

    public Derivative() {
        System.out.println("Derivate has been invoked but static" +
                " block FROM PARENT CLASS also executed");
    }
}
