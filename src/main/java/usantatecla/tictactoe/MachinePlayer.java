package usantatecla.tictactoe;

class MachinePlayer extends Player {

	MachinePlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	Coordinate getCoordinateToPut() {
		return this.getCoordinate(Message.COORDINATE_TO_PUT);
	}

	private Coordinate getCoordinate(Message message){
		Coordinate coordinate = new ConcreteCoordinate();
		coordinate.random();
		return coordinate;
	}

	@Override
	Coordinate getCoordinateOriginToRemove() {
		return this.getCoordinate(Message.COORDINATE_TO_REMOVE);
	}

	@Override
	Coordinate getCoordinateTargetToMove() {
		return this.getCoordinate(Message.COORDINATE_TO_MOVE);
	}

}
