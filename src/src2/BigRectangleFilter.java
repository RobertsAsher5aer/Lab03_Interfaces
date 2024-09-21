import java.awt.Rectangle;

public class BigRectangleFilter implements InterfaceFilter.Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            // Calculate perimeter: 2 * (width + height)
            int perimeter = 2 * (rect.width + rect.height);
            return perimeter > 10; // Accept rectangles with perimeter > 10
        }
        return false;
    }
}

