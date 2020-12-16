package com.design.registry;


import com.design.factory.Factory;
import com.design.factory.model.Rectangle;
import com.design.factory.model.Shape;
import com.design.factory.model.Square;
import com.design.factory.model.Triangle;

import java.util.function.Consumer;

/**
 * @author Ajithlal
 */
public class PlayWithRegistryBuilder {

    public static void main(String[] args) {
        Consumer<Builder<Shape>> consumer1= builder->builder
                .register("rectangle", Rectangle::new);

        Consumer<Builder<Shape>> consumer2= builder->builder
                .register("triangle", Triangle::new);

        Consumer<Builder<Shape>> consumer=consumer1.andThen(consumer2);

      /*  Registry registery=Registry.createRegistry(consumer);*/
          Registry registery=Registry.createRegistry(consumer,s->
                {throw new IllegalArgumentException("Unknown shape: " + s);});

        Factory<Rectangle> buildShapeFactoryRectangle=(Factory<Rectangle>)registery
                .buildShapeFactory("rectangle");

        Rectangle rectangle=buildShapeFactoryRectangle.newInstance();
        System.out.println("Rectangle  : "+rectangle);

        Factory<Triangle> buildShapeFactoryTriangle=(Factory<Triangle>)registery
                .buildShapeFactory("triangle");

        Triangle triangle=buildShapeFactoryTriangle.newInstance();
        System.out.println("Triangle  : "+triangle);

        /*exception case*/
        Factory<Square> buildShapeFactorySquare = (Factory<Square>)registery
                .buildShapeFactory("square");
        Square square=buildShapeFactorySquare.newInstance();
        System.out.println("Square  : "+square);


    }


}
