package Algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class EuclideGreatestCommonDivisorTest {

    @Test
    public void findGCD() {
        long gcd = EuclideGreatestCommonDivisor.findGCD(4851, 3003);
        assertEquals(231, gcd);
    }

    @Test
    public void findGCD1() {
        long gcd = EuclideGreatestCommonDivisor.findGCD(Long.MAX_VALUE, 9223372036854775807L);
        assertEquals(Long.MAX_VALUE, gcd);
    }
}