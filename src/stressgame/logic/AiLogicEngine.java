package stressgame.logic;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import stressgame.frames.*;

public class AiLogicEngine {
    private Timer timer;

    public AiLogicEngine(int speedInMiliSeconds, Stress stressObject, JPanel gamePanel) {
        timer = new Timer(speedInMiliSeconds, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stressObject.aiStackCardAttempt();
                stressObject.aiPlayGameTurn();
                gamePanel.repaint();
                System.out.println("AI Action Performed");
            }
        });
        timer.start();
    }
    public void stop() {
        timer.stop();
    }

}
