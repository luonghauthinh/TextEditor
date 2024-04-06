import javax.swing.SwingUtilities;

import View.NotepadView;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            NotepadView view = new NotepadView(); 
            view.getFrame().setVisible(true);
        });
    }
}