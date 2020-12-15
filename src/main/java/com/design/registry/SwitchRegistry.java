package com.design.registry;


import com.design.factory.Factory;
import com.design.factory.model.Rectangle;
import com.design.factory.model.Shape;
import com.design.factory.model.Square;
import com.design.factory.model.Triangle;

public class SwitchRegistry {

	public Factory<? extends Shape> buildShapeFactory(String shape) {
		
		switch(shape) {
			case "square" : return () -> new Square();
			case "triangle" : return () -> new Triangle();
			case "rectangle" : return () -> new Rectangle();
			default:
				throw new IllegalArgumentException("Unknown shape: " + shape);
		}
	}
}
