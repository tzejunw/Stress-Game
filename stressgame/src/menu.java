import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class menu extends JFrame implements ActionListener {
    JButton newGame, guide, setting, exit;
    Sound sound = new Sound(); // create a Sound object, so we can call play music methods
    // Image backgrouImage;

    menu() {

        // for menu BGM
        sound.playSoundLoop(3);


        // panel
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel btnPanel = new JPanel();

        topPanel.setBackground(new Color(36,51,56));
        middlePanel.setBackground(new Color(36,51,56));
        bottomPanel.setBackground(new Color(36,51,56));
        btnPanel.setBackground(new Color(36,51,56));

        topPanel.setPreferredSize(new Dimension(100, 400));
        middlePanel.setPreferredSize(new Dimension(100, 100));
        bottomPanel.setPreferredSize(new Dimension(100, 30));
        btnPanel.setPreferredSize(new Dimension(250, 250));

        ImageIcon titlePic=new ImageIcon("resource/BG2.png");
        JLabel title = new JLabel(titlePic);

        JLabel watermark = new JLabel();
        watermark.setText("Project done by G1-T5");
        watermark.setForeground(Color.gray);
        watermark.setFont(new Font("Serif", Font.PLAIN, 14));

        // button1
        newGame = new JButton("New Game");
        newGame.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        newGame.setBorderPainted(false);
        newGame.setBackground(new Color(137,219,220));
        newGame.setForeground(new Color(135,69,72));
        newGame.setFocusable(false);
        newGame.addActionListener(this);
        

        // button2
        guide = new JButton("Guide");
        guide.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        guide.setBorderPainted(false);
        guide.setBackground(new Color(137,219,220));
        guide.setForeground(new Color(135,69,72));
        guide.setFocusable(false);
        guide.addActionListener(this);

        // button3
        setting = new JButton("Setting");
        setting.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        setting.setBorderPainted(false);
        setting.setBackground(new Color(137,219,220));
        setting.setForeground(new Color(135,69,72));
        setting.setFocusable(false);
        setting.addActionListener(this);

        // button4
        exit = new JButton("Exit");
        exit.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        exit.setBorderPainted(false);
        exit.setBackground(new Color(137,219,220));
        exit.setForeground(new Color(135,69,72));
        exit.setFocusable(false);
        exit.addActionListener(this);

        // initialise
        // Toolkit tk=Toolkit.getDefaultToolkit(); //Initializing the Toolkit class.
        // Dimension screenSize = tk.getScreenSize(); //Get Screen resolution

        this.setTitle("Stress");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setLayout(new BorderLayout());
        this.setSize(700, 800);
        this.setResizable(false);// prevent user from freely resize the window
        this.setLocationRelativeTo(null);// keep frame in the middle of screen when generates
        // this.setBackground(backgrouImage);

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        // content pane
        this.getContentPane().setBackground(new Color(255, 255, 255));// change color of backgrond

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        btnPanel.setLayout(new GridLayout(3, 1, 0, 30));

        middlePanel.add(btnPanel, BorderLayout.SOUTH);

        btnPanel.add(newGame);
        btnPanel.add(guide);
        //btnPanel.add(setting);
        btnPanel.add(exit);
        topPanel.add(title);
        bottomPanel.add(watermark);
        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if (click.getSource() == newGame) {
            sound.stop();
            sound.playSound(1);
            System.out.println("Clicked on newGame");
            // direct to mode page
            new Mode();
            this.dispose();
        } /*else if (click.getSource() == setting) {
            sound.stop();
            sound.playSound(1);
            // direct to setting page
            new Setting();
            System.out.println("Clicked on Setting");
            this.dispose();
        }*/ else if (click.getSource() == guide) {
            sound.stop();
            sound.playSound(1);
            // direct to guide page
            new Guide();
            System.out.println("Clicked on Guide");
            this.dispose();
        } else if (click.getSource() == exit) {
            sound.playSound(1);
            ;
            System.out.println("Clicked on Exit");
            System.exit(0); // Terminate the application
        }
    }

}
