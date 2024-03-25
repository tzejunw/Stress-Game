import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Guide extends JFrame implements ActionListener{
    JButton backBtn;
    Guide() { 
        
        //play bgm
        sound.playSoundLoop(3); // same bgm as menu        
        
        //back
        ImageIcon btnImage=new ImageIcon("resource/backBTN.png");
        backBtn=new JButton(btnImage);
        backBtn.addActionListener(this);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusable(false);
        backBtn.setBorderPainted(false);

        // Load the image
        ImageIcon imageIcon = new ImageIcon("resource/guide.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(700, 750, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        // Create JLabel to display the image
        imageLabel = new JLabel(imageIcon);

        //panel
        JPanel paneltop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paneltop.setBackground(new Color(36, 51, 56));
        paneltop.setPreferredSize(new Dimension(100, 50));
        // JPanel middlePanel = new JPanel();
        // JPanel paneltop=new JPanel(new FlowLayout(FlowLayout.LEFT));

        // paneltop.setBackground(new Color(36,51,56));
        //paneltop.setBackground(Color.red);
        // middlePanel.setBackground(new Color(36,51,56));

        // paneltop.setPreferredSize(new Dimension(100, 50));
        // middlePanel.setPreferredSize(new Dimension(100, 100));



        // initialise
        this.setTitle("Stress-Guide");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setSize(700, 800);
        this.setResizable(false);// prevent user from freely resize the window
        this.setLocationRelativeTo(null);//keep frame in the middle of screen when generates
        this.setLayout(new BorderLayout());
        
        

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        //content pane
        paneltop.add(backBtn);
        this.add(paneltop,BorderLayout.NORTH);
        this.add(imageLabel, BorderLayout.CENTER);
        // this.add(middlePanel,BorderLayout.CENTER);
        

        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click){
        if(click.getSource()==backBtn){
            System.out.println("Clicked on back");
            //direct to Main menu page
            sound.stop();
            new menu();
            this.dispose();
        }
    }
    
}
