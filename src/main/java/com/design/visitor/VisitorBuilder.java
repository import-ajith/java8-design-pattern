package com.design.visitor;

import java.util.function.Function;

/**
 * @author Ajithlal
 * @created 16/12/2020-7:45 PM
 * @project java8-design-pattern
 */
public interface VisitorBuilder<R> {

    <T> void register(Class<T> type, Function<T, R> function);
}
