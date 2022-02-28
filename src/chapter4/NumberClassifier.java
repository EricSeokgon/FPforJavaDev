package chapter4;


import com.googlecode.totallylazy.Sequence;
import com.googlecode.totallylazy.predicates.Predicate;

import static com.googlecode.totallylazy.numbers.Numbers.*;
import static com.googlecode.totallylazy.predicates.Predicates.is;
import static com.googlecode.totallylazy.predicates.WherePredicate.where;

public class NumberClassifier {
    public static Predicate isFactor(Number n) {
        return where(remainder(n), is(zero));
    }

    public static Sequence getFactors(final Number n) {
        return range(1, n).filter(isFactor(n));
    }

    public static Sequence factors(final Number n) {
        return getFactors(n).memoize();
    }

    public static Number aliquotSum(Number n) {
        return subtract((Number) factors(n).reduce(sum), n);
    }

    public static boolean isPerfect(Number n) {
        return equalTo(n, aliquotSum(n));
    }

    public static boolean isAbundant(Number n) {
        return greaterThan(aliquotSum(n), n);
    }

    public static boolean isDeficient(Number n) {
        return lessThan(aliquotSum(n), n);
    }
}
