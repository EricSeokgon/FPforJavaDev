package chapter2;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class NumberClassifier {
    /*public static boolean isFactor(final int candidate, final int number) {
        return number % candidate == 0;
    }

    public static Set<Integer> factors(final int number) {
        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(number);
        for (int i = 2; i < number; i++) {
            if (isFactor(i, number)) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static int aliquotSum(final Collection<Integer> factors) {
        int sum = 0;
        int targetNumer = Collections.max(factors);
        for (int n : factors) {
            sum += n;
        }
        return sum - targetNumer;
    }*/

    public static IntStream factorsOf(int number) {
        return range(1, number + 1)
                .filter(potential -> number % potential == 0);
    }

    public static int aliquotSum(int number) {
        return factorsOf(number).sum() - number;
    }

    public static boolean isPerfect(final int number) {
        return aliquotSum(number) == number;
    }

    public static boolean isAbundant(final int number) {
        return aliquotSum(number) > number;
    }

    public static boolean isDeficient(final int number) {
        return aliquotSum(number) < number;
    }

}
