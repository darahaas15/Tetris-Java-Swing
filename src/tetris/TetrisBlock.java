package tetris;

import java.awt.Color;

/**
 *
 * @author darahaas15
 */
public class TetrisBlock {
    private int[][] shape;
    private Color color;
    private int x, y;

    public TetrisBlock(int[][] shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public void spawn(int gridWidth) {
        y = -getHeight();
        x = (gridWidth - getWidth()) / 2;
    }

    // Accessors
    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHeight() {
        return shape.length;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Moving the block to the left
    public void moveLeft() {
        x--;
    }

    // Moving the block to the right
    public void moveRight() {
        x++;
    }

    // Moving the block down
    public void moveDown() {
        y++;
    }

    public int getBottomEdge() {
        return y + getHeight();
    }

}