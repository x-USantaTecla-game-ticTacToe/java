package usantatecla.tictactoe.models;

public class Player {

	private Token token;

	private Board board;

	private PlayerType type;

	public Player(Token token, Board board, PlayerType type) {
		this.token = token;
		this.board = board;
		this.type = type;
	}

	public PlayerType getType() {
		return this.type;
	}

	void put(Coordinate coordinate) {
		this.board.put(coordinate, this.token);
	};

	void move(Coordinate[] coordinates) {
		this.board.move(coordinates[0], coordinates[1]);
	};

	Token getToken() {
		return this.token;
	}

	public Error controlErrorsPutCoordinate(Coordinate coordinate) {
		if (!board.isEmpty(coordinate)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error controlErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		if (!board.isOccupied(originCoordinate, this.token)) {
			return Error.NOT_OWNER;
		}
		return null;
	}

	public Error controlErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (originCoordinate.equals(targetCoordinate)) {
			return Error.SAME_COORDINATES;
		} else if (!board.isEmpty(targetCoordinate)) {
			return Error.NOT_EMPTY;
		}
		return null;
	}

}
