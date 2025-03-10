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
    // 해당 index 의 rank 반환
    public int indexToRank(int index) {
        return RANK.charAt(index) - '0';
    }

    public String getFILE() {
        return FILE;
    }
}
