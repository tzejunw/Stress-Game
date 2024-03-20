import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class menu extends JFrame implements ActionListener{
    JButton newGame,guide,setting,exit;
    Sound sound;

    menu() {
        // label
        // ImageIcon MLogo=new ImageIcon("resource/temp_Mlogo.jpg");
        // JLabel mLogo=new JLabel(MLogo);

        //Border border=BorderFactory.createLineBorder(Color.BLUE,2);

        sound = new Sound();

        // for menu BGM
        playMusic(3);
        

        JLabel title = new JLabel();
        title.setText("STRESS");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        title.setForeground(new Color(0xADD8E6));
        title.setFont(new Font("Serif Bold",Font.PLAIN,60));
        //title.setBorder(border);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBounds(100, 50, 400, 100); // Adjusted bounds for the title label

        //panel to hold both logo and title
        // JPanel titleJPanel= new JPanel(new BorderLayout());
        // titleJPanel.add(mLogo,BorderLayout.NORTH);
        // titleJPanel.add(title,BorderLayout.CENTER);

        //button1
        newGame=new JButton("New Game");
        newGame.setBounds(200,200,100,50);
        newGame.addActionListener(this);
        //button2
        guide=new JButton("Guide");
        guide.setBounds(200,300,100,50);
        guide.addActionListener(this);
        //button3
        setting=new JButton("Setting");
        setting.setBounds(200,400,100,50);
        setting.addActionListener(this);
        //button4
        exit=new JButton("Exit");
        exit.setBounds(200,500,100,50);
        exit.addActionListener(this);

        // initialise
        this.setTitle("Stress");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setLayout(null);
        this.setSize(600, 700);
        this.setResizable(false);// prevent user from freely resize the window

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        // content pane
        this.getContentPane().setBackground(new Color(255,255,255));// change color of backgrond

        this.add(title);
        this.add(newGame);
        this.add(guide);
        this.add(setting);
        this.add(exit);

        // make frame visible
        this.setVisible(true);
    }

    //for testing only
    // public static void main(String[] args) {
    //     new menu();

    // }

    @Override
    public void actionPerformed(ActionEvent click){
        if(click.getSource()==newGame){
            stopMusic();
            playSE(1);
            System.out.println("Clicked on newGame");
            //direct to stress page
            new Stress();
            // play bgm
            playMusic(0);
            this.dispose();
        }else if(click.getSource()==setting){
            stopMusic();
            playSE(1);
            //direct to setting page
            new Setting();
            System.out.println("Clicked on Setting");
            this.dispose();
        }else if(click.getSource()==guide){
            stopMusic();
            playSE(1);
            //direct to guide page
            new Guide();
            System.out.println("Clicked on Guide");
            this.dispose();
        }else if(click.getSource()==exit){
            playSE(1);
            System.out.println("Clicked on Exit");
            System.exit(0); // Terminate the application
        }
    }

    // BGM and sound effects
    public void playMusic(int i) {
        // initially currentSound is -1, so that first time playMusic is called, always plays the track
        // the below code checks if i is a different track, then it will change the music
        // otherwise, this method will not do anything, and continue with the same track being played
        sound.setFile(i);
        sound.playMusic();
        sound.loop();
        
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.playMusic();
    }

}
