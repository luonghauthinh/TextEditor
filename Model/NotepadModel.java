package Model;

import java.io.*;

public class NotepadModel {
    private String currentFileName;
    private String currentFilePath;

    public String getCurrentFileName() {
        return currentFileName;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public String openFile(String filePath, String fileName) throws IOException {
        this.currentFilePath = filePath;
        this.currentFileName = fileName;

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public void saveFile(String filePath, String fileName, String content) throws IOException {
        this.currentFilePath = filePath;
        this.currentFileName = fileName;

        try (FileWriter writer = new FileWriter(filePath + fileName)) {
            writer.write(content);
        }
    }

    public void setCurrentFileName(String fileName) {
        this.currentFileName = fileName;
    }

    public void setCurrentFilePath(String filePath) {
        this.currentFilePath = filePath;
    }
}
