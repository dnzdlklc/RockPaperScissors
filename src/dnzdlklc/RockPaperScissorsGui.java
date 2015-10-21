package dnzdlklc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by dnzdlklc on 21/10/15.
 */
public class RockPaperScissorsGui {

    public static void main(String[] args){

        JFrame frame = new JFrame("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel playerChoiceLabel = new JLabel("", JLabel.CENTER);
        JLabel computerChoiceLabel = new JLabel("", JLabel.CENTER);
        JLabel outcomeLabel = new JLabel("Rock, paper, scissors... shoot!", JLabel.CENTER);

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        JLabel winsLabel = new JLabel("Wins: 0", JLabel.CENTER);
        JLabel lossesLabel = new JLabel("Losses: 0", JLabel.CENTER);
        JLabel tiesLabel = new JLabel("Ties: 0", JLabel.CENTER);

        //create the listener and pass the GUI components into it
        ActionListener listener = new RockPaperScissorsListener(playerChoiceLabel, computerChoiceLabel, outcomeLabel, rockButton, paperButton, scissorsButton, winsLabel, lossesLabel, tiesLabel);

        //add the listener to the buttons
        rockButton.addActionListener(listener);
        paperButton.addActionListener(listener);
        scissorsButton.addActionListener(listener);

        //top panel
        JPanel singleGameOutcomePanel = new JPanel();
        singleGameOutcomePanel.setLayout(new BorderLayout());

        singleGameOutcomePanel.add(playerChoiceLabel, BorderLayout.WEST);
        singleGameOutcomePanel.add(computerChoiceLabel, BorderLayout.EAST);
        singleGameOutcomePanel.add(outcomeLabel, BorderLayout.SOUTH);

        //middle panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonPanel.add(Box.createGlue());
        buttonPanel.add(rockButton);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(paperButton);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(scissorsButton);
        buttonPanel.add(Box.createGlue());

        //bottom panel
        JPanel totalsPanel = new JPanel();
        totalsPanel.setLayout(new FlowLayout());

        totalsPanel.add(winsLabel);
        totalsPanel.add(lossesLabel);
        totalsPanel.add(tiesLabel);

        frame.setLayout(new BorderLayout());

        frame.add(singleGameOutcomePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(totalsPanel, BorderLayout.SOUTH);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}