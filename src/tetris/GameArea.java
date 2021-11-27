package tetris;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author darahaas15
 */
public class GameArea extends JPanel {
    private int gridRows;
    private int gridColumns;
    private int gridCellSize;

    // Tetris block class
    private TetrisBlock block;

    public GameArea(JPanel placeholder, int columns) {
        placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());

        gridColumns = columns;
        gridCellSize = this.getBounds().width / gridColumns;
        gridRows = this.getBounds().height / gridCellSize;
        spawnBlock();
    }

    public void spawnBlock() {
        // Spawn block
        block = new TetrisBlock(new int[][] { { 1, 0 }, { 1, 0 }, { 1, 1 } }, Color.blue);

    }

    private void drawBlock(Graphics g) {
        int h = block.getHeight();
        int w = block.getWidth();
        int s[][] = block.getShape();
        Color c = block.getColor();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (s[row][col] == 1) {
                    int x;
                    int y;
                    g.setColor(c);
                    g.fillRect(col * gridCellSize, row * gridCellSize, gridCellSize, gridCellSize);
                    g.setColor(Color.black);
                    g.drawRect(col * gridCellSize, row * gridCellSize, gridCellSize, gridCellSize);

                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Overriding the paint component
        super.paintComponent(g);
        drawBlock(g);
    }
}
