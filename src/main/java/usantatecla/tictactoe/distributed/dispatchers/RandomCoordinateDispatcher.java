package usantatecla.tictactoe.distributed.dispatchers;

import usantatecla.tictactoe.controllers.PlayController;

public class RandomCoordinateDispatcher extends Dispatcher {

    public RandomCoordinateDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
        int[] coordinate = ((PlayController)this.acceptorController).generateRandomCoordinate();
        this.tcpip.send(coordinate[0]);
        this.tcpip.send(coordinate[1]);
	}
    
}