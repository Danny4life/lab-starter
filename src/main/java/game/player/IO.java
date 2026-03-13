package game.player;

import java.util.Scanner;

public class IO {



        private static final Scanner scanner = new Scanner(System.in);

        public static void println(String message) {
            System.out.println(message);
        }

        public static String readln(String prompt) {
            System.out.print(prompt);
            return scanner.nextLine();
        }
    }

