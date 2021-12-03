package tetris;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author darahaas15
 */
public class AudioPlayer {
       private String soundsFolder = "tetrissounds" + File.separator;
       private String clearLinePath = soundsFolder + "line.wav";
       private String gameOverPath = soundsFolder + "success.wav";

       private Clip clearLineSound, gameOverSound;

       public AudioPlayer() {
              try {
                     clearLineSound = AudioSystem.getClip();
                     gameOverSound = AudioSystem.getClip();

                     clearLineSound.open(AudioSystem.getAudioInputStream(new File(clearLinePath).getAbsoluteFile()));
                     gameOverSound.open(AudioSystem.getAudioInputStream(new File(gameOverPath).getAbsoluteFile()));
              } catch (LineUnavailableException e) {
                     e.printStackTrace();
              } catch (UnsupportedAudioFileException e) {
                     e.printStackTrace();
              } catch (IOException e) {
                     e.printStackTrace();
              }
       }

       public void playClearLine() {
              clearLineSound.setFramePosition(0);
              clearLineSound.start();
       }

       public void playGameOver() {
              gameOverSound.setFramePosition(0);
              gameOverSound.start();
       }
}