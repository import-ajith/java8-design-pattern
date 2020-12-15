package com.design.registry;


import com.design.factory.Factory;
import com.design.factory.model.Rectangle;
import com.design.factory.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry<T> {

	Factory<? extends T> buildShapeFactory(String shape);
	
	public static <T> Registry<T> createRegistry(
			Consumer<Builder<T>> consumer,Function<String,Factory<T>> errorFunction) {
		
		Map<String, Factory<T>> map = new HashMap<>();
		Builder<T> builder=((label, factory) -> map.put(label,factory));
		consumer.accept(builder);
		/*return shape -> map.get(shape);*/
		/*return shape -> map.getOrDefault(shape,
				()->{throw new IllegalArgumentException("Unknown shape: " + shape);});*/

		/*Function<String,Factory<T>> errorFunction=s->
				{throw new IllegalArgumentException("Unknown shape: " + s);};*/

		return shape -> map.computeIfAbsent(shape,errorFunction);
	}


}
