package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    public int readLadderHeight() {
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public int readLadderPerson(){
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }

    public int readLadderNumber(){
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
