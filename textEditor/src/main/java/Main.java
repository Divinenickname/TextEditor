package main.java;

import javax.swing.*;
public class Main extends JFrame{
    public Main(){
        setTitle("TestSwingApp");
        setVisible(true);
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}
