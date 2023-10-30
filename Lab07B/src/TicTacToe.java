import javax.swing.*;
import java.awt.*;


public class TicTacToe extends JFrame {
    private Game game;
    private GameGUI gameGUI;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setPreferredSize(new Dimension(400, 400));
        pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) (screenSize.getWidth() / 2 - getWidth() / 2);
        int centerY = (int) (screenSize.getHeight() / 2 - getHeight() / 2);
        setLocation(centerX, centerY);

        game = new Game();
        gameGUI = new GameGUI(game, this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TicTacToe frame = new TicTacToe();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
