package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.distributed.dispatchers.TCPIP;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;

public class PlayController extends AcceptorController {

	private MovementController movementController;

	private UndoController undoController;

	private RedoController redoController;
    
    public PlayController(Session session, TCPIP tcpip) {
		super(session, tcpip);
		if (tcpip == null) {
			this.movementController = new MovementController(this.session);
			this.undoController = new UndoController(this.session);
			this.redoController = new RedoController(this.session);
		}
	}

	public void undo() {
		if (this.tcpip == null) {
			this.undoController.undo();
		} else {
			this.tcpip.send(FrameType.UNDO.name());
		}
	}

	public void redo() {
		if (this.tcpip == null) {
			this.redoController.redo();
		} else {
			this.tcpip.send(FrameType.REDO.name());
		}
	}

	public boolean undoable() {
		if (this.tcpip == null) {
			return this.undoController.undoable();
		}
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	public boolean redoable() {
		if (this.tcpip == null) {
			return this.redoController.redoable();
		}
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	public PlayerType getTypeOfTokenPlayerFromTurn() {
		if (this.tcpip == null) {
			return this.movementController.getTypeOfTokenPlayerFromTurn();
		}
		this.tcpip.send(FrameType.PLAYER_TYPE.name());
		return this.tcpip.receivePlayerType();
	}

	public Error getPutCoordinateError(Coordinate coordinate) {
		if (this.tcpip == null) {
			return this.movementController.getPutCoordinateError(coordinate);
		}
		this.tcpip.send(FrameType.ERRORS_PUT.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveError();
	}

	public Error getMoveOriginCoordinateError(Coordinate coordinate) {
		if (this.tcpip == null) {
			return this.movementController.getMoveOriginCoordinateError(coordinate);
		}
		this.tcpip.send(FrameType.ERRORS_MOVE_ORIGIN.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveError();
	}

	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		if (this.tcpip == null) {
			return this.movementController.getMoveTargetCoordinateError(originCoordinate, targetCoordinate);
		}
		this.tcpip.send(FrameType.ERRORS_MOVE_TARGET.name());
		this.tcpip.send(originCoordinate.getRow());
		this.tcpip.send(originCoordinate.getColumn());
		this.tcpip.send(targetCoordinate.getRow());
		this.tcpip.send(targetCoordinate.getColumn());
		return this.tcpip.receiveError();
	}

	public boolean isCoordinateValid(Coordinate coordinate) {
		if (this.tcpip == null) {
			return this.movementController.isCoordinateValid(coordinate);
		}
		this.tcpip.send(FrameType.COORDINATE_VALID.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveBoolean();
	}

	public Coordinate generateRandomCoordinate() {
		if (this.tcpip == null) {
			return this.movementController.generateRandomCoordinate();
		}
		this.tcpip.send(FrameType.RANDOM_COORDINATE.name());
		int rowCoordinate = this.tcpip.receiveInt();
		int columnCoordinate = this.tcpip.receiveInt();
		return new Coordinate(rowCoordinate, columnCoordinate);
	}

	public boolean isBoardComplete() {
		if (this.tcpip == null) {
			return this.movementController.isBoardComplete();
		}
		this.tcpip.send(FrameType.BOARD_COMPLETE.name());
		return this.tcpip.receiveBoolean();
	}

	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		if (this.tcpip == null) {
			this.movementController.putTokenPlayerFromTurn(coordinate);
		} else {
			this.tcpip.send(FrameType.PUT_TOKEN.name());
			this.tcpip.send(coordinate.getRow());
			this.tcpip.send(coordinate.getColumn());
		}
	}

	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		if (this.tcpip == null) {
			this.movementController.moveTokenPlayerFromTurn(coordinates);
		} else {
			this.tcpip.send(FrameType.MOVE_TOKEN.name());
			this.tcpip.send(coordinates[0].getRow());
			this.tcpip.send(coordinates[0].getColumn());
			this.tcpip.send(coordinates[1].getRow());
			this.tcpip.send(coordinates[1].getColumn());
		}
	}

	public void changeTurn() {
		if (this.tcpip == null) {
			this.movementController.changeTurn();
		} else {
			this.tcpip.send(FrameType.CHANGE_TURN.name());
		}
	}

	public char getTokenChar(Coordinate coordinate) {
		if (this.tcpip == null) {
			return this.movementController.getTokenChar(coordinate);
		}
		this.tcpip.send(FrameType.TOKEN_CHAR.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveChar();
	}

	public boolean isEmptyToken(Coordinate coordinate) {
		if (this.tcpip == null) {
			return this.movementController.isEmptyToken(coordinate);
		}
		this.tcpip.send(FrameType.EMPTY_TOKEN.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveBoolean();
	}

	public int getCoordinateDimension() {
		if (this.tcpip == null) {
			return Coordinate.DIMENSION;
		}
		this.tcpip.send(FrameType.DIMENSION.name());
		return this.tcpip.receiveInt();
	}

	public int getValueFromTurn() {
		if (this.tcpip == null) {
			return this.movementController.getValueFromTurn();
		}
		this.tcpip.send(FrameType.VALUE_TURN.name());
		return this.tcpip.receiveInt();
    }

	public boolean isTicTacToe() {
		if (this.tcpip == null) {
			return this.movementController.isTicTacToe();
		}
		this.tcpip.send(FrameType.TICTACTOE.name());
		return this.tcpip.receiveBoolean();
	}

	public void continueState() {
		if (this.tcpip == null) {
			this.movementController.continueState();
		} else {
			this.tcpip.send(FrameType.CONTINUE_STATE.name());
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}