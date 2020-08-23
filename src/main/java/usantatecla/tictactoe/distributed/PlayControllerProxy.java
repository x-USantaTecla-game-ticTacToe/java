package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Session;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.types.PlayerType;
import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.distributed.dispatchers.TCPIP;

public class PlayControllerProxy extends PlayController {

	private TCPIP tcpip;

	PlayControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void undo() {
		this.tcpip.send(FrameType.UNDO.name());
	}

	@Override
	public void redo() {
		this.tcpip.send(FrameType.REDO.name());
	}

	@Override
	public boolean undoable() {
		this.tcpip.send(FrameType.UNDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public boolean redoable() {
		this.tcpip.send(FrameType.REDOABLE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public PlayerType getTypeOfTokenPlayerFromTurn() {
		this.tcpip.send(FrameType.PLAYER_TYPE.name());
		return this.tcpip.receivePlayerType();
	}

	@Override
	public Error controlErrorsPutCoordinate(int row, int column) {
		this.tcpip.send(FrameType.ERRORS_PUT.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveError();
	}

	@Override
	public Error controlErrorsMoveOriginCoordinate(int originRow, int originColumn) {
		this.tcpip.send(FrameType.ERRORS_MOVE_ORIGIN.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
		return this.tcpip.receiveError();
	}

	@Override
	public Error controlErrorsMoveTargetCoordinate(int originRow, int originColumn, int targetRow, int targetColumn) {
		this.tcpip.send(FrameType.ERRORS_MOVE_TARGET.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
		this.tcpip.send(targetRow);
		this.tcpip.send(targetColumn);
		return this.tcpip.receiveError();
	}

	@Override
	public boolean isCoordinateValid(int row, int column) {
		this.tcpip.send(FrameType.COORDINATE_VALID.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveBoolean();
	}

	@Override
	public int[] generateRandomCoordinate() {
		this.tcpip.send(FrameType.RANDOM_COORDINATE.name());
		int[] coordinate = new int[2];
		coordinate[0] = this.tcpip.receiveInt();
		coordinate[1] = this.tcpip.receiveInt();
		return coordinate;
	}

	@Override
	public boolean isBoardComplete() {
		this.tcpip.send(FrameType.BOARD_COMPLETE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public void putTokenPlayerFromTurn(int originRow, int originColumn) {
		this.tcpip.send(FrameType.PUT_TOKEN.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
	}

	@Override
	public void moveTokenPlayerFromTurn(int originRow, int originColumn, int targetRow, int targetColumn) {
		this.tcpip.send(FrameType.MOVE_TOKEN.name());
		this.tcpip.send(originRow);
		this.tcpip.send(originColumn);
		this.tcpip.send(targetRow);
		this.tcpip.send(targetColumn);
	}

	@Override
	public void changeTurn() {
		this.tcpip.send(FrameType.CHANGE_TURN.name());
	}

	@Override
	public char getTokenChar(int row, int column) {
		this.tcpip.send(FrameType.TOKEN_CHAR.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveChar();
	}

	@Override
	public boolean isEmptyToken(int row, int column) {
		this.tcpip.send(FrameType.EMPTY_TOKEN.name());
		this.tcpip.send(row);
		this.tcpip.send(column);
		return this.tcpip.receiveBoolean();
	}

	@Override
	public int getCoordinateDimension() {
		this.tcpip.send(FrameType.DIMENSION.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public void isTicTacToe() {
		this.tcpip.send(FrameType.TICTACTOE.name());
	}

}
