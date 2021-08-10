package com.swlc.snake.test;

import com.swlc.snake.constant.Route;
import com.swlc.snake.handler.SnakeHandler;
import com.swlc.snake.util.Grid;
import com.swlc.snake.view.Ground;
import com.swlc.snake.view.ScoreBoard;
import com.swlc.snake.view.Snake;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Chanuka Sandaruwan
 * @created 10/08/2021 - 08:34 pm
 * @project swlc-snake-game
 */
public class MainTest extends JFrame {

    private Route route = Route.UP;
    private ScoreBoard scoreBoard;
    private Ground ground;
    private Thread thread;
    private Snake snake;
    private boolean started = false;

    @Test
    public void main() {
        initComponents();
        initGame();
        initFrame();
    }

    @Test
    public void initComponents() {
        setLayout(new GridBagLayout());
        addKeyListener(new KeyboardHandler());

        ground = new Ground();
        add(ground, new Grid(0, 0, 8, 8));

        scoreBoard = new ScoreBoard();
        add(scoreBoard, new Grid(0, 8, 8, 1));

    }

    @Test
    public void initGame() {
        snake = new Snake(ground, scoreBoard);
        Runnable r = new SnakeHandler(ground, snake, null);
        thread = new Thread(r);
    }

    @Test
    public void initFrame() {
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Test
    public void newGame() {
        started = true;
        thread.start();
    }

    @Test
    public void gameOver() {
        int returnValue = JOptionPane.showConfirmDialog(this,
                "Your score is " + scoreBoard.getScore() + "\n Do you want to start a new game?", "GAME OVER!", JOptionPane
                        .OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (returnValue == JOptionPane.OK_OPTION) {
            route = Route.UP;
            started = false;
            snake = new Snake(ground, scoreBoard);
            scoreBoard.clear();
            ground.initDefaults();
            scoreBoard.repaint();
            ground.repaint();
            Runnable r = new SnakeHandler(ground, snake, null);
            thread = null;
            thread = new Thread(r);
        } else {
            System.exit(0);
        }
    }

    private class KeyboardHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (route == Route.DOWN) return;
                if (!started) newGame();
                if (snake != null) {
                    snake.changeDirection(Route.UP);
                    route = Route.UP;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (route == Route.UP) return;
                if (!started) newGame();
                if (snake != null) {
                    snake.changeDirection(Route.DOWN);
                    route = Route.DOWN;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (route == Route.RIGHT) return;
                if (!started) newGame();
                if (snake != null) {
                    snake.changeDirection(Route.LEFT);
                    route = Route.LEFT;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (route == Route.LEFT) return;
                if (!started) newGame();
                if (snake != null) {
                    snake.changeDirection(Route.RIGHT);
                    route = Route.RIGHT;
                }
            }
        }
    }
}
