package com.design.chaining;

import com.design.chaining.function.Consumer;

public class PlayWithConsumer {
    public static void main(String[] args) {
        Consumer<String> c1= s -> System.out.println("c1 : "+s);
        Consumer<String> c2=s->System.out.println("c2 : "+s);
      /*  c1.accept("Hello");
        c2.accept("Hello");*/

       /* Consumer<String> c3=s->{
            c1.accept("Hello C1"+s);
            c2.accept("Hello C2"+s);
        };
        c3.accept("Hello C3");*/

        Consumer<String> c3=c1.andThen(c2);
        c3.accept("Hello C3");
    }
}
