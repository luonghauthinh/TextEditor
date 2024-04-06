package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Controller.NotepadController;

public class NotepadView implements ActionListener {
    private JFrame frame;
    private JTextArea textArea;
    private NotepadController controller;

    public NotepadView() {
        createUI();
        controller = new NotepadController(this);
    }

    private void createUI() {
        frame = new JFrame("Notepad");
        frame.setSize(500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");

        String[] menuItems = {"New", "Open", "Save", "Save As", "Exit"};
        for (String item : menuItems) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.addActionListener(this);
            menuItem.setActionCommand(item);
            menuFile.add(menuItem);
        }

        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                controller.newFile();
                break;
            case "Open":
                controller.open();
                break;
            case "Save":
                controller.save();
                break;
            case "Save As":
                controller.saveAs();
                break;
            case "Exit":
                controller.exit();
                break;
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
