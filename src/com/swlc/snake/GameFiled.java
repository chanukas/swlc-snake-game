package com.swlc.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 01:32 am
 * @project swlc-snake-game
 */
public class GameFiled extends JPanel {

    public static final int PANEL_WIDTH = 500;
    public static final int PANEL_HEIGHT = 500;

    private List<Ellipse2D.Double> snakeParts;
    private Food foods;

    public GameFiled() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLACK);
        initDefaults();
    }

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
        g2.setPaint(Color.RED);
        g2.fillOval((int) foods.getShape().getMinX() + 5, (int) foods.getShape().getMinY() + 5, 10, 10);

        // Draw the snake parts
        g2.setPaint(Color.WHITE); // white
        for (Ellipse2D e : snakeParts) {
            g2.fill(e);
        }

        // Draw the head of the snake
        g2.setPaint(Color.GREEN); // RED
        g2.fill(snakeParts.get(0));
    }
}

