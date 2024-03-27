package stressgame.frames;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import stressgame.sound.*;

public class Guide extends JFrame implements ActionListener{
    JButton backBtn;
    JLabel imageLabel;
    Sound sound = new Sound();
    
    public Guide() { 
        //back
        ImageIcon btnImage=new ImageIcon("src/resource/backBTN.png");
        backBtn=new JButton(btnImage);
        backBtn.addActionListener(this);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusable(false);
        backBtn.setBorderPainted(false);

        // Load the image
        ImageIcon imageIcon = new ImageIcon("src/resource/guide.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(700, 750, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        // Create JLabel to display the image
        imageLabel = new JLabel(imageIcon);

        //panel
        JPanel paneltop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paneltop.setBackground(new Color(53, 101, 77));
        paneltop.setPreferredSize(new Dimension(100, 50));

        // initialise
        this.setTitle("Stress-Guide");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setSize(700, 800);
        this.setResizable(false);// prevent user from freely resize the window
        this.setLocationRelativeTo(null);//keep frame in the middle of screen when generates
        this.setLayout(new BorderLayout());
        
        // application-icon
        ImageIcon logo = new ImageIcon("src/resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        //content pane
        paneltop.add(backBtn);
        this.add(paneltop,BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.CENTER);
        
        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click){
        if(click.getSource()==backBtn){
            System.out.println("Clicked on back");
            //direct to Main menu page
            sound.stop();
            sound.playSound(1);
            new Menu();
            this.dispose();
        }
    }
    
}
