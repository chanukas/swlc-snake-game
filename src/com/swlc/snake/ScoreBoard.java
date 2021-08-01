package com.swlc.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author Chanuka Sandaruwan
 * @created 01/08/2021 - 10:53 pm
 * @project swlc-snake-game
 */

public class ScoreBoard extends JPanel {

    public static final int PANEL_WIDTH = 500;
    public static final int PANEL_HEIGHT = 50;

    private final Font FONT;
    private final String SCORE_LABEL = "SCORE:";
    private String score;

    public ScoreBoard() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.BLUE);

        score = "0";
        FONT = new Font("SansSerif", Font.BOLD, 20);
    }

    public void addPoints(int points) {
        int oldValue = Integer.parseInt(score);
        oldValue += points;
        score = new String(oldValue + "");
        repaint();
    }

    public void clear() {
        score = "0";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(FONT);
        g2.setPaint(Color.white);
        g2.drawString(SCORE_LABEL, 15, 32);
        g2.setPaint(Color.red);
        g2.drawString(score, 105, 32);
    }

    public String getScore(){
        return score;
    }

}
