package usantatecla.tictactoe.distributed;

import usantatecla.tictactoe.controllers.StartController;
import usantatecla.tictactoe.distributed.dispatchers.FrameType;
import usantatecla.tictactoe.models.Session;
import usantatecla.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

	@Override
	public void start(String title) {
		this.tcpip.send(FrameType.START_NAME.name());
		this.tcpip.send(title);
	}

	@Override
	public void createPlayers(int numberOfUsers) {
		this.tcpip.send(FrameType.CREATE_PLAYERS.name());
		this.tcpip.send(numberOfUsers);
	}

	@Override
	public String[] getGamesNames() {
		this.tcpip.send(FrameType.TITLES.name());
		int length = this.tcpip.receiveInt();
		String[] names = new String[length];
		for (int i = 0; i < length; i++) {
			names[i] = this.tcpip.receiveLine();
		}
		return names;
	}

}
