package com.swlc.snake.view;

import com.swlc.snake.constant.Route;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.swlc.snake.constant.Constants.SNAKE_X_SIZE;
import static com.swlc.snake.constant.Constants.SNAKE_Y_SIZE;

/**
 * @author Chanuka Sandaruwan
 * @created 01/08/2021 - 10:55 pm
 * @project swlc-snake-game
 */

/**
 * This class represents a snake which is represented as a list of snake parts.
 */


public class Snake {

    private final Ground gameGround;
    private final ScoreBoard scoreBoard;
    private List<Ellipse2D.Double> snakeParts;
    private Route route;
    private Ellipse2D.Double ass;
    private boolean over = false;


    /**
     * Constructs a snake object with the default snake parts
     *
     * @param gameGround The field on which snake can move
     * @param scoreBoard The panel for displaying user score
     */
    public Snake(Ground gameGround, ScoreBoard scoreBoard) {
        this.gameGround = gameGround;
        this.scoreBoard = scoreBoard;
        initDefaults();
    }


    /**
     * Changes snake's direction
     *
     * @param route The new direction
     */
    public void changeDirection(Route route) {
        this.route = route;
    }

    /**
     * Moves the snake in the current direction
     */
    public void move() {
        switch (route) {
            case UP:
                moveBody();

                // turn snake direction to the up
                snakeParts.set(0,
                        new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() - 20, SNAKE_X_SIZE, SNAKE_Y_SIZE));
                if (snakeParts.get(0).getMinY() < 0) {
                    over = true;
                }
                break;

            case DOWN:
                moveBody();

                // turn snake direction to the down
                snakeParts.set(0,
                        new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() + 20, SNAKE_X_SIZE, SNAKE_Y_SIZE));
                if (snakeParts.get(0).getMaxY() > gameGround.getBounds().getMaxY()) {
                    over = true;
                }
                break;

            case LEFT:
                moveBody();

                // turn snake direction to the left
                snakeParts.set(0,
                        new Ellipse2D.Double(snakeParts.get(0).getMinX() - 20, snakeParts.get(0).getMinY(), SNAKE_X_SIZE, SNAKE_Y_SIZE));
                if (snakeParts.get(0).getMinX() < 0) {
                    over = true;
                }
                break;

            case RIGHT:
                moveBody();

                // turn snake direction to the right
                snakeParts.set(0,
                        new Ellipse2D.Double(snakeParts.get(0).getMinX() + 20, snakeParts.get(0).getMinY(), SNAKE_X_SIZE, SNAKE_Y_SIZE));
                if (snakeParts.get(0).getMaxX() > gameGround.getBounds().getMaxX()) {
                    over = true;
                }
                break;

            default:
                new Exception("Unexpected Direction value!").printStackTrace();
                break;
        }
    }

    /**
     * @return Snake parts the list containing snake parts
     */
    public List<Ellipse2D.Double> getParts() {
        return snakeParts;
    }

    /**
     * Checks if the snake ate the food or ate itself
     */
    public void check() {
        Ellipse2D.Double head = snakeParts.get(0);
        Food food = gameGround.getFood();

        // Ate itself
        for (int i = 1; i < snakeParts.size(); i++) {
            if (head.getMinX() == snakeParts.get(i).getMinX() && head.getMinY() == snakeParts.get(i).getMinY()) {
                over = true;
                return;
            }
        }

        // Ate food
        if (head.getMinX() == food.getShape().getMinX() && head.getMinY() == food.getShape().getMinY()) {
            scoreBoard.addPoints(1);
            food.next(this);
            snakeParts.add(ass);
        }
    }

    /**
     * @return true if game over, otherwise false
     */
    public boolean isGameOver() {
        return over;
    }

    private void moveBody() {
        for (int i = snakeParts.size() - 1; i > 0; i--) {
            if (i == snakeParts.size() - 1) {
                ass = (Ellipse2D.Double) snakeParts.get(i).clone();
            }
            Ellipse2D.Double temp = (Ellipse2D.Double) snakeParts.get(i - 1).clone();
            snakeParts.set(i, temp);
        }
    }

    private void initDefaults() {
        snakeParts = Collections.synchronizedList(new ArrayList<>());
        snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
        snakeParts.add(new Ellipse2D.Double(260, 280, 20, 20));
    }



}
