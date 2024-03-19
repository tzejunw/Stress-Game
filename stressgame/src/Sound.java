// for playing music/sfx
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Sound {
    public static void main(String[] args) {
        playMusic();
        
    }
    
    public static void playMusic() {
        try {
               
            File musicPath = new File("./sounds/StressBGM.wav");
    
            if (musicPath.exists()) {
                System.out.println("playing music");
                // create input stream with music we want to play
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip(); // think of Clip as a CD player object
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


