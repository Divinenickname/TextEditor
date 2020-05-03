package main.java.command;

import main.java.TextEditor;

public class CloseCommand extends Command{

    public CloseCommand(TextEditor editor) {
        super(editor);
    }

    @Override
    public void execute() {
        editor.dispose();
    }
}
