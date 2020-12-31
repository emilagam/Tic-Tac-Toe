package TicTacToe;

public class Winner {

    private static int size;
    private static int[][] field;
    private static Cheks cheks[] = {
            new Fill(),
            new Diagonal(),
            new Horizontal(),
            new Vertical(),
            new SideDiagonal()};


    public static String checkWinner(int sizeP, int[][] fieldP) {

        size = sizeP;
        field = fieldP;

        String winner = "";

        for (Cheks check : cheks) {
            winner = check.check();

            if (!winner.equals("")) {
                break;
            }
        }

        return winner;
    }

    interface Checks {

        String check();

    }

    private static class Cheks implements Checks {

        static String winnerBySum(int sum) {
            if (sum == size) {
                return "x";
            } else if (sum == -size) {
                return "o";
            }
            else {
                return "";
            }
        }

        @Override
        public String check() {
            return null;
        }

    }

    private static class Fill extends Cheks implements Checks {

        @Override
        public String check() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (field[i][j] == 0) {
                        return "";
                    }
                }
            }

            return "nobody";
        }
    }

    private static class Horizontal extends Cheks implements Checks {

        @Override
        public String check() {

            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum = 0;
                for (int j = 0; j < size; j++) {
                    sum += field[i][j];
                }

                if (sum >= size) {
                    break;
                }
            }

            return winnerBySum(sum);

        }
    }

    private static class Vertical extends Cheks implements Checks {

        @Override
        public String check() {

            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum = 0;
                for (int j = 0; j < size; j++) {
                    sum += field[j][i];
                }

                if (sum >= size) {
                    break;
                }
            }

            return winnerBySum(sum);

        }
    }

    private static class Diagonal extends Cheks implements Checks {

        @Override
        public String check() {

            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum += field[i][i];
            }

            return winnerBySum(sum);

        }
    }

    private static class SideDiagonal extends Cheks implements Checks {

        @Override
        public String check() {

            int sum = 0;

            for (int i = 0; i < size; i++) {
                sum += field[i][size - i - 1];
            }

            return winnerBySum(sum);

        }
    }

}
