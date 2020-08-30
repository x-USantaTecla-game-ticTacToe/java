package usantatecla.tictactoe.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.types.StateValue;
import usantatecla.tictactoe.types.Token;

public class SessionImplementation implements Session {

	public static final String EXTENSION = ".mm";

	public static final String DIRECTORY = "./partidas";

	private static File directory;

	static {
		SessionImplementation.directory = new File(SessionImplementation.DIRECTORY);
	}

	private State state;
	
	private Game game;
	
	private Registry registry;

	private String name;
	
	public SessionImplementation() {
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
		return this.state.getValueState();
	}

	public void load(String name) {
		this.name = name;
		File file = new File(SessionImplementation.directory, name);
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			this.game.load(bufferedReader);
			this.registry.reset();
			this.registry.registry();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.state.setValueState(StateValue.IN_GAME);
		if (this.isTicTacToe()) {
			this.state.setValueState(StateValue.RESUME);
		}
	}

	public void save() {
		this.save(this.name);
	}

	public void save(String name) {
		if (name.endsWith(SessionImplementation.EXTENSION)) {
			name = name.replace(SessionImplementation.EXTENSION, "");
		}
		File file = new File(SessionImplementation.directory, name + SessionImplementation.EXTENSION);
		try {
			FileWriter fileWriter = new FileWriter(file);
			this.game.save(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getGamesNames() {
		return SessionImplementation.directory.list();
	}

	public boolean exists(String name) {
		for (String auxName : this.getGamesNames()) {
			if (auxName.equals(name + SessionImplementation.EXTENSION)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasName() {
		return this.name != null;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void newGame() {
		this.game.newGame();
		this.state.reset();	
		this.registry.reset();
	}
}
