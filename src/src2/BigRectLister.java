import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        // Create 10 rectangles with varying dimensions
        rectangles.add(new Rectangle(1, 2));  // Perimeter = 6
        rectangles.add(new Rectangle(2, 3));  // Perimeter = 10
        rectangles.add(new Rectangle(4, 3));  // Perimeter = 14
        rectangles.add(new Rectangle(5, 1));  // Perimeter = 12
        rectangles.add(new Rectangle(6, 4));  // Perimeter = 20
        rectangles.add(new Rectangle(1, 1));  // Perimeter = 4
        rectangles.add(new Rectangle(3, 4));  // Perimeter = 14
        rectangles.add(new Rectangle(2, 5));  // Perimeter = 14
        rectangles.add(new Rectangle(1, 6));  // Perimeter = 14
        rectangles.add(new Rectangle(0, 8));  // Perimeter = 16

        // Create an instance of BigRectangleFilter
        BigRectangleFilter filter = new BigRectangleFilter();

        // List of big rectangles
        StringBuilder bigRectangles = new StringBuilder("Rectangles with perimeter > 10:\n");

        // Filter rectangles
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                bigRectangles.append("Rectangle(width=").append(rect.width)
                        .append(", height=").append(rect.height)
                        .append("), Perimeter = ").append(2 * (rect.width + rect.height))
                        .append("\n");
            }
        }

        // Display results
        JOptionPane.showMessageDialog(null, bigRectangles.toString(), "Big Rectangles", JOptionPane.INFORMATION_MESSAGE);
    }
}

