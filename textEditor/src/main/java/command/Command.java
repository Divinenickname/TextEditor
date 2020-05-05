package main.java.command;

import main.java.TextEditor;

public abstract class Command implements ICommand{
    protected TextEditor editor;

    public Command(TextEditor editor){
        this.editor = editor;
    }
}
