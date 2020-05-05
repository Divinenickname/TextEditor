package main.java.panel;

import main.java.TextEditor;
import main.java.command.LoadCommand;
import main.java.command.SaveCommand;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private static String RESOURCES_PATH = "textEditor/resources/";
    private static final Dimension BUTTON_DIMENSION = new Dimension(24,24);

    private JButton saveButton;
    private JButton openButton;
    private JButton startSearchButton;
    private JButton previousMatchButton;
    private JButton nextMatchButton;
    private JPanel testPanel;

    private JCheckBox useRegExCheckbox;

    private JTextField searchField;

    private TextEditor editor;

    public MainPanel(TextEditor editor){
        this.editor = editor;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        //setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(500, 26));
        initPanel();
        initActions();
        add(testPanel);
    }

    public void initPanel(){
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        flowLayout.setVgap(1);
        testPanel = new JPanel();
        testPanel.setLayout(flowLayout);
        testPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        ImageIcon saveIcon = new ImageIcon(RESOURCES_PATH+"save.png");
        ImageIcon loadIcon = new ImageIcon(RESOURCES_PATH+"load.png");
        ImageIcon searchIcon = new ImageIcon(RESOURCES_PATH+"search.png");
        ImageIcon nextIcon = new ImageIcon(RESOURCES_PATH+"arrow_right.png");
        ImageIcon prevIcon = new ImageIcon(RESOURCES_PATH+"arrow_left.png");

        saveButton = new JButton(saveIcon);
        saveButton.setName("SaveButton");
        saveButton.setPreferredSize(BUTTON_DIMENSION);

        openButton = new JButton(loadIcon);
        openButton.setName("OpenButton");
        openButton.setPreferredSize(BUTTON_DIMENSION);


        startSearchButton = new JButton(searchIcon);
        startSearchButton.setName("StartSearchButton");
        startSearchButton.setPreferredSize(BUTTON_DIMENSION);


        nextMatchButton = new JButton(nextIcon);
        nextMatchButton.setName("NextMatchButton");
        nextMatchButton.setPreferredSize(BUTTON_DIMENSION);


        previousMatchButton = new JButton(prevIcon);
        previousMatchButton.setName("PreviousMatchButton");
        previousMatchButton.setPreferredSize(BUTTON_DIMENSION);


        searchField = new JTextField(15);
        searchField.setName("SearchField");
        searchField.setPreferredSize(BUTTON_DIMENSION);
        searchField.setMinimumSize(new Dimension(50, 24));

        useRegExCheckbox = new JCheckBox("Use regex");
        useRegExCheckbox.setName("MenuUseRegExp");

        testPanel.add(openButton);
        testPanel.add(saveButton);
        testPanel.add(searchField);
        testPanel.add(startSearchButton);
        testPanel.add(previousMatchButton);
        testPanel.add(nextMatchButton);
        testPanel.add(useRegExCheckbox);
    }

    public void initActions(){
        openButton.addActionListener(e -> {
            new LoadCommand(editor).execute();
        });

        saveButton.addActionListener(e -> {
            new SaveCommand(editor).execute();
        });
    }
}
