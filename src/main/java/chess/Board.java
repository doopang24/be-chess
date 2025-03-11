package chess;

import static utils.StringUtils.appendNewLine;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < INITIAL_EMPTY_RANK_SIZE; i++) {
            BOARD.add(makeEmptyRank());
        }
        BOARD.add(whitePawn);
        BOARD.add(whitePiece);

        System.out.println(showBoard());
    }

    private void makeBlackPieceRank() {
        addBlackPiece(Piece.createBlackRook());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackQueen());
        addBlackPiece(Piece.createBlackKing());
        addBlackPiece(Piece.createBlackBishop());
        addBlackPiece(Piece.createBlackKnight());
        addBlackPiece(Piece.createBlackRook());
    }

    private void makeBlackPawnRank() {
        for (int i = 0; i < FILE_SIZE; i++) {
            addBlackPawn(Piece.createBlackPawn());
        }
    }

    // 새로운 빈 랭크 생성
    private Rank makeEmptyRank() {
        Rank rank = new Rank();
        for (int i = 0; i < FILE_SIZE; i++) {
            rank.addRank(Piece.createBlank());
        }
        return rank;
    }

    private void makeWhitePawnRank() {
        for (int i = 0; i < FILE_SIZE; i++) {
            addWhitePawn(Piece.createWhitePawn());
        }
    }

    private void makeWhitePieceRank() {
        addWhitePiece(Piece.createWhiteRook());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteQueen());
        addWhitePiece(Piece.createWhiteKing());
        addWhitePiece(Piece.createWhiteBishop());
        addWhitePiece(Piece.createWhiteKnight());
        addWhitePiece(Piece.createWhiteRook());
    }

    public void initializeEmpty() {
        makeEmptyRank();
        for (int i = 0; i < RANK_SIZE; i++) {
            BOARD.add(makeEmptyRank());
        }
    }

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

    // 출력할 체스판 구성
    public String showBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < RANK_SIZE; i++) {
            builder.append(BOARD.get(i).getRankView()).append(" ").append(appendNewLine(converter.indexToRank(i)));
        }
        builder.append(appendNewLine("")).append(converter.getFILE());
        return builder.toString();
    }

    public void printBoard() {
        System.out.println(showBoard());
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
        boolean pawnDuplicationCheck;
        for (int i = 0; i < FILE_SIZE; i++) {
            pawnDuplicationCheck = isPawnDuplicatedInFile(color, i);    // 새로줄 내에 폰 중복 여부
            for (int j = 0; j < RANK_SIZE; j++) {
                Piece piece = BOARD.get(j).findPieceFromRank(i);
                if (piece.getColor() == color) {
                    if (piece.getType() == Piece.Type.PAWN && pawnDuplicationCheck) {
                        answer += piece.getType().getDefaultPoint() / 2.0;
                        continue;
                    }
                    answer += piece.getType().getDefaultPoint();
                }
            }
        }
        return answer;
    }

    // 세로줄 내에 같은 색 폰이 2개 이상 있으면 true
    private boolean isPawnDuplicatedInFile(Piece.Color color, int fileIndex) {
        Piece piece;
        int count = 0;
        if (color == Piece.Color.WHITE) {
            piece = Piece.createWhitePawn();
        } else {
            piece = Piece.createBlackPawn();
        }

        for (Rank rank : BOARD) {
            if (rank.findPieceFromRank(fileIndex).equals(piece)) {
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
