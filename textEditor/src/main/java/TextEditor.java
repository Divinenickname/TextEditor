package main.java;

import main.java.command.SaveCommand;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    private JTextField textField;
    private JTextArea textArea;

    private JButton bSave;
    private JButton bLoad;


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

        });

        bSave.addActionListener(actionEvent ->{
            new SaveCommand().execute();
        });

    }



    public static void main(String[] args) {
        new TextEditor();
    }
}
