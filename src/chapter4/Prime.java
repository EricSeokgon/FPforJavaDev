package chapter4;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashSet;
import java.util.Set;

public class Prime {
    public static boolean isFactor(final int potential, final int number) {
        return number % potential == 0;
    }

    public static Set getFactors(final int number) {
        Set factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (isFactor(i, number)) {
                factors.add(i);
                factors.add(number / i);
            }
        }
        return factors;
    }

    public static int sumFactors(final int number) {
        int sum = 0;
        for (int i : getFactors(number)) sum += i;
        return sum;
    }

    public static boolean isPrime(final int number) {
        return sumFactors(number) == number + 1;
    }

    public static Integer nextPrimeFrom(final int lastPrime) {
        int candidate = lastPrime + 1;
        while (!isPrime(candidate)) candidate++;
        return candidate;
    }

}
