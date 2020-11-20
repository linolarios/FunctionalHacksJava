package com.fuctionahacks.factory;

import java.awt.*;
import java.util.List;

import com.fuctionahacks.factory.model.Circle;
import com.fuctionahacks.factory.supplier.CircleFactory;
import com.fuctionahacks.factory.supplier.Factory;

public class PlayWithFactory {

    public static void main(String[] args){

        Factory<Circle> factory = Factory.createFactory(Circle::new, Color.RED);
        Factory<Circle> factoryWhite = Factory.createFactory(Circle::new);

        final Circle circle = factory.newInstance();
        final Circle whiteCircle = factoryWhite.newInstance();
        List<Circle> circles =factory.create5Instances();

        System.err.println("Circle 1 = " + circle);
        System.err.println("Circle 2 = " + whiteCircle);
        System.err.println("Circles = " + circles);

    }
}
