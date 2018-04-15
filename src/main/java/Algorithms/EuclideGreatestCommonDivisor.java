package Algorithms;

public class EuclideGreatestCommonDivisor {

    /**
     * https://en.wikipedia.org/wiki/Greatest_common_divisor
     * @param a
     * @param b
     * @return
     */
    public static long findGCD (long a, long b) {
        while (b != 0) {
            long reminder = a % b;
            a = b;
            b = reminder;
        }
        return a;
    }
}
