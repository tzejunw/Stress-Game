import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FlowLayout;

public class Guide extends JFrame implements ActionListener{
    JButton backBtn;
    Guide() { 
        
        //back
        backBtn=new JButton("Back");
        backBtn.addActionListener(this);
        JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(backBtn);

        // initialise
        this.setTitle("Stress-Guide");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cross will exit out of application
        this.setSize(600, 700);
        this.setResizable(false);// prevent user from freely resize the window
        
        

        // application-icon
        ImageIcon logo = new ImageIcon("resource/temp_logo.jpg");// logo of application
        this.setIconImage(logo.getImage());// change icon of frame;

        //content pane
        this.add(panel,BorderLayout.NORTH);
        

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
        }
    }
    
}

