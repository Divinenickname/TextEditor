package main.java.command;

import main.java.SearchEngine;
import main.java.TextEditor;


public class StartSearch extends Command{
    private SearchEngine searchEngine;

    public StartSearch(TextEditor editor, SearchEngine searchEngine) {
        super(editor);
        this.searchEngine = searchEngine;
    }

    @Override
    public void execute() {
        searchEngine.find();
        var index = searchEngine.getCurrentIndex();

        if(index != -1){
            editor.getTextArea().setCaretPosition(index);
            editor.getTextArea().select(index, index + searchEngine.getPattern().length());
            editor.getTextArea().grabFocus();
        }

    }
}
