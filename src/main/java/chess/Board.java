package chess;

import static utils.StringUtils.appendNewLine;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

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

    public int pieceCount() {
        return pieceCount;
    }
}
