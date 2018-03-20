package Algorithms;

/**
 * Here is the behaviour that is basic for JavaScript
 */
public class NumbersAndLinks {

    public static void main(String[] args) {
        String s = "Tee";
        String t = s;
        System.out.println(s);
        System.out.println(t);
        s += " and Coffee";
        System.out.println(s);
        System.out.println(t);

        System.out.println();
        float f = 6.0f/0;
        System.out.println(f);
        System.out.println(f == Float.POSITIVE_INFINITY);

        System.out.println();
        float mf = -6.0f/0;
        System.out.println(mf);
        System.out.println(mf == Float.NEGATIVE_INFINITY);
    }
}
