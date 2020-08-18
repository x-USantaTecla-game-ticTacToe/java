package usantatecla.tictactoe;

class UserPlayer extends Player {

	static final String ENTER_COORDINATE_TO_PUT = "Enter a coordinate to put a token:";
	static final String ENTER_COORDINATE_TO_REMOVE = "Enter a coordinate to remove a token:";

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	Error readCoordinateToPut(Coordinate coordinate) {
		coordinate.read(ENTER_COORDINATE_TO_PUT);
		Error error = this.getErrorsPutCoordinate(coordinate);
		this.writeErrorWhenNotNull(error);
		return error;
	}

	@Override
	Error readCoordinateOriginToRemove(Coordinate coordinate) {
		coordinate.read(ENTER_COORDINATE_TO_REMOVE);
		Error error = this.getErrorsMoveOriginCoordinate(coordinate);
		this.writeErrorWhenNotNull(error);
		return error;
	}

	@Override
	Error readCoordinateTargetToMove(Coordinate originCoordinate, Coordinate targetCoordinate) {
		targetCoordinate.read(ENTER_COORDINATE_TO_PUT);
		Error error = this.getErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
		this.writeErrorWhenNotNull(error);
		return error;
	}

	private void writeErrorWhenNotNull(Error error) {
		if (error != null) {
			error.writeln();
		}
	}

}
