package com.design.chaining.function;

import com.design.chaining.model.Meteo;

import java.util.Objects;

@FunctionalInterface
public interface Function<T,R> {

    R apply(T t);

    /*
    * T,R are inputs
    * V is output
    * */
    default <V> Function<T, V> andThen(Function<R, V> other){
        Objects.requireNonNull(other);
        return (T t) ->{
                R r=this.apply(t);
                return other.apply(r);
        };
    }

    default <V> Function<V, R> compose(Function<V, T> other){
        Objects.requireNonNull(other);
        return (V v)->{
            T t=other.apply(v);
            return this.apply(t);
         };
    }

    static <T> Function<T,T> identity(){
        return t->t;
    }
}
