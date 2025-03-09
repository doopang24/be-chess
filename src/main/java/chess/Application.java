package chess;

import java.util.Scanner;

public class Application {

    private Scanner scanner = new Scanner(System.in);

    public String getInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("start") || input.equalsIgnoreCase("end")) {
                return input;
            } else {
                System.out.println("start 와 end 중 하나를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        Board board = new Board();

        String input = application.getInput();
        if (input.equalsIgnoreCase("start")) {
            board.initialize();
        } else {
            System.out.println("게임을 종료합니다.");
        }
    }
}
