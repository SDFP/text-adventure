package website.sdfp.textadventure.library;

import java.util.Scanner;

public class InputUtils {
    public static String getInput(String prompt) {
        System.out.print(prompt + " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
