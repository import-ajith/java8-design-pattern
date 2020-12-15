package com.design.comparator.util;

import com.design.chaining.function.Function;
import com.design.comparator.model.Person;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    /**
     * Method has input parameter Function
     * @return Comparator
     * */
    default  <U extends Comparable<U>> Comparator<T> thenComparing(Function<T,U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }

    int compare(T t1, T t2);

    /* static <T> Comparator<T> comparing(Function<T, String> keyExtractor) {
        return (p1, p2) -> {
               *//* String name1=p1.getName();
                String name2=p2.getName();*//*
            String name1 = keyExtractor.apply(p1);
            String name2 = keyExtractor.apply(p2);
            return name1.compareTo(name2);
        };
    }*/

    /*Generic method
    * Both Integer and Strings are extends Comparable
    * */
    static <T,U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U name1 = keyExtractor.apply(p1);
            U name2 = keyExtractor.apply(p2);
            return name1.compareTo(name2);
        };
    }



    /**
     * comparator chaining
     * */
    default Comparator<T> thenComparing(Comparator<T> other){
        Objects.requireNonNull(other);
        return (T t1,T t2)->{
            int compare=this.compare(t1,t2);
            if (compare==0){
                return compare(t1,t2);
            }else{
                return compare;
            }
        };
    }

    default Comparator<T> reversed(){
         return (t1,t2)->this.compare(t2,t1);
    }
}
