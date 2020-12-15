package com.design.registry;


import com.design.factory.Factory;

public interface Builder<T> {

	void register(String label, Factory<T> factory);
}
