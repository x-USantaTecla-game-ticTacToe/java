package usantatecla.tictactoe;

class MachinePlayer extends Player {

	MachinePlayer(Token token, Board board) {		
		super(token, board);
	}

	protected Coordinate getCoordinate(Message message){
		assert message != null;
		
		Coordinate coordinate = new Coordinate();
		coordinate.random();
		return coordinate;
	}	
	
}
