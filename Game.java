import java.util.Arrays;

public class Game {
    private int size;
    private int[][] field;
    public char who = 'x';
    public boolean finished = false;

    public Game(int size) {
        this.size = size;
        field = new int[size][size];
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if (field[i][j] == 1) {
                    answer.append("x|");
                }
                else if (field[i][j] == -1) {
                    answer.append("y|");
                }
                else {
                    answer.append(" |");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    public void enterStep(String coordinate) {

        coordinateAnswer answer = getCoordinates(coordinate);
        if (!answer.error.equals("")) {
            System.out.println(answer.error);
            return;
        }

        int x = answer.x;
        int y = answer.y;

        int filedValue = who == 'x' ? 1 : -1;
        field[x][y] = filedValue;

        finished = endGame();

        if (!finished) {
            // change player
            who = who == 'x' ? 'y' : 'x';
        }

    }

    protected class coordinateAnswer {
        int x, y;
        String error;

        public coordinateAnswer(int x, int y, String error) {
            this.x = x;
            this.y = y;
            this.error = error;
        }

    }

    private coordinateAnswer getCoordinates(String coordinate) {

        coordinateAnswer answer = new coordinateAnswer(0, 0, "");

        if (coordinate.length() != 3) {
            answer.error = "wrong input";
            return answer;
        }

        answer.x = Character.getNumericValue(coordinate.charAt(0)) - 1;
        answer.y = Character.getNumericValue(coordinate.charAt(2)) - 1;

        if (answer.x > 2 || answer.y > 2 || answer.x < 0 || answer.y < 0) {
            answer.error = "more than desk is";
            return answer;
        }

        if (field[answer.x][answer.y] != 0) {
            answer.error = "this field is fill";
            return answer;
        }

        return answer;
    }

    public boolean endGame() {
        int sum;

        // horizontal
        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                sum += field[i][j];
            }

            if (checkWinner(sum)) {
                return true;
            }
        }

        // vertical
        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                sum += field[j][i];
            }

            if (checkWinner(sum)) {
                return true;
            }
        }

        // diagonal 1
        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    sum += field[i][j];
                }
            }

            if (checkWinner(sum)) {
                return true;
            }
        }

        // side diagonal
        for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = 0; j < size; j++) {
                if (size - i == j || size - j == i) {
                    sum += field[i][j];
                }
            }

            if (checkWinner(sum)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkWinner(int sum) {
        return sum == size || sum == -size;
    }


}

