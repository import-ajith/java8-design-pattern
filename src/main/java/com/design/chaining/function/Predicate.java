package com.design.chaining.function;

import java.util.Objects;

/**
 * @author Ajithlal
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other){
        Objects.requireNonNull(other);
        return (T t)->this.test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
}
