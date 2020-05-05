package main.java.command;

import main.java.TextEditor;

public class StartSearch extends Command{
    private String textToSearch;

    public StartSearch(TextEditor editor, String textToSearch) {
        super(editor);
        this.textToSearch = textToSearch;
    }

    @Override
    public void execute() {

    }
}
