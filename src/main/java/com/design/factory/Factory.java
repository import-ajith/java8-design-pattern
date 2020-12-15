package com.design.factory;

import com.design.factory.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

     /*static Factory<Circle> createFactory() {
         return ()->new Circle();
    }*/

   /* static <T> Factory<T> createFactory(Supplier<T> supplier) {
         return ()->supplier.get();
    }*/

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }


  /*  static Factory<Circle> createFactory(Color colr) {
        return ()->new Circle(colr);
    }*/
     /**
     * Powershell application
     * functionl acts as a supplier
     * */
    /*static Factory<Circle> createFactory(Color colr) {
        Function<Color,Circle> constructor=c->new Circle(c);
        return ()->constructor.apply(colr);
    }*/

    static <P,T> Factory<T> createFactory(Function<P,T> constructor,P color) {
        return ()->constructor.apply(color);
    }


    default T newInstance(){
        return get();
    }

    default List<T> create5(){
        return IntStream.range(0,5)
                .mapToObj(index ->newInstance())
                .collect(Collectors.toList());
     }
}
