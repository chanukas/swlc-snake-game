package com.swlc.snake;

import java.awt.*;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 11:16 pm
 * @project swlc-snake-game
 */
public class Grid extends GridBagConstraints {

    public Grid(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    public Grid(int gridx, int gridy, int gridwidth, int gridheight) {
        this(gridx, gridy);
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

}
