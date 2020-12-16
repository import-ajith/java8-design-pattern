package com.design.factory.model;

import java.awt.*;

/**
 * @author Ajithlal
 */
public class Circle {

    private Color color;

    public Circle() {
        this(Color.WHITE);
    }

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + "]";
    }
}
