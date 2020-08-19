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

	public Error controlErrorsPutCoordinate(int row, int column) {
		if (this.tcpip == null) {
			return this.movementController.getErrorsPutCoordinate(row, column);
		}
		this.tcpip.send(FrameType.ERRORS_PUT.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveError();
	}

	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		if (this.tcpip == null) {
			return this.movementController.getErrorsMoveOriginCoordinate(originRow, originColumn);
		}
		this.tcpip.send(FrameType.ERRORS_MOVE_ORIGIN.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
		return this.tcpip.receiveError();
	}

	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		if (this.tcpip == null) {
			return this.movementController.getErrorsMoveTargetCoordinate(originRow, originColumn, targetRow, targetColumn);
		}
		this.tcpip.send(FrameType.ERRORS_MOVE_TARGET.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
		this.tcpip.send(targetRow);
		this.tcpip.send(targetColumn);
		return this.tcpip.receiveError();
	}

	public boolean isCoordinateValid(int row, int column) {
		if (this.tcpip == null) {
			return this.movementController.isCoordinateValid(row, column);
		}
		this.tcpip.send(FrameType.COORDINATE_VALID.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveBoolean();
	}

	public int[] generateRandomCoordinate() {
		if (this.tcpip == null) {
			return this.movementController.generateRandomCoordinate();
		}
		this.tcpip.send(FrameType.RANDOM_COORDINATE.name());
		int[] coordinate = new int[2];
		coordinate[0] = this.tcpip.receiveInt();
		coordinate[1] = this.tcpip.receiveInt();
		return coordinate;
	}

	public boolean isBoardComplete() {
		if (this.tcpip == null) {
			return this.movementController.isBoardComplete();
		}
		this.tcpip.send(FrameType.BOARD_COMPLETE.name());
		return this.tcpip.receiveBoolean();
	}

	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		if (this.tcpip == null) {
			this.movementController.putTokenPlayerFromTurn(originRow, originColumn);
		} else {
			this.tcpip.send(FrameType.PUT_TOKEN.name());
			this.tcpip.send(originRow);
			this.tcpip.send(originColumn);
		}
	}

	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		if (this.tcpip == null) {
			this.movementController.moveTokenPlayerFromTurn(originRow, originColumn, targetRow, targetColumn);
		} else {
			this.tcpip.send(FrameType.MOVE_TOKEN.name());
			this.tcpip.send(originRow);
			this.tcpip.send(originColumn);
			this.tcpip.send(targetRow);
			this.tcpip.send(targetColumn);
		}
	}

	public void changeTurn() {
		if (this.tcpip == null) {
			this.movementController.changeTurn();
		} else {
			this.tcpip.send(FrameType.CHANGE_TURN.name());
		}
	}

	public char getTokenChar(int row, int column) {
		if (this.tcpip == null) {
			return this.movementController.getTokenChar(row, column);
		}
		this.tcpip.send(FrameType.TOKEN_CHAR.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveChar();
	}

	public boolean isEmptyToken(int row, int column) {
		if (this.tcpip == null) {
			return this.movementController.isEmptyToken(row, column);
		}
		this.tcpip.send(FrameType.EMPTY_TOKEN.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveBoolean();
	}

	public int getCoordinateDimension() {
		if (this.tcpip == null) {
			return Coordinate.DIMENSION;
		}
		this.tcpip.send(FrameType.DIMENSION.name());
		return this.tcpip.receiveInt();
	}

	public void isTicTacToe() {
		if (this.tcpip == null) {
			this.movementController.isTicTacToe();
		} else {
			this.tcpip.send(FrameType.TICTACTOE.name());
		}
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}