import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class AiLogicEngine {
    private Timer timer;

    AiLogicEngine(int speedInMiliSeconds, Stress stressObject, JPanel gamePanel) {
        timer = new Timer(speedInMiliSeconds, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    stressObject.aiStackCardAttempt();
                    stressObject.aiPlayGameTurn(); // Option 1 (using object reference)
                    gamePanel.repaint();
                    System.out.println("AI Action Performed");
                    // OR
                    // Stress.aiPlayGameTurn(); // Option 2 (if static method)

            }
        });
        timer.start();
    }
    public void stop() {
        timer.stop();
    }

}
