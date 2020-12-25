import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Game game;
        game = new Game(3);

        System.out.println("enter coordinates like '1,2'");

        while (!game.finished) {

            System.out.println(game.who + ":");
            String coordinate = in.next();

            game.enterStep(coordinate);

            System.out.println(game.toString());
        }

        System.out.println("winner is " + game.who);

    }

}

