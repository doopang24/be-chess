package chess;

import static utils.StringUtils.appendNewLine;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    LocationConverter converter = new LocationConverter();

    private final List<Rank> BOARD = new ArrayList<>();

    private final int BOARD_ROW_SIZE = 8;
    private final int INITIAL_BLANK_SIZE = 4;

    private Rank whitePieceList = new Rank();
    private Rank blackPieceList = new Rank();
    private Rank whitePawnList = new Rank();
    private Rank blackPawnList = new Rank();
    private Rank blank = new Rank();

    public int pieceCount = 0;

    private void addWhitePiece(Piece whitePiece) {
        whitePieceList.addRank(whitePiece);
        pieceCount++;
    }

    private void addWhitePawn(Piece whitePawn) {
        whitePawnList.addRank(whitePawn);
        pieceCount++;
    }

    private void addBlackPiece(Piece blackPiece) {
        blackPieceList.addRank(blackPiece);
        pieceCount++;
    }

    private void addBlackPawn(Piece blackPawn) {
        blackPawnList.addRank(blackPawn);
        pieceCount++;
    }

    private void addBlank() {
        blank.addRank(Piece.createBlank());
    }

    public void initialize() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            addBlank();
        }
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());


        BOARD.add(blackPieceList);
        BOARD.add(blackPawnList);
        for (int i = 0; i < INITIAL_BLANK_SIZE; i++) {
            BOARD.add(blank);
        }
        BOARD.add(whitePawnList);
        BOARD.add(whitePieceList);

        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            builder.append(appendNewLine(BOARD.get(i).getRankView()));
        }
        return builder.toString();
    }

    public int countPieceFromBoard(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : BOARD) {
            count += rank.countPieceFromRank(color, type);
        }
        return count;
    }

    public Piece findPiece(String notation) {
        while (true) {
            try {
                isValidNotation(notation);
                int rankIndex = converter.getRowValue(notation.charAt(0));
                int fileIndex = converter.getColumnValue(notation.charAt(1));
                return BOARD.get(rankIndex).findPieceFromRank(fileIndex);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

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

    public int getInitialPieceTotalCount() {
        return pieceCount;
    }
}
