package usantatecla.tictactoe;

class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	private Coordinate getCoordinate(Message message){
		assert message != null;
		
		Coordinate coordinate = new ConcreteCoordinate();
		coordinate.read(message.toString());
		return coordinate;
	}
	
	@Override
	Coordinate getCoordinateToPut() {
		return this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
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
		assert coordinate != null;
		
		Error error = super.checkPutCoordinateError(coordinate);
		error.writeln();
		return error;
	}
	
	@Override
	Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
		assert originCoordinate != null;
		
		Error error = super.checkMoveOriginCoordinateError(originCoordinate);
		error.writeln();
		return error;
	}

	@Override
	Error checkMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		assert originCoordinate != null;
		assert targetCoordinate != null;
		
		Error error = super.checkMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		error.writeln();
		return error;
	}

}
