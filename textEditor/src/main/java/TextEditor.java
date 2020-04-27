package main.java;

import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame{
    TextEditor(){
        setSize(new Dimension(500,500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        initComponents();

        setVisible(true);
    }

    public void initComponents(){
        add(initUserPanel(), BorderLayout.NORTH);
        add(initTextArea());
    }

    public JScrollPane initTextArea(){
        JTextArea textArea = new JTextArea();

        return new JScrollPane(textArea);
    }

    public JPanel initUserPanel(){
        JPanel panel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        JButton save = new JButton("Save");
        JButton load = new JButton("Load");

        panel.add(textField);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(save);
        buttonPanel.add(load);
        panel.add(buttonPanel, BorderLayout.EAST);

        return panel;
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
