import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, PAPER, SCISSORS
}

enum Winner {
    USER, COMPUTER, DRAW
}

public class RPSApp {
    /**
    * Get the computer’s move (randomly generated)
    */
    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        // Code using n to select a HandSign
        switch (n) {
            case 0: computerMove = HandSign.ROCK; break;
            case 1: computerMove = HandSign.PAPER; break;
            case 2: computerMove = HandSign.SCISSORS; break;
        }

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);

        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;

        // Repeat until valid input
        do {
            // Output game title
            System.out.println("=== Rock, Paper, Scissors Game ===");

            // Ask the user to input their choice
            System.out.print("Input your choice {r,p,s,q}: ");

            // Convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            // Initialise varibale to hold users 
            // Analyse user input
            switch (inChar) {
                case 'q': System.exit(0); break;
                case 'r': validInput = true; playerHandSign = HandSign.ROCK; break;
                case 'p': validInput = true; playerHandSign = HandSign.PAPER; break;
                case 's': validInput = true; playerHandSign = HandSign.SCISSORS; break;
                default: validInput = false;
            }
        } while(!validInput);

        return playerHandSign;
    }

    /**
     * Check who wins
     *
     * @param h1 the user's hand sign
     * @param h2 the computer's hand sign
     * @return Winner.DRAW if two signs equal, 
     *         Winner.COMPUTER if the second sign wins, 
     *         Winner.USER if the first sign wins
     *
     */
    public static Winner whoWins(HandSign h1, HandSign h2){
        // Check all cases where h1 wins
        if (h1 == HandSign.ROCK && h2 == HandSign.SCISSORS) return Winner.USER;
        else if (h1 == HandSign.SCISSORS && h2 == HandSign.PAPER) return Winner.USER;
        else if (h1 == HandSign.PAPER && h2 == HandSign.ROCK) return Winner.USER;

        // Now check if it is a draw
        if (h1.name().equals(h2.name())) return Winner.DRAW;

        // Therefore, the only other case is if the computer has won
        return Winner.COMPUTER;
    }

    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;    // Player’s sign from keyboard
        HandSign computerMove;  // Computer’s random sign

        Winner winner = null;
        boolean gameOver = false;

        // Simple game loop
        while (!gameOver){
            // Repeat this process till the user quits

            // Step1: Get the player move from the keyboard input
            HandSign users_move = getPlayerMove();

            // Step2: Get the computer’s move (randomly generated)
            HandSign computers_move = getComputerMove();

            // Step3: Check who wins
            winner = whoWins(users_move, computers_move);

            // Step4: Output who played what and who won the round
            System.out.println("User: " + users_move);
            System.out.println("Computer: " + computers_move);
            System.out.printf("Winner: %s\n\n", (winner == Winner.USER) ? "User" : (winner == Winner.COMPUTER) ? "Computer" : "Draw");

            // Step5: Update and print player/computer scores
            if (winner == Winner.USER) playerScore++;
            else if (winner == Winner.COMPUTER) computerScore++;
            System.out.printf("Scores:\nUser: %d\nComputer: %d\n\n\n", playerScore, computerScore);
        }
    }
}