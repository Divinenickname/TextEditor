package main.java;

import main.java.command.LoadCommand;
import main.java.command.SaveCommand;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class TextEditor extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    private JButton bSave;
    private JButton bLoad;

    private File openedFile;


    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("The first stage");
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        initComponents();
        initPanels();

        setVisible(true);
    }

    public void initComponents(){
        textArea = new JTextArea();
        textArea.setName("TextArea");

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setName("ScrollPane");
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(textArea);
    }

    public void initPanels(){
        JPanel saveAndLoadPanel = new JPanel();
        saveAndLoadPanel.setLayout(new BoxLayout(saveAndLoadPanel, BoxLayout.LINE_AXIS));
        saveAndLoadPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        getContentPane().add(saveAndLoadPanel, BorderLayout.NORTH);

        textField = new JTextField();
        textField.setName("FilenameField");
        textField.setPreferredSize(new Dimension(35, 27));
        saveAndLoadPanel.add(textField);
        saveAndLoadPanel.add(Box.createHorizontalStrut(5));

        bLoad = new JButton("Load");
        bLoad.setName("LoadButton");
        saveAndLoadPanel.add(bLoad);
        saveAndLoadPanel.add(Box.createHorizontalStrut(5));

        bSave = new JButton("Save");
        bSave.setName("SaveButton");
        saveAndLoadPanel.add(bSave);

        bLoad.addActionListener(actionEvent ->{
            LoadCommand command = new LoadCommand(this);
            command.execute();
            try{
                textField.setText(command.getFile().getPath());
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }

        });

        bSave.addActionListener(actionEvent ->{
            new SaveCommand(this, textField, textArea).execute();
        });

    }

    public File getOpenedFile() {
        return openedFile;
    }

    public void setOpenedFile(File openedFile) {
        this.openedFile = openedFile;
        textField.setText(openedFile.getPath());
    }

    public void appendText(String text){
        textArea.append(text);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}

