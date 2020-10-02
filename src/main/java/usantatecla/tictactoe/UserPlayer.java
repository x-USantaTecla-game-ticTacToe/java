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
	protected Error checkMoveOriginCoordinateError(Coordinate originCoordinate) {
		assert originCoordinate != null;
		
		Error error = super.checkMoveOriginCoordinateError(originCoordinate);
		error.writeln();
		return error;
	}

	@Override
	protected Error checkMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		assert originCoordinate != null;
		assert targetCoordinate != null;
		
		Error error = super.checkMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		error.writeln();
		return error;
	}

}
