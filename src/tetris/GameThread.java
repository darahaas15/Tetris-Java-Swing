package tetris;

/**
 *
 * @author darahaas15
 */
public class GameThread extends Thread {

    private GameArea ga;

    public GameThread(GameArea ga) {
        this.ga = ga;
    }

    @Override
    public void run() {

        while (true) {
            ga.spawnBlock();
            while (ga.moveBlockDown() == true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
