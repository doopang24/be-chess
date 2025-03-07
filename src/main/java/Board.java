import static utils.StringUtils.appendNewLine;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<String> BOARD = new ArrayList<>();
    private final int WHITE_PAWN_INDEX = 6;
    private final int BLACK_PAWN_INDEX = 1;
    private final int BOARD_ROW_SIZE = 8;
    private List<Piece> whitePieceList = new ArrayList<>();
    private List<Piece> blackPieceList = new ArrayList<>();
    private List<Piece> whitePawnList = new ArrayList<>();
    private List<Piece> blackPawnList = new ArrayList<>();
    public int pieceCount = 0;

    private void addWhitePiece(Piece whitePiece) {
        whitePieceList.add(whitePiece);
        pieceCount++;
    }

    private void addWhitePawn(Piece whitePawn) {
        whitePawnList.add(whitePawn);
        pieceCount++;
    }

    private void addBlackPiece(Piece blackPiece) {
        blackPieceList.add(blackPiece);
        pieceCount++;
    }

    private void addBlackPawn(Piece blackPawn) {
        blackPawnList.add(blackPawn);
        pieceCount++;
    }

    public void initialize() {
        String blank = "........";

        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
        for (int i = 0; i < 8; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
        for (int i = 0; i < 8; i++) {
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

        String blackPicesString = listToString(blackPieceList);
        String blackPawnString = listToString(blackPawnList);
        String whitePawnString = listToString(whitePawnList);
        String whitePiecesString = listToString(whitePieceList);

        BOARD.add(blackPicesString);
        BOARD.add(blackPawnString);
        for (int i = 0; i < 4; i++) {
            BOARD.add(blank);
        }
        BOARD.add(whitePawnString);
        BOARD.add(whitePiecesString);

        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BOARD_ROW_SIZE; i++) {
            builder.append(appendNewLine(BOARD.get(i)));
        }
        return builder.toString();
    }

    // List 의 내용을 StringBuilder 에 담고, String 으로 반환
    private String listToString(List<Piece> pieceList) {
        StringBuilder builder = new StringBuilder();
        for (Piece piece : pieceList) {
            builder.append(piece.getRepresentation());
        }
        return builder.toString();
    }

    // BOARD 에서 흰색 Pawn 줄 반환
    public String getWhitePawnResult() {
        return BOARD.get(WHITE_PAWN_INDEX);
    }

    // BOARD 에서 검은색 Pawn 줄 반환
    public String getBlackPawnResult() {
        return BOARD.get(BLACK_PAWN_INDEX);
    }

    public int pieceCount() {
        return pieceCount;
    }
}
