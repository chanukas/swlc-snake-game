package com.swlc.snake.test;

import com.swlc.snake.constant.Route;
import com.swlc.snake.view.Food;
import com.swlc.snake.view.Ground;
import com.swlc.snake.view.ScoreBoard;
import com.swlc.snake.view.Snake;
import org.junit.Test;

import java.awt.geom.Ellipse2D;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Chanuka Sandaruwan
 * @created 10/08/2021 - 10:31 pm
 * @project swlc-snake-game
 */
public class SnakeTest {

    @Test
    public void testSnakeMovesUP() {
        ScoreBoard scoreBoard;
        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        Snake snake = new Snake(ground, scoreBoard);
        Route.DOWN.toString();
        Route direction = Route.UP;

        switch (Route.UP) {
            case UP:
                assertEquals(Route.UP.toString(), "UP");

                break;

            default:
                new Exception("Unexcepted Direction value!").printStackTrace();
                break;
        }

    }

    @Test
    public void testSnakeMovesDown() {
        ScoreBoard scoreBoard;
        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        Snake snake = new Snake(ground, scoreBoard);
        Route.DOWN.toString();

        switch (Route.DOWN) {
            case DOWN:
                assertEquals(Route.DOWN.toString(), "DOWN");

                break;

            default:
                new Exception("Unexcepted Direction value!").printStackTrace();
                break;
        }

    }

    @Test
    public void testSnakeMovesLeft() {
        ScoreBoard scoreBoard;
        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        Snake snake = new Snake(ground, scoreBoard);
        Route.LEFT.toString();

        switch (Route.LEFT) {
            case LEFT:
                assertEquals(Route.LEFT.toString(), "LEFT");

                break;

            default:
                new Exception("Unexcepted Direction value!").printStackTrace();
                break;
        }

    }

    @Test
    public void testSnakeMovesRight() {
        ScoreBoard scoreBoard;
        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        Snake snake = new Snake(ground, scoreBoard);
        Route.RIGHT.toString();

        switch (Route.RIGHT) {
            case RIGHT:
                assertEquals(Route.RIGHT.toString(), "RIGHT");

                break;

            default:
                new Exception("Unexcepted Direction value!").printStackTrace();
                break;
        }

    }

    @Test
    public void testSnakeFoodCollision() {
        ScoreBoard scoreBoard;

        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        boolean over = false;
        Snake snake = new Snake(ground, scoreBoard);
        List<Ellipse2D.Double> snakeParts = snake.getParts();

        Ellipse2D.Double head = snakeParts.get(0);
        Food food = ground.getFood();
        scoreBoard.addPoints(10);

        if(head.getMaxX() == food.getShape().getMinX() && head.getMinY() == food.getShape().getMinY()) {
            assertEquals(scoreBoard,10);
        }

    }


    @Test
    public void testSnakeDies() {
        ScoreBoard scoreBoard;

        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
        boolean over = false;
        Snake snake = new Snake(ground, scoreBoard);
        List<Ellipse2D.Double> snakeParts = snake.getParts();

        Ellipse2D.Double head = snakeParts.get(0);
        Food food = ground.getFood();

        snake.changeDirection(Route.UP);
        snake.move();
        snake.changeDirection(Route.DOWN);
        snake.move();
        snake.changeDirection(Route.LEFT);
        snake.move();
        snake.changeDirection(Route.RIGHT);
        snake.move();

        assertTrue(snake.isGameOver());

    }


}
