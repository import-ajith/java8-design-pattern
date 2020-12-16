package com.design.registry;


import com.design.factory.Factory;

/**
 * @author Ajithlal
 */
public interface Builder<T> {

	void register(String label, Factory<T> factory);
}
