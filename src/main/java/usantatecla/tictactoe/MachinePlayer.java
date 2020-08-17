package usantatecla.tictactoe;

class MachinePlayer extends Player {

	MachinePlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	Error readCoordinateToPut(Coordinate coordinate) {
		coordinate.random();
		return getErrorsPutCoordinate(coordinate);
	}

	@Override
	Error readCoordinateOriginToRemove(Coordinate coordinate) {
		coordinate.random();
		return getErrorsMoveOriginCoordinate(coordinate);
	}

	@Override
	Error readCoordinateTargetToMove(Coordinate originCoordinate, Coordinate targetCoordinate) {
		targetCoordinate.random();
		return getErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}
}
