package main.java.panel;

import main.java.TextEditor;

import javax.swing.*;

public class MainPanel extends JPanel {
    public static String RESOURCES_PATH = "textEditor/resources/";

    private JButton saveButton;
    private JButton openButton;
    private JButton startSearchButton;
    private JButton previousMatchButton;
    private JButton nextMatchButton;

    private JCheckBox useRegExCheckbox;

    private JTextField searchField;

    private TextEditor editor;

    public MainPanel(TextEditor editor){
        this.editor = editor;
        initPanel();
    }

    public void initPanel(){
        ImageIcon saveIcon = new ImageIcon(RESOURCES_PATH+"save.png");
        ImageIcon loadIcon = new ImageIcon(RESOURCES_PATH+"load.png");
        ImageIcon searchIcon = new ImageIcon(RESOURCES_PATH+"search.png");
        ImageIcon nextIcon = new ImageIcon(RESOURCES_PATH+"arrow_right.png");
        ImageIcon prevIcon = new ImageIcon(RESOURCES_PATH+"arrow_left.png");

        saveButton = new JButton(saveIcon);
        openButton = new JButton(loadIcon);
        startSearchButton = new JButton(searchIcon);
        nextMatchButton = new JButton(nextIcon);
        previousMatchButton = new JButton(prevIcon);

        searchField = new JTextField(10);

        add(openButton);
        add(saveButton);
        add(searchField);
        add(startSearchButton);
        add(previousMatchButton);
        add(nextMatchButton);
    }
}
