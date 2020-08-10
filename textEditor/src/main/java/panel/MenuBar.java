package main.java.panel;

import main.java.TextEditor;
import main.java.command.CloseCommand;
import main.java.command.LoadCommand;
import main.java.command.SaveCommand;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private TextEditor editor;

    private JMenu search;

    private JMenuItem startSearch;
    private JMenuItem prevSearch;
    private JMenuItem nextMatch;
    private JMenuItem useRegexp;

    public MenuBar(TextEditor editor){
        init();
        this.editor = editor;
    }

    public void init(){
        JMenu mFile = new JMenu("File");
        mFile.setName("MenuFile");

        JMenuItem load = new JMenuItem("Load");
        load.setName("MenuLoad");
        load.addActionListener(e -> {
            new LoadCommand(editor).execute();
        });

        JMenuItem save = new JMenuItem("Save");
        save.setName("MenuSave");
        save.addActionListener(e -> {
            new SaveCommand(editor).execute();
        });

        JMenuItem exit = new JMenuItem("Exit");
        exit.setName("MenuExit");
        exit.addActionListener(e -> {
            new CloseCommand(editor).execute();
        });

        mFile.add(load);
        mFile.add(save);
        mFile.addSeparator();
        mFile.add(exit);

        add(mFile);

        initSearch();
    }

    private void initSearch(){
        search = new JMenu("Search");
        startSearch = new JMenuItem("Start search");
        prevSearch = new JMenuItem("Previous search");
        nextMatch = new JMenuItem("Next match");
        useRegexp = new JMenuItem("Use regular expressions");

        search.add(startSearch);
        search.add(prevSearch);
        search.add(nextMatch);
        search.add(useRegexp);

        add(search);
    }
}
