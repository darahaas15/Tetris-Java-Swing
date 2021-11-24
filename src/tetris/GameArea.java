package tetris;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author darahaas15
 */
public class GameArea extends JPanel {
    public GameArea() {
        this.setBounds(0, 0, 100, 100);
        this.setBackground(Color.red);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Overriding the paint component
        super.paintComponent(g);
        g.fillRect(0, 0, 50, 50);
    }
}
