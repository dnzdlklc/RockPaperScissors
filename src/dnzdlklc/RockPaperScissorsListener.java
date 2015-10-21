package dnzdlklc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dnzdlklc on 21/10/15.
 */
public class RockPaperScissorsListener implements ActionListener {

    RockPaperScissorsModel model;

    JLabel playerChoiceLabel;
    JLabel computerChoiceLabel;
    JLabel outcomeLabel;

    JButton rockButton;
    JButton paperButton;
    JButton scissorsButton;

    JLabel winsLabel;
    JLabel lossesLabel;
    JLabel tiesLabel;

    public RockPaperScissorsListener(JLabel playerChoiceLabel, JLabel computerChoiceLabel, JLabel outcomeLabel,
                                     JButton rockButton, JButton paperButton, JButton scissorsButton,
                                     JLabel winsLabel, JLabel lossesLabel, JLabel tiesLabel){

        this.model = new RockPaperScissorsModel();

        this.playerChoiceLabel = playerChoiceLabel;
        this.computerChoiceLabel = computerChoiceLabel;
        this.outcomeLabel = outcomeLabel;
        this.rockButton = rockButton;
        this.paperButton = paperButton;
        this.scissorsButton = scissorsButton;
        this.winsLabel = winsLabel;
        this.lossesLabel = lossesLabel;
        this.tiesLabel = tiesLabel;

    }

    public void actionPerformed(ActionEvent e) {

        String playerChoice;

        if(e.getSource() == rockButton){
            playerChoice = "ROCK";
        }
        else if(e.getSource() == paperButton){
            playerChoice = "PAPER";
        }
        else if(e.getSource() == scissorsButton){
            playerChoice = "SCISSORS";
        }
        else{
            //something is wrong
            playerChoice = "ERROR";
        }

        //use the model to generate a random choice
        String computerChoice = model.getRandomChoice();

        //update the outcome labels
        playerChoiceLabel.setText("You chose " + playerChoice + ".");
        computerChoiceLabel.setText("CPU chose " + computerChoice + ".");

        //who won?
        RockPaperScissorsModel.GameOutcome outcome = model.getGameOutcome(playerChoice, computerChoice);

        if(outcome == RockPaperScissorsModel.GameOutcome.WIN){
            outcomeLabel.setText("You won the game!");
        }
        else if(outcome == RockPaperScissorsModel.GameOutcome.LOSE){
            outcomeLabel.setText("The computer won the game!");
        }
        else{
            outcomeLabel.setText("The game was a tie!");
        }

        //update the totals labels
        winsLabel.setText("Wins: " + model.getWins());
        lossesLabel.setText("Losses: " + model.getLosses());
        tiesLabel.setText("Ties: " + model.getTies());

    }

}