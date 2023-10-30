

public class Game {
    private TicTacToeBoard board;
    private String currentPlayer;
    private int moves;

    public Game() {
        board = new TicTacToeBoard();
        currentPlayer = "X";
        moves = 0;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int row, int col) {
        if (board.isValidMove(row, col)) {
            board.placeMove(row, col, currentPlayer);
            moves++;
            return true;
        }
        return false;
    }

    public boolean checkForWin() {
        return board.isRowWin(currentPlayer) || board.isColWin(currentPlayer) || board.isDiagonalWin(currentPlayer);
    }

    public boolean checkForTie() {
        if (moves >= 9) {
            return true;
        }

        boolean xFlag = false;
        boolean oFlag = false;


        for (int row = 0; row < 3; row++) {
            if (board.getTile(row, 0).equals("X") ||
                    board.getTile(row, 1).equals("X") ||
                    board.getTile(row, 2).equals("X")) {
                xFlag = true;
            }
            if (board.getTile(row, 0).equals("O") ||
                    board.getTile(row, 1).equals("O") ||
                    board.getTile(row, 2).equals("O")) {
                oFlag = true;
            }

            if (!(xFlag && oFlag)) {
                return false;
            }

            xFlag = oFlag = false;
        }


        for (int col = 0; col < 3; col++) {
            if (board.getTile(0, col).equals("X") ||
                    board.getTile(1, col).equals("X") ||
                    board.getTile(2, col).equals("X")) {
                xFlag = true;
            }
            if (board.getTile(0, col).equals("O") ||
                    board.getTile(1, col).equals("O") ||
                    board.getTile(2, col).equals("O")) {
                oFlag = true;
            }

            if (!(xFlag && oFlag)) {
                return false;
            }
        }

        xFlag = oFlag = false;

        if (board.getTile(0, 0).equals("X") ||
                board.getTile(1, 1).equals("X") ||
                board.getTile(2, 2).equals("X")) {
            xFlag = true;
        }
        if (board.getTile(0, 0).equals("O") ||
                board.getTile(1, 1).equals("O") ||
                board.getTile(2, 2).equals("O")) {
            oFlag = true;
        }
        if (!(xFlag && oFlag)) {
            return false;
        }

        xFlag = oFlag = false;

        if (board.getTile(0, 2).equals("X") ||
                board.getTile(1, 1).equals("X") ||
                board.getTile(2, 0).equals("X")) {
            xFlag = true;
        }
        if (board.getTile(0, 2).equals("O") ||
                board.getTile(1, 1).equals("O") ||
                board.getTile(2, 0).equals("O")) {
            oFlag = true;
        }

        return xFlag && oFlag;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
    }

    public void resetGame() {
        board.resetBoard();
        currentPlayer = "X";
        moves = 0;
    }
}
