public class TicTacToeBoard {
    private String[][] board;

    public TicTacToeBoard() {
        board = new String[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public String getTile(int row, int col) {
        return board[row][col];
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col].isEmpty();
    }

    public void placeMove(int row, int col, String player) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
        }
    }

    public void resetBoard() {
        initializeBoard();
    }

    public boolean isRowWin(String player) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isColWin(String player) {
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiagonalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }
}
