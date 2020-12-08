package com.fuctionahacks.builder;

import com.fuctionahacks.builder.model.Rectangle;
import com.fuctionahacks.builder.model.Shape;
import com.fuctionahacks.builder.model.Square;
import com.fuctionahacks.builder.model.Triangle;
import com.fuctionahacks.factory.supplier.Factory;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape){

        switch (shape){
            case "square" :
                return Square::new;
            case "triangle" :
                return Triangle::new;
            case "rectangle" :
                return Rectangle::new;
            default:
                throw new IllegalArgumentException("Unknown shape: "+ shape);
        }
    }
}
