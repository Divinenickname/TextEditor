package main.java.command;

import main.java.SearchEngine;
import main.java.TextEditor;

public class PrevMatch extends Command{
    private SearchEngine searchEngine;
    public PrevMatch(TextEditor editor, SearchEngine searchEngine) {
        super(editor);
        this.searchEngine = searchEngine;
    }

    @Override
    public void execute() {
        int startIndex = searchEngine.prevIndex();

        if(startIndex != -1){
            editor.getTextArea().setCaretPosition(startIndex);
            editor.getTextArea().select(startIndex, startIndex+searchEngine.getTextLength());
            editor.getTextArea().grabFocus();
        }
    }
}
