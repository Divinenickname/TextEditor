package main.java;

import main.java.command.LoadCommand;
import main.java.command.SaveCommand;
import main.java.panel.MainPanel;
import main.java.panel.MenuBar;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class TextEditor extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    private JButton bSave;
    private JButton bLoad;
    private JScrollPane scrollPane;

    private File openedFile;


    public TextEditor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("The first stage");
        setMaximumSize(new Dimension(500, 500));
        initComponents();
        //initPanels();
        setJMenuBar(new MenuBar(this));
        add(new MainPanel(this), BorderLayout.NORTH);

        setVisible(true);
    }

    public void initComponents(){
        textArea = new JTextArea();
        textArea.setName("TextArea");

        scrollPane = new JScrollPane();
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
            new LoadCommand(this).execute();
            //new FakeLoad(this).execute();
        });

        bSave.addActionListener(actionEvent ->{
            new SaveCommand(this).execute();
        });

    }

    public File getOpenedFile() {
        return openedFile;
    }

    public String getFileName(){
        return textField.getText();
    }

    public void setOpenedFile(File openedFile) {
        this.openedFile = openedFile;
    }

    public void appendText(String text){
        textArea.append(text);
    }

    public void clearText(){
        textArea.setText("");
    }

    public String getText(){
        return textArea.getText();
    }

    public static void main(String[] args) {
        new TextEditor();
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}

