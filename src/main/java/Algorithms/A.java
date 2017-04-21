package Algorithms;

/**
 * @author (created on 4/21/2017).
 */
public class A {
    public static class X {
        public static class Y {
            public static String Z = "life is good";
        }

        public static C Y;
    }

    public static class C {
        public static String Z = "life is pain";
    }

    public static void main(String[] args) {
        System.out.println(X.Y.Z);
    }
}
