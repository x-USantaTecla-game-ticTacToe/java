package usantatecla.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import usantatecla.utils.Direction;

class Board {

	private Token[][] tokens;

	public Board(){
		this.reset();
	}

	void reset() {
		this.tokens = new Token[Coordinate.DIMENSION][Coordinate.DIMENSION];
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				this.tokens[i][j] = Token.NULL;
			}
		}
	}

	Token getToken(Coordinate coordinate) {
		assert coordinate != null && !coordinate.isNull();

		return this.tokens[coordinate.getRow()][coordinate.getColumn()];
	}

	boolean isCompleted() {
		int tokensCount = 0;
		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (!this.tokens[i][j].isNull()) {
					tokensCount++;
				}
			}
		}
		return tokensCount == Coordinate.DIMENSION*2;
	}

	void put(Coordinate coordinate, Token token) {
		assert coordinate != null && !coordinate.isNull();
		assert token != null;
		assert !this.isCompleted();

		this.tokens[coordinate.getRow()][coordinate.getColumn()] = token;
	}

	void move(Coordinate origin, Coordinate target) {
		assert origin != null && !origin.isNull();
		assert target != null && !target.isNull();
		assert !origin.equals(target);

		Token token = this.getToken(origin);
		this.remove(origin);
		this.put(target, token);
	}

	private void remove(Coordinate coordinate) {
		this.put(coordinate, Token.NULL);
	}

	boolean isOccupied(Coordinate coordinate, Token token) {
		assert coordinate != null && !coordinate.isNull();

		return this.getToken(coordinate) == token;
	}

	boolean isEmpty(Coordinate coordinate) {
		assert coordinate != null && !coordinate.isNull();

		return this.isOccupied(coordinate, Token.NULL);
	}

	boolean isTicTacToe(Token token) {
		assert token != null && !token.isNull();

		List<Coordinate> coordinates = this.getCoordinates(token);
		if (coordinates.size() < Coordinate.DIMENSION) {
			return false;
		}
		Direction previous = null;
		for (int i = 0; i < Coordinate.DIMENSION-1; i++) {
			Direction actual = coordinates.get(i).getDirection(coordinates.get(i + 1));
			if (i == 0) {
				if (actual == Direction.NULL){
					return false;
				}
			} else 
				if (actual != previous) {
					return false;
			}
			previous = actual;
		}
		return true;
	}

	private List<Coordinate> getCoordinates(Token token) {
		List<Coordinate> coordinates = new ArrayList<Coordinate>();

		for (int i = 0; i < Coordinate.DIMENSION; i++) {
			for (int j = 0; j < Coordinate.DIMENSION; j++) {
				if (this.tokens[i][j] == token) {
					coordinates.add(new Coordinate(i, j));
				}
			}
		}
		return coordinates;
	}

}