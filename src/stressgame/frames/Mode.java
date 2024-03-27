package stressgame.frames;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import stressgame.sound.*;

public class Mode extends JFrame implements ActionListener {
    JButton aiBtn,pvpBtn,backBtn;
    Sound sound = new Sound();

    public Mode() {
        ImageIcon btnImageBack=new ImageIcon("images/backBTN.png");
        backBtn=new JButton(btnImageBack);
        backBtn.addActionListener(this);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusable(false);
        backBtn.setBorderPainted(false);

        //panel
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel modePanel = new JPanel();

        topPanel.setBackground(new Color(36,51,56));
        middlePanel.setBackground(new Color(36,51,56));
        bottomPanel.setBackground(new Color(36,51,56));
        modePanel.setBackground(new Color(36,51,56));

        topPanel.setPreferredSize(new Dimension(100, 300));
        middlePanel.setPreferredSize(new Dimension(100, 100));
        bottomPanel.setPreferredSize(new Dimension(100, 30));
        modePanel.setPreferredSize(new Dimension(600, 250));

        ImageIcon titlePic=new ImageIcon("images/bg3.png");
        JLabel title = new JLabel(titlePic);

        //button 1
        ImageIcon btnImage=new ImageIcon("images/aiBtn.png");
        aiBtn=new JButton(btnImage);
        aiBtn.addActionListener(this);
        aiBtn.setContentAreaFilled(false);
        aiBtn.setFocusable(false);
        aiBtn.setBorderPainted(false);

        //button 2
        ImageIcon btnImage2=new ImageIcon("images/pvpBtn.png");
        pvpBtn=new JButton(btnImage2);
        pvpBtn.addActionListener(this);
        pvpBtn.setContentAreaFilled(false);
        pvpBtn.setFocusable(false);
        pvpBtn.setBorderPainted(false);

        this.setTitle("Stress");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setLayout(new BorderLayout());
        this.setSize(700, 800);
        this.setResizable(false);// prevent user from freely resize the window
        this.setLocationRelativeTo(null);// keep frame in the middle of screen when generates
        // this.setBackground(backgrouImage);

        // application-icon
        ImageIcon logo = new ImageIcon("images/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        // content pane
        this.getContentPane().setBackground(new Color(255, 255, 255));// change color of backgrond

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        modePanel.setLayout(new GridLayout(1, 2, 30, 30));

        middlePanel.add(modePanel, BorderLayout.SOUTH);

        modePanel.add(aiBtn);
        modePanel.add(pvpBtn);
        topPanel.add(backBtn);
        topPanel.add(title);

        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if (click.getSource() == aiBtn) {
            System.out.println("clicked ai Btn");
            sound.stop();
            sound.playSound(1);
            new DifficultySetting();
            this.dispose();
        }else if (click.getSource() == pvpBtn) {
            System.out.println("clicked pvp Btn");
            sound.stop();
            sound.playSound(1);
            new StressPVP();
            this.dispose();
        } else if(click.getSource()==backBtn){
            System.out.println("Clicked on back");
            //direct to Main menu page
            sound.stop();
            sound.playSound(1);
            new Menu();
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Mode();
    }

}
