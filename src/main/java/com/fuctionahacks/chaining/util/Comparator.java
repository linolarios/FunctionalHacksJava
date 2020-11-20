package com.fuctionahacks.chaining.util;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> key) {
        Objects.requireNonNull(key);
        return (p1, p2) -> key.apply(p1)
                .compareTo(key.apply(p2));
    }

    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    default Comparator<T> thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (t1, t2) -> {
            int compare = this.compare(t1, t2);
            if (compare == 0) {
                return other.compare(t1, t2);
            }
            return compare;
        };
    }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> key) {
        Objects.requireNonNull(key);
        Comparator<T> other = comparing(key);
        return this.thenComparing(other);
    }
}
