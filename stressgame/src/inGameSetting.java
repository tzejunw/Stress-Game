import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class inGameSetting extends JFrame implements ActionListener {
    JButton backBtn, guideBtn, mainMenuBtn;

    inGameSetting() {
        // back
        ImageIcon btnImage = new ImageIcon("resource/backBTN.png");
        backBtn = new JButton(btnImage);
        backBtn.addActionListener(this);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusable(false);
        backBtn.setBorderPainted(false);

        // label
        JLabel text_Pause = new JLabel();
        text_Pause.setText("Game Pause");
        text_Pause.setFont(new Font("Serif Bold", Font.PLAIN, 30));
        text_Pause.setForeground(new Color(137, 219, 220));

        // panel
        JPanel middlePanel = new JPanel();
        JPanel paneltop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel optionPanel = new JPanel();

        paneltop.setBackground(new Color(36, 51, 56));
        // paneltop.setBackground(Color.red);
        middlePanel.setBackground(new Color(36, 51, 56));
        optionPanel.setBackground(new Color(36, 51, 56));

        paneltop.setPreferredSize(new Dimension(100, 50));
        middlePanel.setPreferredSize(new Dimension(100, 100));
        optionPanel.setPreferredSize(new Dimension(250, 250));
        optionPanel.setLayout(new GridLayout(3, 1, 0, 10));

        // button
        guideBtn = new JButton("Guide");
        guideBtn.setFont(new Font("Serif Bold", Font.PLAIN, 15));
        guideBtn.setBorderPainted(false);
        guideBtn.setBackground(new Color(137, 219, 220));
        guideBtn.setForeground(new Color(135, 69, 72));
        guideBtn.setFocusable(false);
        guideBtn.addActionListener(this);

        mainMenuBtn = new JButton("Quit Game");
        mainMenuBtn.setFont(new Font("Serif Bold", Font.PLAIN, 15));
        mainMenuBtn.setBorderPainted(false);
        mainMenuBtn.setBackground(new Color(137, 219, 220));
        mainMenuBtn.setForeground(new Color(135, 69, 72));
        mainMenuBtn.setFocusable(false);
        mainMenuBtn.addActionListener(this);

        // initialise
        this.setTitle("Stress-Guide");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setSize(500, 400);
        this.setResizable(false);// prevent user from freely resize the window
        this.setLocationRelativeTo(null);// keep frame in the middle of screen when generates
        this.setLayout(new BorderLayout());
        this.setAlwaysOnTop(true);

        this.setUndecorated(true); // remove title bar

        // content pane
        paneltop.add(backBtn);
        this.add(paneltop, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        middlePanel.add(optionPanel, BorderLayout.SOUTH);

        optionPanel.add(text_Pause);
        optionPanel.add(guideBtn);
        optionPanel.add(mainMenuBtn);

        // make frame visible
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if (click.getSource() == backBtn) {
            this.dispose();
            System.out.println("Clicked on back,game resume");
        } /*else if (click.getSource() == mainMenuBtn) {
            new menu();
            System.out.println("Clicked on quit game,return back to main menu");
            Window win = SwingUtilities.getWindowAncestor((Component) click.getSource());
            win.dispose();
        } else if (click.getSource() == guideBtn) {
            new Guide();
            System.out.println("Clicked on guide in game");
            this.dispose();
        }*/
    }
}
