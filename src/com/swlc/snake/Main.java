package com.swlc.snake;

import javax.swing.*;
import java.awt.*;


/**
 * @author Chanuka Sandaruwan
 * @created 01/08/2021 - 10:51 pm
 * @project swlc-snake-game
 */

public class Main extends JFrame {

    private ScoreBoard scoreBoard;
    private Thread thread;
    private Snake snake;

    // Current Routing of the snake
    private Route direction = Route.UP;

    private boolean started = false;


    private void initFrame() {
        pack();
        setTitle("SWLC Snake Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void newGame() {
        started = true;
        thread.start();
    }

    public void gameOver() {


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }


}
