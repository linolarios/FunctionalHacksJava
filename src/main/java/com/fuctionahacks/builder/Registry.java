package com.fuctionahacks.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import com.fuctionahacks.factory.supplier.Factory;

public interface Registry<T> {

    Factory<? extends T> buildShapeFactory(String shape);

    static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction) {
        Map<String, Factory<T>> map = new HashMap<>();

        // Same as function : (label,factory) -> map.put(label, factory); described in the client's code
        Builder<T> builder = map::put;
        consumer.accept(builder);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}

