package main.java.command;

import main.java.TextEditor;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveCommand extends Command {
    private JTextField fileNameField;
    private JTextArea textArea;

    private static String WINDOWS_TITLE = "Save file";

    public SaveCommand(TextEditor editor, JTextField fileNameField, JTextArea textArea) {
        super(editor);
        this.textArea = textArea;
        this.fileNameField = fileNameField;
    }

    @Override
    public void execute() {

        if(editor.getOpenedFile()==null){
            //Open saveFile dialog
            JFileChooser saveFileDialog = new JFileChooser();
            int ret = saveFileDialog.showSaveDialog(null);

            if(ret == JFileChooser.APPROVE_OPTION){
                File file = saveFileDialog.getSelectedFile();
                writeFile(file);
                editor.setOpenedFile(file);
            }
        }
        else {
            //Save changes to current file
            writeFile(editor.getOpenedFile());
        }
    }

    public void writeFile(File file){
        Path path = Paths.get(file.getPath());

        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            writer.write(textArea.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

