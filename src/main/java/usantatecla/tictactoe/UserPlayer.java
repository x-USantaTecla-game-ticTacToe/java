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
	protected Error checkMoveTargetCoordinateError(Coordinate origin, Coordinate target) {
		assert origin != null && !origin.isNull();
		assert target != null && !target.isNull();
		
		Error error = super.checkMoveTargetCoordinateError(origin, target);
		error.writeln();
		return error;
	}

}
