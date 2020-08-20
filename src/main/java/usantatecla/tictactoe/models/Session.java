package usantatecla.tictactoe.models;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class Session {
    
    private State state;
	
	private Game game;
	
    private Registry registry;
    
    public Session() {
		this.state = new State();
		this.game = new Game();
		this.registry = new Registry(this.game);
	}

	public void next() {
		this.state.next();		
    }
    
    public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo(this.game);
	}

	public void redo() {
		this.registry.redo(this.game);
    }
    
    public void createPlayers(int numberOfUsers) {
        this.game.createPlayers(numberOfUsers);
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.game.getTypeOfTokenPlayerFromTurn();
	}

	public Error getErrorsPutCoordinate(Coordinate coordinate) {
		return this.game.getErrorsPutCoordinate(coordinate);
	}

	public Error getErrorsMoveOriginCoordinate(Coordinate originCoordinate) {
		return this.game.getErrorsMoveOriginCoordinate(originCoordinate);
	}

	public Error getErrorsMoveTargetCoordinate(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.game.getErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
	}

    public boolean isBoardComplete() {
        return this.game.isBoardComplete();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        this.game.putTokenPlayerFromTurn(coordinate);
        this.registry.registry();
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        this.game.moveTokenPlayerFromTurn(coordinates);
        this.registry.registry();
    }

    public void changeTurn() {
        this.game.changeTurn();
    }

    public Token getToken(int row, int column) {
		return this.game.getToken(row, column);
	}

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public int getOtherValueFromTurn() {
        return this.game.getOtherValueFromTurn();
    }

    public StateValue getValueState() {
		return this.state.getValueState();
	}
}