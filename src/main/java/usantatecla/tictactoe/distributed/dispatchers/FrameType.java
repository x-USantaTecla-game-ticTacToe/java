package usantatecla.tictactoe.distributed.dispatchers;

public enum FrameType { 
	START,
	START_NAME,
	CREATE_PLAYERS,
	STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	CLOSE,
	PLAYER_TYPE,
	RESULT,
	COORDINATE_VALID,
	BOARD_COMPLETE,
	RANDOM_COORDINATE,
	CHANGE_TURN,
	TOKEN_CHAR,
	EMPTY_TOKEN,
	DIMENSION,
	TICTACTOE,
	IS_TICTACTOE,
	ERRORS_PUT,
	ERRORS_MOVE_ORIGIN,
	ERRORS_MOVE_TARGET,
	PUT_TOKEN,
	MOVE_TOKEN,
	OTHER_VALUE_TURN,
	SAVE,
	SAVE_NAMED,
	NEXT,
	HAS_NAME,
	EXISTS,
	TITLES;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
