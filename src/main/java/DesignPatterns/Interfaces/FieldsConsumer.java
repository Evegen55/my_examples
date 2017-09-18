package DesignPatterns.Interfaces;

/**
 * @author (created on 9/18/2017).
 */
public class FieldsConsumer {

    public static void method() {
        final String a = Fields.A;
        System.out.println(a);
    }

    public static void main(String[] args) {
        method();
    }
}
