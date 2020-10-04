package usantatecla.tictactoe;

class UserPlayer extends Player {

	UserPlayer(Token token, Board board) {
		super(token, board);
	}

	protected Coordinate getCoordinate(Message message){
		assert message != null;
		
		Coordinate coordinate = new Coordinate();
		coordinate.read(message.toString());
		return coordinate;
	}

	@Override
	protected Error checkPutCoordinateError(Coordinate coordinate) {
		assert coordinate != null;
		
		Error error = super.checkPutCoordinateError(coordinate);
		error.writeln();
		return error;
	}
	
	@Override
	protected Error checkMoveOriginCoordinateError(Coordinate origin) {
		assert origin != null;
		
		Error error = super.checkMoveOriginCoordinateError(origin);
		error.writeln();
		return error;
	}

	@Override
	protected Error checkMoveTargetCoordinateError(Coordinate origin, Coordinate targetCoordinate) {
		assert origin != null;
		assert targetCoordinate != null;
		
		Error error = super.checkMoveTargetCoordinateError(origin, targetCoordinate);
		error.writeln();
		return error;
	}

}
