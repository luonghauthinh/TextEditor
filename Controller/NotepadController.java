package Controller;

import java.awt.FileDialog;
import java.io.*;

import View.NotepadView;
import Model.NotepadModel;

public class NotepadController {
    private NotepadView view;
    private NotepadModel model;

    public NotepadController(NotepadView view) {
        this.view = view;
        this.model = new NotepadModel();
        setupEventHandlers();
    }

    public void newFile() {
        if (view.getTextArea() != null) {
            view.getTextArea().setText("");
        }
        setWindowTitle("New");
        model.setCurrentFileName(null);
        model.setCurrentFilePath(null);
    }

    public void open() {
        FileDialog fd = getFileDialog("Open", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String fileAddress = fd.getDirectory();
            setWindowTitle(fileName);
            try {
                String content = model.openFile(fileAddress, fileName);
                view.getTextArea().setText(content);
            } catch (IOException e) {
                System.out.println("FILE NOT OPENED!");
            }
        }
    }

    public void save() {
        String content = view.getTextArea().getText();
        String fileName = model.getCurrentFileName();
        String fileAddress = model.getCurrentFilePath();

        if (fileName == null) {
            saveAs();
        } else {
            try {
                model.saveFile(fileAddress, fileName, content);
                setWindowTitle(fileName);
            } catch (IOException e) {
                System.out.println("SOMETHING WENT WRONG!");
            }
        }
    }

    public void saveAs() {
        FileDialog fd = getFileDialog("Save", FileDialog.SAVE);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String fileAddress = fd.getDirectory();
            setWindowTitle(fileName);
            try {
                model.saveFile(fileAddress, fileName, view.getTextArea().getText());
            } catch (IOException e) {
                System.out.println("SOMETHING WENT WRONG! ");
            }
        }
    }

    public void exit() {
        System.exit(0);
    }

    private FileDialog getFileDialog(String title, int mode) {
        return new FileDialog(view.getFrame(), title, mode);
    }

    private void setWindowTitle(String title) {
        if (view.getFrame() != null) {
            view.getFrame().setTitle(title);
        }
    }

    private void setupEventHandlers() {
        // Your event handling setup code here
    }
}
