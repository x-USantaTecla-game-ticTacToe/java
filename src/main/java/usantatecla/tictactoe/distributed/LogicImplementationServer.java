package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.implementation.LogicImplementation;
import usantatecla.tictactoe.distributed.dispatchers.BoardCompleteDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.ChangeTurnDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.ContinueStateDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.CoordinateValidDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.CreatePlayersDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.DimensionDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.DispatcherPrototype;
import usantatecla.tictactoe.distributed.dispatchers.EmptyTokenDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.errors.ErrorsMoveOriginDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.errors.ErrorsMoveTargetDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.errors.ErrorsPutDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.save.ExistsDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.save.HasNameDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.save.NextDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.save.SaveDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.save.SaveNamedDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.distributed.dispatchers.MoveTokenDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.ValueTurnDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.PlayerTypeDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.PutTokenDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.RandomCoordinateDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.ResumeDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.StartDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.StartNameDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.StateDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.TicTacToeDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.TitlesDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.TokenCharDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.undoredo.RedoDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.undoredo.RedoableDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.undoredo.UndoDispatcher;
import usantatecla.tictactoe.distributed.dispatchers.undoredo.UndoableDispatcher;

public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.START_NAME, new StartNameDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.CREATE_PLAYERS, new CreatePlayersDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PLAYER_TYPE, new PlayerTypeDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COORDINATE_VALID, new CoordinateValidDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BOARD_COMPLETE, new BoardCompleteDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.CHANGE_TURN, new ChangeTurnDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.TOKEN_CHAR, new TokenCharDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.EMPTY_TOKEN, new EmptyTokenDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.DIMENSION, new DimensionDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.TICTACTOE, new TicTacToeDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.RANDOM_COORDINATE, new RandomCoordinateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ERRORS_PUT, new ErrorsPutDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ERRORS_MOVE_ORIGIN, new ErrorsMoveOriginDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ERRORS_MOVE_TARGET, new ErrorsMoveTargetDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PUT_TOKEN, new PutTokenDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.MOVE_TOKEN, new MoveTokenDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.SAVE_NAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.HAS_NAME, new HasNameDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
		dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.VALUE_TURN, new ValueTurnDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.CONTINUE_STATE, new ContinueStateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
	}

}
