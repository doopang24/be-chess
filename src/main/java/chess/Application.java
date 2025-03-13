package chess;

import java.util.Scanner;

public class Application {

    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("start") || input.equalsIgnoreCase("end") || input.startsWith("move")) {
                return input;
            } else {
                System.out.println("유효한 명령어를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        Board board = new Board();
        ChessGame game;


        String input = application.getInput();
        if (input.equalsIgnoreCase("start")) {
            board.initialize();
        } else if (input.startsWith("move")) {
            game = new ChessGame(board);
            game.getSourceAndTarget(input);
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }
}
