package chess;

public class LocationConverter {

    // 변환 기준
    private final String RANK = "87654321";
    private final String FILE = "abcdefgh";

    // 입력받은 file 의 index 반환
    public int fileToIndex(char inputFile) {
        return FILE.indexOf(inputFile);
    }

    // 입력받은 rank 의 index 반환
    public int rankToIndex(char inputRank) {
        return RANK.indexOf(inputRank);
    }

    // 입력받은 위치의 index 찾기
    private int findPosition(char input, String location) {
        return location.indexOf(input);
    }

    // 해당 index 의 rank 반환
    public String indexToRank(int index) {
        return String.valueOf(RANK.charAt(index) - '0');
    }

    public String getFILE() {
        return FILE;
    }
}
