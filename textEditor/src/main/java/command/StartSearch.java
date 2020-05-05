package main.java.command;

import main.java.SearchEngine;
import main.java.TextEditor;

import java.util.ArrayList;
import java.util.List;

public class StartSearch extends Command{
    private SearchEngine searchEngine;

    public StartSearch(TextEditor editor, SearchEngine searchEngine) {
        super(editor);
        this.searchEngine = searchEngine;
    }

    @Override
    public void execute() {
        List<Integer> indexList = searchEngine.getIndexes();

        if (indexList.size()!=0){
            int startIndex = indexList.get(0);
            editor.getTextArea().setCaretPosition(startIndex);
            editor.getTextArea().select(startIndex, startIndex+searchEngine.getTextLength());
            editor.getTextArea().grabFocus();
        }


    }
}
