package main.java.command;

import main.java.TextEditor;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadCommand extends Command {
    private static final String WINDOW_TITLE = "Open file";
    private File file;

    public LoadCommand(TextEditor editor){
        super(editor);
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        int ret = fileChooser.showDialog(null, WINDOW_TITLE);

        if(ret == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
            editor.setOpenedFile(file);
            readFile(file);
            editor.setOpenedFile(file);
        }
        else {
            file = null;
        }
    }

    public File getFile() throws NullPointerException{
        return file;
    }

    public void readFile(File file){
        Path path = Paths.get(file.getPath());

        try (BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
            String line;
            while((line = bufferedReader.readLine())!= null){
                editor.appendText(line);
                editor.appendText(System.lineSeparator());
            }

        } catch (IOException e) {
            System.err.println("File not opened");
            e.printStackTrace();
        }
    }
}
