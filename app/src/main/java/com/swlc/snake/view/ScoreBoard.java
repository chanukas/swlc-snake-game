package com.swlc.snake.view;

import javax.swing.*;
import java.awt.*;

import static com.swlc.snake.constant.Constants.SCORE_PANEL_HEIGHT;
import static com.swlc.snake.constant.Constants.SCORE_PANEL_WIDTH;

/**
 * @author Chanuka Sandaruwan
 * @created 01/08/2021 - 10:53 pm
 * @project swlc-snake-game
 */


/**
 * This panel is responsible for displaying the current score of the user.
 *
 */

public class ScoreBoard extends JPanel {


    private final Font FONT;
    private String score;

    public ScoreBoard() {
        setPreferredSize(new Dimension(SCORE_PANEL_WIDTH, SCORE_PANEL_HEIGHT));
        setBackground(Color.BLUE);

        score = "0";
        FONT = new Font("SansSerif", Font.BOLD, 20);
    }

    /**
     * Update current score.
     * @param points The amount of points
     */

    public void addPoints(int points) {
        int oldValue = Integer.parseInt(score);
        oldValue += points;
        score = new String(oldValue + "");
        repaint();
    }

    /**
     * Clears the score back to its intial value of 0
     */

    public void clear() {
        score = "0";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(FONT);
        g2.setPaint(Color.white);
        String SCORE_LABEL = "SCORE:";
        g2.drawString(SCORE_LABEL, 15, 32);
        g2.setPaint(Color.red);
        g2.drawString(score, 105, 32);
    }

    public String getScore() {
        return score;
    }

}
