package usantatecla.tictactoe.views.graphics;

import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
class Constraints extends GridBagConstraints {

	Constraints(int gridX, int gridY, int gridWidth, int gridHeight) {
		this.gridx = gridX;
		this.gridy = gridY;
		this.gridwidth = gridWidth;
		this.gridheight = gridHeight;
		this.fill = 1;
	}

}
