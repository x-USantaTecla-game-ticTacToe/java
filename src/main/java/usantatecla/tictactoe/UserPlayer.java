package usantatecla.tictactoe;

class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	Coordinate getCoordinateToPut() {
		return this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
	}

	private Coordinate getCoordinate(Message message){
		Coordinate coordinate = new ConcreteCoordinate();
		coordinate.read(message.toString());
		return coordinate;
	}

	@Override
	Coordinate getCoordinateOriginToRemove() {
		return this.getCoordinate(Message.ENTER_COORDINATE_TO_REMOVE);
	}

	@Override
	Coordinate getCoordinateTargetToMove() {
		return this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
	}
	
	@Override
	Error checkPutCoordinateError(Coordinate coordinate) {
		Error error = super.checkPutCoordinateError(coordinate);
		error.writeln();
		return error;
	}
	
	@Override
	Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
		Error error = super.checkMoveOriginCoordinateError(originCoordinate);
		error.writeln();
		return error;
	}

	@Override
	Error checkMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		Error error = super.checkMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		error.writeln();
		return error;
	}

}
