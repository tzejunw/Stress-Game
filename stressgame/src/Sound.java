import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;
import java.io.*;

public class Sound {
    // Audio clip object 
    Clip clip;
    File soundFiles[] = new File[30];
    

    public Sound() {
        // getClass().getResource() is used to locate the relative file path of a sound file

        soundFiles[0] = new File("music/bgm.wav");
        soundFiles[1] = new File("music/selectsound.wav");
        soundFiles[2] = new File("music/swapcard.wav");
        soundFiles[3] = new File("music/MenuBGM.wav");
        soundFiles[4] = new File("music/PlayerCard.wav");
        soundFiles[5] = new File("music/AICard.wav");
        soundFiles[6] = new File("music/flipCards.wav");
        soundFiles[7] = new File("music/winTrumpet.wav");
        soundFiles[8] = new File("music/lose1.wav");
        soundFiles[9] = new File("music/loseWhirl.wav");
        
        // can add more music
    }

    // plays sound file
    public void playSound(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFiles[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch(Exception e) {
            e.printStackTrace();
        }

        clip.start();
    }

    // to loop bgm
    public void playSoundLoop(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFiles[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // to stop playing bgm (for mute button)
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}

