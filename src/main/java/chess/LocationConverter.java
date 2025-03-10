package chess;

public class LocationConverter {

    private final String ROW = "87654321";
    private final String COLUMN = "abcdefgh";

    public int getRowValue(char input) {
        return findPosition(input, ROW);
    }

    public int getColumnValue(char input) {
        return findPosition(input, COLUMN);
    }

    private int findPosition(char input, String string) {
        int position = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.indexOf(input) == i) position = i;
        }
        return position;
    }
}
