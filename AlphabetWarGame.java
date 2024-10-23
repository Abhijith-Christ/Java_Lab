import java.util.Scanner;

public class AlphabetWarGame {

    // Default strengths for left and right side letters
    private int wStrength = 4, pStrength = 3, bStrength = 2, sStrength = 1;
    private int mStrength = 4, qStrength = 3, dStrength = 2, zStrength = 1;

    // Constructor with default strengths
    public AlphabetWarGame() {
    }

    // Constructor with customizable strengths
    public AlphabetWarGame(int wStrength, int pStrength, int bStrength, int sStrength, int mStrength, int qStrength, int dStrength, int zStrength) {
        this.wStrength = wStrength;
        this.pStrength = pStrength;
        this.bStrength = bStrength;
        this.sStrength = sStrength;
        this.mStrength = mStrength;
        this.qStrength = qStrength;
        this.dStrength = dStrength;
        this.zStrength = zStrength;
    }

    // Method to calculate the winner from a single word
    public String AlphabetWar(String word) {
        int leftScore = 0, rightScore = 0;

        // Traverse through the string and calculate score for each side
        for (char ch : word.toCharArray()) {
            switch (ch) {
                case 'w': leftScore += wStrength; break;
                case 'p': leftScore += pStrength; break;
                case 'b': leftScore += bStrength; break;
                case 's': leftScore += sStrength; break;
                case 'm': rightScore += mStrength; break;
                case 'q': rightScore += qStrength; break;
                case 'd': rightScore += dStrength; break;
                case 'z': rightScore += zStrength; break;
            }
        }

        // Determine the winner
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Method to calculate the winner from two separate words (one for each side)
    public String AlphabetWar(String leftWord, String rightWord) {
        int leftScore = 0, rightScore = 0;

        // Calculate score for the left side
        for (char ch : leftWord.toCharArray()) {
            switch (ch) {
                case 'w': leftScore += wStrength; break;
                case 'p': leftScore += pStrength; break;
                case 'b': leftScore += bStrength; break;
                case 's': leftScore += sStrength; break;
            }
        }

        // Calculate score for the right side
        for (char ch : rightWord.toCharArray()) {
            switch (ch) {
                case 'm': rightScore += mStrength; break;
                case 'q': rightScore += qStrength; break;
                case 'd': rightScore += dStrength; break;
                case 'z': rightScore += zStrength; break;
            }
        }

        // Determine the winner
        if (leftScore > rightScore) {
            return "Right side wins!";
        } else if (rightScore > leftScore) {
            return "Left side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Create an instance of AlphabetWarGame
        AlphabetWarGame game = new AlphabetWarGame();

        // Ask user to input a word
        System.out.print("Enter the word for Alphabet War: ");
        String word = scanner.nextLine();

        // Call the method and print the result
        System.out.println(game.AlphabetWar(word));

        // Close the scanner
        scanner.close();
}
}