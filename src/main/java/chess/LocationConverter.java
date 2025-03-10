package chess;

public class LocationConverter {

    // 변환 기준
    private final String RANK = "87654321";
    private final String FILE = "abcdefgh";

    // 입력받은 file 의 index 반환
    public int fileToIndex(char inputFile) {
        return findPosition(inputFile, FILE);
    }

    // 입력받은 rank 의 index 반환
    public int rankToIndex(char inputRank) {
        return findPosition(inputRank, RANK);
    }

    // 입력받은 위치의 index 찾기
    private int findPosition(char input, String location) {
        int position = 0;
        for (int i = 0; i < location.length(); i++) {
            if (location.indexOf(input) == i) position = i;
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
