import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class GameGUI {
    private Game game;
    private TicTacToe frame;
    private TicTacToeTileButton[][] buttons;

    public GameGUI(Game game, TicTacToe frame) {
        this.game = game;
        this.frame = frame;

        frame.setLayout(new GridLayout(4, 3));
        buttons = new TicTacToeTileButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TicTacToeTileButton(row, col);
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                frame.add(buttons[row][col]);
            }
        }

        JPanel blankPanel = new JPanel();
        frame.add(blankPanel);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Do you want to quit?", "Quit", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        frame.add(quitButton);
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void actionPerformed(ActionEvent e) {
            if (game.makeMove(row, col)) {
                buttons[row][col].setText(game.getCurrentPlayer());
                if (game.checkForWin()) {
                    JOptionPane.showMessageDialog(frame, "Player " + game.getCurrentPlayer() + " wins!", "Winner", JOptionPane.INFORMATION_MESSAGE);
                    playAgainPrompt();
                } else if (game.checkForTie()) {
                    JOptionPane.showMessageDialog(frame, "It's a tie!", "Tie", JOptionPane.INFORMATION_MESSAGE);
                    playAgainPrompt();
                } else {
                    game.switchPlayer();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid move! Try again.", "Invalid Move", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void playAgainPrompt() {
        int result = JOptionPane.showConfirmDialog(frame, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            game.resetGame();
            resetButtonLabels();
        } else {
            System.exit(0);
        }
    }

    private void resetButtonLabels() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }
    }
}
