import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Win extends JFrame implements ActionListener {
    JButton newGame,mainMenu;
    Sound sound = new Sound();

    String filename;
    Win(String filename){
        // Sound
        sound.playSound(7);

        // panel
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel btnPanel = new JPanel();

        topPanel.setBackground(new Color(36,51,56));
        middlePanel.setBackground(new Color(36,51,56));
        bottomPanel.setBackground(new Color(36,51,56));
        btnPanel.setBackground(new Color(36,51,56));

        topPanel.setPreferredSize(new Dimension(100, 500));
        middlePanel.setPreferredSize(new Dimension(100, 80));
        bottomPanel.setPreferredSize(new Dimension(100, 80));
        btnPanel.setPreferredSize(new Dimension(250, 150));

        ImageIcon titlePic=new ImageIcon(filename);
        JLabel title = new JLabel(titlePic);

        // button1
        newGame = new JButton("New Game");
        newGame.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        newGame.setBorderPainted(false);
        newGame.setBackground(new Color(137,219,220));
        newGame.setForeground(new Color(135,69,72));
        newGame.setFocusable(false);
        newGame.addActionListener(this);

        // button2
        mainMenu = new JButton("Main Menu");
        mainMenu.setFont(new Font("Serif Bold", Font.PLAIN, 20));
        mainMenu.setBorderPainted(false);
        mainMenu.setBackground(new Color(137,219,220));
        mainMenu.setForeground(new Color(135,69,72));
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);
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
        btnPanel.setLayout(new GridLayout(2, 1, 0, 30));

        middlePanel.add(btnPanel, BorderLayout.SOUTH);
        btnPanel.add(newGame);
        btnPanel.add(mainMenu);
        topPanel.add(title);
        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if(click.getSource()==mainMenu){
            sound.stop();
            sound.playSound(1);
            new menu();
            System.out.println("clicked on mainMenu");
            this.dispose();
        }else if(click.getSource()==newGame){
            sound.stop();
            sound.playSound(1);
            new Mode();
            System.out.println("clicked on new game");
            this.dispose();
        }
        
    }
    
    // public static void main(String[] args) {
    //     new Win();
    // }
    
}
