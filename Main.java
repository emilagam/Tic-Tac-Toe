import java.util.Scanner;
import TicTacToe.TicTacToe;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        TicTacToe game;
        game = new TicTacToe(3);

        System.out.println("enter coordinates like '1,2'");

        while (true) {

            System.out.println(game.whoPlays + ":");
            String coordinate = in.next();

            game.enterStep(coordinate);

            System.out.println(game.toString());

            // continue play if we don't have a winner
            if (game.winner.equals("")) {
                continue;
            }

            System.out.println("winner is " + game.winner);
            System.out.println("want to play again? write y/n");

            String playAgain = "";
            while (playAgain.equals("")) {
                playAgain = in.next();

                if (playAgain.equals("n")) {
                    System.exit(0);
                } else if (playAgain.equals("y")) {
                    game = new TicTacToe(3);
                } else {
                    System.out.println("didn't got it, y/n?");
                    playAgain = "";
                }
            }
        }
    }
}

