package tetris;

/**
 *
 * @author darahaas15
 */
public class GameThread extends Thread {

    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;

    private int pause = 1000;
    private int speedupPerLevel = 100;

    public GameThread(GameArea ga, GameForm gf) {
        this.ga = ga;
        this.gf = gf;
    }

    @Override
    public void run() {

        while (true) {
            ga.spawnBlock();
            while (ga.moveBlockDown() == true) {
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (ga.isBlockOutOfBounds()) {
                System.out.println("Game Over");
                break;
            }

            ga.moveBlockToBackground();
            score += ga.clearLines();
            gf.updateScore(score);

            int lvl = score / scorePerLevel + 1;
            if (lvl > level) {
                level = lvl;
                gf.updateLevel(level);
                pause -= speedupPerLevel;
            }
        }
    }
}
