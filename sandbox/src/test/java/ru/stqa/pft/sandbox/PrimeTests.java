package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrimes() {
        Assert.assertTrue(Primes.isPrimes(Integer.MAX_VALUE));
    }

    @Test
    public void testPrimesFast() {
        Assert.assertTrue(Primes.isPrimesFast(Integer.MAX_VALUE));
    }

    @Test
    public void testNoPrimes() {
        Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void testPrimesLong() {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrimes(n));
    }
}
