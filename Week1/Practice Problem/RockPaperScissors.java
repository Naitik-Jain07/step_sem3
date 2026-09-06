import java.util.Random;
import java.util.Scanner;

class RockPaperScissorsGame {

    String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }
}

public class RockPaperScissors {
        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        RockPaperScissorsGame game = new RockPaperScissorsGame();

        System.out.println("=== Rock-Paper-Scissors Game ===");
        for (int i = 0; i < 5; i++) {
            System.out.print("Round " + (i + 1) +
                    " - Enter Rock, Paper, or Scissors: ");
            String playerMove = scanner.nextLine();

            while (!playerMove.equalsIgnoreCase("Rock") &&
                   !playerMove.equalsIgnoreCase("Paper") &&
                   !playerMove.equalsIgnoreCase("Scissors")) {

                System.out.print("Invalid move. Enter Rock, Paper, or Scissors: ");
                playerMove = scanner.nextLine();
            }

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            String computerMove = moves[random.nextInt(3)];

            String result = game.playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Player: " + playerMove +
                    " | Computer: " + computerMove +
                    " | Result: " + result);
            System.out.println();
        }

        double winPercentage = (wins * 100.0) / 5;
        System.out.println("========== Final Summary ==========");
        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);
        scanner.close();
    }
}