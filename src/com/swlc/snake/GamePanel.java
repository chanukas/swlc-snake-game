package com.swlc.snake;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 11:15 pm
 * @project swlc-snake-game
 */
public class GamePanel implements Runnable{

    public static final int DELAY = 500;

    private final Main main;
    private final GameFiled gameField;
    private final Snake snake;

    public GamePanel(GameFiled gameField, Snake snake, Main main) {
        Food food = new Food(120, 120);
        this.main = main;
        this.snake = snake;
        this.gameField = gameField;

        this.gameField.setSnakeParts(snake.getParts());
        this.gameField.setFood(food);
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
                    gameField.repaint();
                }
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException ex) {
            main.gameOver();
        }
    }

}
