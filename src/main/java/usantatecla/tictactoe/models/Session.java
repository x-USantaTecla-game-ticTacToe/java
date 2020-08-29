package usantatecla.tictactoe.models;

import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;
import usantatecla.utils.TCPIP;

public class Session {
    
    private State state;
	
	private Game game;
	
    private Registry registry;

    private TCPIP tcpip;
    
    public Session(TCPIP tcpip) {
		this.state = new State();
		this.game = new Game();
        this.registry = new Registry(this.game);
        this.tcpip = tcpip;
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
        this.registry.registry();
    }

    public PlayerType getTypeOfTokenPlayerFromTurn() {
		return this.game.getTypeOfTokenPlayerFromTurn();
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		return this.game.getPutCoordinateError(coordinate);
	}

	public Error getMoveOriginCoordinateError(Coordinate originCoordinate) {
		return this.game.getMoveOriginCoordinateError(originCoordinate);
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		return this.game.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
	}

    public boolean isBoardComplete() {
        return this.game.isBoardComplete();
    }

    public void putTokenPlayerFromTurn(Coordinate coordinate) {
        this.game.putTokenPlayerFromTurn(coordinate);
        this.changeTurn();
        this.registry.registry();
    }

    public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
        this.game.moveTokenPlayerFromTurn(coordinates);
        this.changeTurn();
        this.registry.registry();
    }

    public void changeTurn() {
        this.game.changeTurn();
    }

    public Token getToken(Coordinate coordinate) {
		return this.game.getToken(coordinate);
	}

    public boolean isTicTacToe() {
        return this.game.isTicTacToe();
    }

    public int getValueFromTurn() {
        return this.game.getValueFromTurn();
    }

    public StateValue getValueState() {
		if (this.tcpip == null) {
			return this.state.getValueState();
		}
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
    }
    
    public void newGame() {
        this.game.newGame();
        this.state.reset();	
        this.registry.reset();	
    }
}