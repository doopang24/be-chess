package chess;

import static utils.StringUtils.appendNewLine;

import pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    LocationConverter converter = new LocationConverter();

    private final List<Rank> BOARD = new ArrayList<>();

    private final int FILE_SIZE = 8;
    private final int RANK_SIZE = 8;
    private final int INITIAL_EMPTY_RANK_SIZE = 4;

    private Rank whitePiece = new Rank();
    private Rank blackPiece = new Rank();
    private Rank whitePawn = new Rank();
    private Rank blackPawn = new Rank();

    public int pieceCount = 0;

    private void addWhitePiece(Piece Piece) {
        whitePiece.addRank(Piece);
        pieceCount++;
    }

    private void addWhitePawn(Piece Pawn) {
        whitePawn.addRank(Pawn);
        pieceCount++;
    }

    private void addBlackPiece(Piece Piece) {
        blackPiece.addRank(Piece);
        pieceCount++;
    }

    private void addBlackPawn(Piece Pawn) {
        blackPawn.addRank(Pawn);
        pieceCount++;
    }

    public void initialize() {
        makeBlackPieceRank();
        makeBlackPawnRank();
        makeWhitePawnRank();
        makeWhitePieceRank();

        BOARD.add(blackPiece);
        BOARD.add(blackPawn);
        makeEmptyRank(INITIAL_EMPTY_RANK_SIZE);
        BOARD.add(whitePawn);
        BOARD.add(whitePiece);

        System.out.println(showBoard());
    }

    private void makeBlackPieceRank() {
        addBlackPiece(Piece.createBlackRook(Position.createPos("a8")));
        addBlackPiece(Piece.createBlackKnight(Position.createPos("b8")));
        addBlackPiece(Piece.createBlackBishop(Position.createPos("c8")));
        addBlackPiece(Piece.createBlackQueen(Position.createPos("d8")));
        addBlackPiece(Piece.createBlackKing(Position.createPos("e8")));
        addBlackPiece(Piece.createBlackBishop(Position.createPos("f8")));
        addBlackPiece(Piece.createBlackKnight(Position.createPos("g8")));
        addBlackPiece(Piece.createBlackRook(Position.createPos("h8")));
    }

    private void makeBlackPawnRank() {
        addBlackPawn(Piece.createBlackPawn(Position.createPos("a7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("b7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("c7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("d7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("e7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("f7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("g7")));
        addBlackPawn(Piece.createBlackPawn(Position.createPos("h7")));
    }

    private void makeWhitePawnRank() {
        addWhitePawn(Piece.createWhitePawn(Position.createPos("a2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("b2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("c2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("d2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("e2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("f2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("g2")));
        addWhitePawn(Piece.createWhitePawn(Position.createPos("h2")));
    }

    private void makeWhitePieceRank() {
        addWhitePiece(Piece.createWhiteRook(Position.createPos("a1")));
        addWhitePiece(Piece.createWhiteKnight(Position.createPos("b1")));
        addWhitePiece(Piece.createWhiteBishop(Position.createPos("c1")));
        addWhitePiece(Piece.createWhiteQueen(Position.createPos("d1")));
        addWhitePiece(Piece.createWhiteKing(Position.createPos("e1")));
        addWhitePiece(Piece.createWhiteBishop(Position.createPos("f1")));
        addWhitePiece(Piece.createWhiteKnight(Position.createPos("g1")));
        addWhitePiece(Piece.createWhiteRook(Position.createPos("h1")));
    }

    // 빈 랭크 생성
    // 4 -> 6, 5, 4, 3
    // 8 -> 8, 7, 6, 5, 4, 3, 2, 1
    private void makeEmptyRank(int emptyRankSize) {
        int topEmptyRank = 6;
        if (emptyRankSize == 8) topEmptyRank = 8;

        for (int i = 0; i < emptyRankSize; i++) {
            String rank = String.valueOf(topEmptyRank - i);
            Rank emptyRank = new Rank();
            emptyRank.addRank(Piece.createBlank(Position.createPos("a" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("b" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("c" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("d" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("e" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("f" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("g" + rank)));
            emptyRank.addRank(Piece.createBlank(Position.createPos("h" + rank)));
            BOARD.add(emptyRank);
        }
    }

    public void initializeEmpty() {
        makeEmptyRank(RANK_SIZE);
    }

    // 지정한 위치에 기물 배치
    public void move(String position, Piece piece) {
        try {
            isValidNotation(position);
            int fileIndex = converter.fileToIndex(position.charAt(0));
            int rankIndex = converter.rankToIndex(position.charAt(1));
            BOARD.get(rankIndex).putPiece(fileIndex, piece);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // 체스판에 해당 기물이 몇 개 있는지 반환
    public int countPieceFromBoard(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : BOARD) {
            count += rank.countPieceFromRank(color, type);
        }
        return count;
    }

    // 입력받은 위치에 있는 기물 반환
    public Piece findPiece(String notation) {
        while (true) {
            try {
                isValidNotation(notation);
                int fileIndex = converter.fileToIndex(notation.charAt(0));
                int rankIndex = converter.rankToIndex(notation.charAt(1));
                return BOARD.get(rankIndex).findPieceFromRank(fileIndex);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 위치 입력값 검증
    private void isValidNotation(String notation) {
        if (notation.length() != 2) throw new IllegalArgumentException("올바른 입력이 아닙니다.");
        char file = notation.charAt(0);
        char rank = notation.charAt(1);
        if (!Character.isLetter(file) || !Character.isLowerCase(file)) {
            throw new IllegalArgumentException("올바른 파일값이 아닙니다.");
        } else if (!Character.isDigit(rank)) {
            throw new IllegalArgumentException("올바른 랭크값이 아닙니다.");
        }
    }

    // 색깔에 따른 점수 계산
    public double calculatePoint(Piece.Color color) {
        double answer = 0.0;
        Map<Integer, Boolean> pawnDuplicationMap = new HashMap<>();

        for (int i = 0; i < FILE_SIZE; i++) {
            pawnDuplicationMap.put(i, isPawnDuplicatedInFile(color, i));
        }

        for (int i = 0; i < FILE_SIZE; i++) {
            boolean pawnDuplicationCheck = pawnDuplicationMap.get(i);    // 새로줄 내에 폰 중복 여부
            for (int j = 0; j < RANK_SIZE; j++) {
                Piece piece = BOARD.get(j).findPieceFromRank(i);
                if (piece.getColor() == color) {
                    if (piece.getType() == Piece.Type.PAWN && pawnDuplicationCheck) {
                        answer += piece.getType().getDefaultPoint() / 2.0;
                    } else {
                        answer += piece.getType().getDefaultPoint();
                    }
                }
            }
        }
        return answer;
    }

    // 세로줄 내에 같은 색 폰이 2개 이상 있으면 true
    private boolean isPawnDuplicatedInFile(Piece.Color color, int fileIndex) {
        int count = 0;
        for (Rank rank : BOARD) {
            Piece piece = rank.findPieceFromRank(fileIndex);
            if (piece.getColor() == color && piece.getType() == Piece.Type.PAWN) {
                count++;
                if (count >= 2) return true;
            }
        }
        return false;
    }

    public int getInitialPieceTotalCount() {
        return pieceCount;
    }
}
