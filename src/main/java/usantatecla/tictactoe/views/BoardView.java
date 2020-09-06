package usantatecla.tictactoe.views;

import usantatecla.utils.WithConsoleView;

class BoardView extends WithConsoleView {

    void write(char token) {
        this.console.write(token);
    }

    void writeln() {
        this.console.writeln();
    }
    
}