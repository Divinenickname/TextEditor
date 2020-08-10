package main.java.command;

import main.java.SearchEngine;
import main.java.TextEditor;

public class NextMatch extends Command{
    private SearchEngine searchEngine;
    private String searchText;

    public NextMatch(TextEditor editor, SearchEngine searchEngine, String searchText) {
        super(editor);
        this.searchEngine = searchEngine;
        this.searchText = searchText;
    }

    @Override
    public void execute() {
        var index = searchEngine.nextIndex();

        if(index != -1){
            editor.getTextArea().setCaretPosition(index);
            editor.getTextArea().select(index, index + searchText.length());
            editor.getTextArea().grabFocus();
        }

    }
}
