package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
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
	public Error getPutCoordinateError(Coordinate coordinate) {
		this.tcpip.send(FrameType.ERRORS_PUT.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveError();
	}

	@Override
	public Error getMoveOriginCoordinateError(Coordinate coordinate) {
		this.tcpip.send(FrameType.ERRORS_MOVE_ORIGIN.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveError();
	}

	@Override
	public Error getMoveTargetCoordinateError(Coordinate originCoordinate, Coordinate targetCoordinate) {
		this.tcpip.send(FrameType.ERRORS_MOVE_TARGET.name());
		this.tcpip.send(originCoordinate.getRow());
		this.tcpip.send(originCoordinate.getColumn());
		this.tcpip.send(targetCoordinate.getRow());
		this.tcpip.send(targetCoordinate.getColumn());
		return this.tcpip.receiveError();
	}

	@Override
	public boolean isCoordinateValid(Coordinate coordinate) {
		this.tcpip.send(FrameType.COORDINATE_VALID.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public Coordinate generateRandomCoordinate() {
		this.tcpip.send(FrameType.RANDOM_COORDINATE.name());
		int rowCoordinate = this.tcpip.receiveInt();
		int columnCoordinate = this.tcpip.receiveInt();
		return new Coordinate(rowCoordinate, columnCoordinate);
	}

	@Override
	public boolean isBoardComplete() {
		this.tcpip.send(FrameType.BOARD_COMPLETE.name());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public void putTokenPlayerFromTurn(Coordinate coordinate) {
		this.tcpip.send(FrameType.PUT_TOKEN.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
	}

	@Override
	public void moveTokenPlayerFromTurn(Coordinate[] coordinates) {
		this.tcpip.send(FrameType.MOVE_TOKEN.name());
		this.tcpip.send(coordinates[0].getRow());
		this.tcpip.send(coordinates[0].getColumn());
		this.tcpip.send(coordinates[1].getRow());
		this.tcpip.send(coordinates[1].getColumn());
	}

	@Override
	public void changeTurn() {
		this.tcpip.send(FrameType.CHANGE_TURN.name());
	}

	@Override
	public char getTokenChar(Coordinate coordinate) {
		this.tcpip.send(FrameType.TOKEN_CHAR.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveChar();
	}

	@Override
	public boolean isEmptyToken(Coordinate coordinate) {
		this.tcpip.send(FrameType.EMPTY_TOKEN.name());
		this.tcpip.send(coordinate.getRow());
		this.tcpip.send(coordinate.getColumn());
		return this.tcpip.receiveBoolean();
	}

	@Override
	public int getCoordinateDimension() {
		this.tcpip.send(FrameType.DIMENSION.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public int getValueFromTurn() {
		this.tcpip.send(FrameType.VALUE_TURN.name());
		return this.tcpip.receiveInt();
	}

	@Override
	public void continueState() {
		this.tcpip.send(FrameType.CONTINUE_STATE.name());
	}

	@Override
	public boolean isTicTacToe() {
		this.tcpip.send(FrameType.TICTACTOE.name());
		return tcpip.receiveBoolean();
	}

}
