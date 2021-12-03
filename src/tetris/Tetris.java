package tetris;

import javax.swing.JOptionPane;

/**
 *
 * @author darahaas15
 */
public class Tetris {

    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;

    public static void start() {
        gf.setVisible(true);
        gf.startGame();
    }

    public static void showLeaderboard() {
        lf.setVisible(true);
    }

    public static void showStartup() {
        sf.setVisible(true);
    }

    public static void gameOver() {
        JOptionPane.showInputDialog("Game OVer!\nPlease emter your name.");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gf = new GameForm();
                sf = new StartupForm();
                lf = new LeaderboardForm();

                sf.setVisible(true);
            }
        });
    }

}
