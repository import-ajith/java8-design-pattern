package com.design.chaining.function;

import java.util.Objects;

/**
 * @author Ajithlal
 */
@FunctionalInterface
public interface Consumer <T>{
    void accept(T t);

    default Consumer<T> andThen(Consumer<T> other){
        Objects.requireNonNull(other);
        return (T t)->{
            this.accept(t);//current consumer
            other.accept(t);//parameter consumer
        };
    }
}
