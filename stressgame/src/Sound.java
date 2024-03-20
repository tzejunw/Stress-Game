import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/music/bgm.wav");
        soundURL[1] = getClass().getResource("/music/selectsound.wav");
        soundURL[2] = getClass().getResource("/music/swapcard.wav");
        // can add more music
    }

    // opens audio file
    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // plays sound file
    public void playMusic() {
        clip.start();
    }

    // to loop bgm
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // to stop playing bgm (for mute button)
    public void stop() {
        clip.stop();
    }
}

