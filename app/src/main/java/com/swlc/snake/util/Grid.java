package com.swlc.snake.util;

import java.awt.*;

/**
 * @author Chanuka Sandaruwan
 * @created 03/08/2021 - 11:16 pm
 * @project swlc-snake-game
 */

/**
 * This class simplifies the use of the GridBagConstraints class.
 */

public class Grid extends GridBagConstraints {

    public Grid(int gridX, int gridY) {
        this.gridx = gridX;
        this.gridy = gridY;
    }

    public Grid(int gridX, int gridY, int gridWidth, int gridHeight) {
        this(gridX, gridY);
        this.gridwidth = gridWidth;
        this.gridheight = gridHeight;
    }

}
