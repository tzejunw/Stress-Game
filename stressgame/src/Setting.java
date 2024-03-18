import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;

public class Setting extends JFrame implements ActionListener {
    JButton backBtn;
    JComboBox<String> sizeComboBox;

    Setting() {
        // back
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(backBtn);

        // Combo box for window size options
        String[] sizes = { "Small", "Original", "Large" };
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.addActionListener(this);

        // initialise
        this.setTitle("Stress-Setting");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setSize(600, 700);
        this.setResizable(false);// prevent user from freely resize the window

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        // content pane
        this.add(panel, BorderLayout.NORTH);
        this.add(sizeComboBox);

        // make frame visible
        this.setVisible(true);

        
    }

    @Override
    public void actionPerformed(ActionEvent click){
        if(click.getSource()==backBtn){
            System.out.println("Clicked on back");
            //direct to Main menu page
            new menu();
            this.dispose();
        }else if(click.getSource()==sizeComboBox){
            String selectedSize = (String) sizeComboBox.getSelectedItem();
            switch (selectedSize) {
                case "Small":
                    this.setSize(400, 500);
                    System.out.println("Screen size change to 400*500");
                    break;
                case "Original":
                    this.setSize(600, 700);
                    System.out.println("Screen size change to 600*700");
                    break;
                case "Large":
                    this.setSize(800, 900);
                    System.out.println("Screen size change to 800*900");
                    break;
                default:
                    break;
            }
        }
    }

}
