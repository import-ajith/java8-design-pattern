package com.design.chaining;

import com.design.chaining.function.Function;

/**
 * @author Ajithlal
 */
public class PlayWithIdentity {

	public static void main(String[] args) {

		Function<String, String> identity = Function.identity();
		System.out.println(identity.apply("t"));
		
	}
}
