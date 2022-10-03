import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int lives = 10;
        boolean alive = true;
        Scanner scanner = new Scanner(System.in);
        String word = WordUtils.generateWord();
        String hiddenWord = word.replaceAll("[a-z]", "_");

        System.out.println("------------------ WELCOME TO HANGMAN ------------------");
        while (alive) {
            System.out.println("[You have " + lives + " lives]");
            System.out.println("Guess the letter or word for '" + hiddenWord + "'");
            String guess = scanner.nextLine().toLowerCase();

            for (int i = 0; i < guess.length(); i++) {
                if (word.contains(guess)) {
                    hiddenWord = WordUtils.dashExchanger(hiddenWord, guess, word);
                    System.out.println("You guessed " + guess + " correct!");
                    if (!hiddenWord.contains("_")) {
                        alive = false;
                        System.out.println("----------YOU WON AND GUESSED " + word + " CORRECTLY----------");
                    }
                } else {
                    if (lives < 1) {

                        alive = false;
                    } else {
                        lives -- ;

                        if (alive) {
                            System.out.println("-1 life for each letter in '" + guess + "' wrong!!!");
                        } else {
                            System.out.println("You have no lives remaining!!!");
                            System.out.println("------------------ GAME OVER------------------ ");
                        }
                    }
                }
            }
        }
    }
}