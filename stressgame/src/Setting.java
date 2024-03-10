import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Setting extends JFrame {
    Setting() {
        // initialise
        this.setTitle("Stress-Setting");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setLayout(null);
        this.setSize(600, 700);
        this.setResizable(false);// prevent user from freely resize the window

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        // make frame visible
        this.setVisible(true);
    }

}
