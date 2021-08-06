package com.swlc.snake.view;

import java.awt.geom.Ellipse2D;

import static com.swlc.snake.constant.Constants.FOOD_X_SIZE;
import static com.swlc.snake.constant.Constants.FOOD_Y_SIZE;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 01:33 am
 * @project swlc-snake-game
 */

/**
 * This class represents an food which can be ate by the snake. It pop up randomly somewhere within the game ground.
 */


public class Food {

    private double x;
    private double y;

    /**
     * Creates an food with given coordinates
     * @param x The x coordinate of food's upper left corner
     * @param y The y coordinate of food's upper left corner
     */
    public Food(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Generates new coordinates for the food, so it can appear somewhere else
     * @param snake The snake
     */
    public void next(Snake snake) {
        for (Ellipse2D.Double e : snake.getParts()) {
            while (x == e.getMinX() && y == e.getMinY()) {
                x = getNew();
                y = getNew();
            }
        }
    }

    /**
     *  Generates a random number which can be used as a valid coordinate
     */
    private double getNew() {
        double d = 1111;
        while (d >= 400 || d % 20 != 0) {
            d = Math.random() * 1000;
            d = (int) d;
        }
        return d;
    }

    /**
     * @return The shape of the food
     */
    public Ellipse2D.Double getShape() {
        return new Ellipse2D.Double(x, y, FOOD_X_SIZE, FOOD_Y_SIZE);
    }

}

