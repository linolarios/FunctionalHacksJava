package com.fuctionahacks.factory.supplier;

import static java.util.stream.Collectors.toList;

import java.awt.*;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.fuctionahacks.factory.model.Circle;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> create5Instances() {
        return IntStream.range(0, 5)
                .mapToObj(i -> newInstance())
                .collect(toList());
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier){
         T singleton = supplier.get();
         return () -> singleton;
    }

    static <T,P> Factory<T> createFactory(Function<P, T> constructor, P color){
        return () -> constructor.apply(color);
    }
}
