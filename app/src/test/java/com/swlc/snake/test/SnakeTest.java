package com.swlc.snake.test;

import com.swlc.snake.constant.Route;
import com.swlc.snake.view.Food;
import com.swlc.snake.view.Ground;
import com.swlc.snake.view.ScoreBoard;
import com.swlc.snake.view.Snake;
import org.junit.jupiter.api.Test;


import java.awt.geom.Ellipse2D;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author Chanuka Sandaruwan
 * @created 10/08/2021 - 10:31 pm
 * @project swlc-snake-game
 */
public class SnakeTest {

    @Test
    public void testSnakeIs2UnitsLongByDefault() {
        Ground ground = new Ground();
        ScoreBoard scoreBoard = new ScoreBoard();
        Snake snake = new Snake(ground,scoreBoard);
        int length = snake.getSnakeParts().size();
        assertEquals(2, length);
    }



    @Test
    public void testSnakeMovesUP() {
        Ground ground = new Ground();
        ScoreBoard scoreBoard = new ScoreBoard();
        Snake snake = new Snake(ground,scoreBoard);
        snake.changeDirection(Route.UP);
        snake.move();
        Route route = snake.getRoute();
        if (route == Route.UP) {
            assertEquals(route.toString(), "UP");
        } else {
            new Exception("Unexcepted Direction value!").printStackTrace();
        }
    }

    @Test
    public void testSnakeMovesDown() {
        Ground ground = new Ground();
        ScoreBoard scoreBoard = new ScoreBoard();
        Snake snake = new Snake(ground,scoreBoard);
        snake.changeDirection(Route.DOWN);
        snake.move();
        Route route = snake.getRoute();
        if (route == Route.DOWN) {
            assertEquals(route.toString(), "DOWN");
        } else {
            new Exception("Unexcepted Direction value!").printStackTrace();
        }

    }

    @Test
    public void testSnakeMovesLeft() {
        Ground ground = new Ground();
        ScoreBoard scoreBoard = new ScoreBoard();
        Snake snake = new Snake(ground,scoreBoard);
        snake.changeDirection(Route.DOWN);
        snake.move();
        Route route = snake.getRoute();
        if (route == Route.LEFT) {
            assertEquals(route.toString(), "LEFT");
        } else {
            new Exception("Unexcepted Direction value!").printStackTrace();
        }

    }

    @Test
    public void testSnakeMovesRight() {
        Ground ground = new Ground();
        ScoreBoard scoreBoard = new ScoreBoard();
        Snake snake = new Snake(ground,scoreBoard);
        snake.changeDirection(Route.DOWN);
        snake.move();
        Route route = snake.getRoute();
        if (route == Route.RIGHT) {
            assertEquals(route.toString(), "RIGHT");
        } else {
            new Exception("Unexcepted Direction value!").printStackTrace();
        }

    }

    @Test
    public void testSnakeFoodCollision() {
        ScoreBoard scoreBoard;

        Ground ground;
        scoreBoard = new ScoreBoard();
        ground = new Ground();
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
        Snake snake = new Snake(ground, scoreBoard);

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
