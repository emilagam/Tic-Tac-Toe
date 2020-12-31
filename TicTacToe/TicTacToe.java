package TicTacToe;

import static TicTacToe.Winner.checkWinner;

public class TicTacToe {
    
    final private int size;
    private int[][] field;
    public char whoPlays = 'x';
    public String winner;

    public TicTacToe(int size) {
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
                    answer.append("o|");
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

        int filedValue = whoPlays == 'x' ? 1 : -1;
        field[x][y] = filedValue;

        winner = checkWinner(size, field);

        whoPlays = whoPlays == 'x' ? 'o' : 'x';

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
            answer.error = "wrong input, write coordinates likes '1,2'";
            return answer;
        }

        answer.x = Character.getNumericValue(coordinate.charAt(0)) - 1;
        answer.y = Character.getNumericValue(coordinate.charAt(2)) - 1;

        if (answer.x > 2 || answer.y > 2 || answer.x < 0 || answer.y < 0) {
            answer.error = "one of coordinate more than desk is";
            return answer;
        }

        if (field[answer.x][answer.y] != 0) {
            answer.error = "this field is already fill";
            return answer;
        }

        return answer;
    }

}

