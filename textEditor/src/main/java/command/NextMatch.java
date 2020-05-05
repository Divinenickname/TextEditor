package main.java.command;

import main.java.SearchEngine;
import main.java.TextEditor;

public class NextMatch extends Command{
    private SearchEngine searchEngine;
    public NextMatch(TextEditor editor, SearchEngine searchEngine) {
        super(editor);
        this.searchEngine = searchEngine;
    }

    @Override
    public void execute() {
        int startIndex = searchEngine.nextIndex();

        if(startIndex != -1){
            editor.getTextArea().setCaretPosition(startIndex);
            editor.getTextArea().select(startIndex, startIndex+searchEngine.getTextLength());
            editor.getTextArea().grabFocus();
        }

    }
}
