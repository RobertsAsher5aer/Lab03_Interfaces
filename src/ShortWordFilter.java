public class ShortWordFilter implements InterfaceFilter.Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            String word = (String) x;
            return word.length() < 5; // Accept words of length < 5
        }
        return false;
    }
}
