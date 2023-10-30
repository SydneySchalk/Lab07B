import javax.swing.JButton;
import java.awt.Font;

public class TicTacToeTileButton extends JButton {
    private int row;
    private int col;

    public TicTacToeTileButton(int row, int col) {
        this.row = row;
        this.col = col;
        setFont(new Font("Arial", Font.PLAIN, 48));
        setFocusPainted(false);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
