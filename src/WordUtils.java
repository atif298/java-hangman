import java.util.ArrayList;
import java.util.Random;

public class WordUtils {

    private static ArrayList<String> words = new ArrayList<>();

        static {
            words.add("car");
            words.add("homo sapiens");
            words.add("playstation");
            words.add("java");
            words.add("england");
            words.add("superman");
            words.add("box");
            words.add("bugatti");
            words.add("zucchini");
            words.add("xenon");
        }

    private static final Random RANDOM  = new Random();

        public static String generateWord() {

            return words.get(RANDOM.nextInt(words.size()));
        }

    public static String dashExchanger(String hiddenWord, String guess, String word) {
        // dashExchanger uses the parameters in the brackets
        String [] wordArray = word.split("");
        // variable wordArray is the string word but each character is in a list
        String newDash = hiddenWord;
        // newDash is a variable that will be used to hold the correctly guessed characters while showing dashes for unguessed characters
        for (int i = 0; i < wordArray.length; i++) {
            // This forLoop will run for every letter in wordArray
            if (wordArray[i].equals(guess)) {
                // If the content of the current index that is being looked at is equal to the guess then ...
                newDash = newDash.substring(0,i) + guess + newDash.substring(i + 1);
                // new dash will now equal to a substring of a dash at... the correctly guessed letter and then a substring of dashes for all indexes after guess.
            }
        }
        System.out.println(newDash);
        // This will print the new hiddenword with correctly guessed letters
        return newDash;
        // will return the hiddenword with correctly guessed letters to allow the loop to run again and add new correctly guessed letters
    }
}
