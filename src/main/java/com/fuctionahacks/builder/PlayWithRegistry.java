package com.fuctionahacks.builder;

import java.util.function.Consumer;

import com.fuctionahacks.builder.model.Rectangle;
import com.fuctionahacks.builder.model.Shape;
import com.fuctionahacks.builder.model.Triangle;
import com.fuctionahacks.factory.supplier.Factory;

public class PlayWithRegistry {
    @SuppressWarnings("unchecked")
    public static void main(String... var) {

        SwitchRegistry registry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle " + rectangleFactory.newInstance());


        Consumer<Builder<Shape>> consumer1 = builder ->
                builder.register("rectangle", Rectangle::new);

        Consumer<Builder<Shape>> consumer2 = builder ->
                builder.register("triangle", Triangle::new);

        final Consumer<Builder<Shape>> builderConsumer = consumer1.andThen(consumer2);

        final Registry<Shape> finalRegistry = Registry.createRegistry(builderConsumer, s -> {
            throw new IllegalArgumentException("Unregistered shape: " + s);
        });

        final Factory<Rectangle> rectangle = (Factory<Rectangle>) finalRegistry.buildShapeFactory("rectangle");
        final Factory<Triangle> triangle = (Factory<Triangle>) finalRegistry.buildShapeFactory("triangle");

        System.out.println("Rectangle " + rectangle.newInstance());
        System.out.println("Triangle " + triangle.newInstance());

    }
}
