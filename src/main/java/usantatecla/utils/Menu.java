package usantatecla.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Menu {

  private static final String OPTION = "Option? [1-#size]: ";
  private List<Command> commandList;

  public Menu() {
    this.commandList = new ArrayList<Command>();
  }

  public void execute() {
    ArrayList<Command> commands = new ArrayList<Command>();
    for (int i = 0; i < this.commandList.size(); i++) {
      if (this.commandList.get(i).isActive()) {
        commands.add(this.commandList.get(i));
      }
    }
    int option;
    Console console = Console.instance();
    boolean error;
    do {
      error = false;
      console.writeln();
      for (int i = 0; i < commands.size(); i++) {
        console.writeln((i + 1) + ") " + commands.get(i).getTitle());
      }
      option = console.readInt(Menu.OPTION.replace("#size", "" + commands.size())) - 1;
      if (!new ClosedInterval(0, commands.size() - 1).isIncluded(option)) {
        error = true;
      }
    } while (error);
    commands.get(option).execute();
  }

  protected void addCommand(Command command) {
    this.commandList.add(command);
  }

}
