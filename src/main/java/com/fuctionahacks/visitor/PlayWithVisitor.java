package com.fuctionahacks.visitor;

import java.util.function.Consumer;

import com.fuctionahacks.visitor.model.Body;
import com.fuctionahacks.visitor.model.Car;
import com.fuctionahacks.visitor.model.Engine;

public class PlayWithVisitor {

    public static void main(String... args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class)
                        .execute((Car c) -> "Visiting car: " + c)
                        .forType(Engine.class)
                        .execute((Engine e) -> "Visiting engine: " + e)
                        .forType(Body.class)
                        .execute((Body b) -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);
        final String visitedCar = visitor.visit(car);
        final String visitedEngine = visitor.visit(engine);
        final String visitedBody = visitor.visit(body);

        System.out.println(visitedCar + " " + visitedEngine + " " + visitedBody);

    }
}
