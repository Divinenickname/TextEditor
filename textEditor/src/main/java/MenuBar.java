package main.java;

import main.java.command.CloseCommand;
import main.java.command.LoadCommand;
import main.java.command.SaveCommand;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    private TextEditor editor;

    MenuBar(TextEditor editor){
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
    }
}
