package com.swlc.snake.handler;

import com.swlc.snake.view.Food;
import com.swlc.snake.view.Ground;
import com.swlc.snake.main.Main;
import com.swlc.snake.view.Snake;

import static com.swlc.snake.constant.Constants.DELAY;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 11:15 pm
 * @project swlc-snake-game
 */
public class SnakeHandler implements Runnable {


    private final Main main;
    private final Ground gameGround;
    private final Snake snake;

    /**
     * Constructs a new runnable Game object which can be used to create
     * a Thread.
     *
     * @param gameGround The rectangular area where snake can move
     * @param snake      The snake object
     * @param main       The frame which will be notified when the game is over
     */

    public SnakeHandler(Ground gameGround, Snake snake, Main main) {
        Food food = new Food(getNew(), getNew());
        this.main = main;
        this.snake = snake;
        this.gameGround = gameGround;

        this.gameGround.setSnakeParts(snake.getParts());
        this.gameGround.setFood(food);
    }

    private double getNew() {
        double d = 1111;

        while (d >= 500 || d % 20 != 0) {
            d = Math.random() * 1000;
            d = (int) d;
        }
        return d;
    }


    @Override
    public void run() {
        try {
            while (true) {
                snake.move();
                snake.check();
                if (snake.isGameOver()) {
                    Thread.currentThread().interrupt();
                }
                if (!Thread.currentThread().isInterrupted()) {
                    gameGround.repaint();
                }
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException ex) {
            main.gameOver();
        }
    }
}
