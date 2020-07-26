package usantatecla.tictactoe;

class MachinePlayer extends Player {

	MachinePlayer(Token token, Board board) {
		super(token, board);
	}

	@Override
	void put() {
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			coordinate.random();
			error = controlErrorsPutCoordinate(coordinate);
		} while (error != null);
		board.put(coordinate, this.token);
	}

	@Override
	void move() {
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			originCoordinate.random();
			error = controlErrorsMoveOriginCoordinate(originCoordinate);
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			targetCoordinate.random();
			error = controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
		} while (error != null);
		board.move(originCoordinate, targetCoordinate);
	}
}
