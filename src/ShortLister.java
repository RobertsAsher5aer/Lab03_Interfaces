import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShortLister {
    public static void main(String[] args) {
        // Set up the file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a text file");

        // Show the file chooser and wait for the user to select a file
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayShortWords(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void displayShortWords(File file) {
        ShortWordFilter filter = new ShortWordFilter();
        StringBuilder shortWords = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (filter.accept(word)) {
                        shortWords.append(word).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the short words in a dialog
        if (shortWords.length() > 0) {
            JTextArea textArea = new JTextArea(shortWords.toString());
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Short Words", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No short words found in the file.", "Short Words", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
