package com.design.factory;

import com.design.factory.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {

    public static void main(String[] args) {
       /* Supplier<Circle> factory=()->new Circle();*/
      /*  Factory<Circle> factory=()->new Circle();*//*for new method*/
       /* Factory<Circle> factory1=Factory.createFactory();
        Factory<Circle> factory2=Factory.createFactory(Color.BLACK);*/

        Factory<Circle> factory1=Factory.createFactory(Circle::new);
        Factory<Circle> factory2=Factory.createFactory(c->new Circle(c),Color.BLACK);

       /* Circle circle = factory.get();*/
        Circle circle = factory1.newInstance();/*new method in supplier*/
        System.out.println("Circle : "+circle);



        List<Circle> circles=factory2.create5();
        System.out.println("Circles : "+circles);
    }
}
