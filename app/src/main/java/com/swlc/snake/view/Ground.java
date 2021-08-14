package com.swlc.snake.view;

import com.swlc.snake.view.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.swlc.snake.constant.Constants.GROUND_PANEL_HEIGHT;
import static com.swlc.snake.constant.Constants.GROUND_PANEL_WIDTH;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 01:32 am
 * @project swlc-snake-game
 */

/**
 * Ground represents a black, rectangular area where the snake can move. It is also responsible for drawing the snake and the food.
 */
public class Ground extends JPanel {


    private List<Ellipse2D.Double> snakeParts;
    private Food foods;

    public Ground() {
        setPreferredSize(new Dimension(GROUND_PANEL_WIDTH, GROUND_PANEL_HEIGHT));
        setBackground(Color.BLACK);
        initDefaults();
    }

    /**
     * Initializes the default snake and the food
     */

    public void initDefaults() {
        foods = new Food(100, 100);
        snakeParts = Collections.synchronizedList(new ArrayList<>());
        snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
    }

    public void setSnakeParts(List<Ellipse2D.Double> snakeParts) {
        this.snakeParts = snakeParts;
    }

    public void setFood(Food food) {
        this.foods = food;
    }

    public Food getFood() {
        return foods;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the foods
        g2.setPaint(Color.RED); // RED
        g2.fillOval((int) foods.getShape().getMinX() + 5, (int) foods.getShape().getMinY() + 5, 10, 10);

        // Draw the snake parts
        g2.setPaint(Color.WHITE); // WHITE

        int i =0;
        for (Ellipse2D e : snakeParts) {
            if (i==0){
                g2.fill(e);
            }else{
                Rectangle rect = new Rectangle((int)e.getMinX(), (int)e.getMinY(), 20, 20);
                g2.fill(rect);
            }
            i++;
        }

        // Draw the head of the snake
        g2.setPaint(Color.GREEN); //  GREEN
        g2.fill(snakeParts.get(0));
    }
}

