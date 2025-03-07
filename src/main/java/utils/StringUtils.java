package utils;

public class StringUtils {

    public static final String NEWLINE = System.getProperty("line.separator");

    public static String appendNewLine(String original) {
        return original + NEWLINE;
    }

    private StringUtils() {
    }
}
