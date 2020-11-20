package com.fuctionahacks.factory.supplier;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import com.fuctionahacks.factory.model.Circle;

public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {
        return this.get();
    }

    default List<Circle> create5Circles() {
        return IntStream.range(0, 5)
                .mapToObj(i -> newInstance())
                .collect(toList());
    }
}
