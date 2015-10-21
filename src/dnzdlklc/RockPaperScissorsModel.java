package dnzdlklc;

/**
 * Created by dnzdlklc on 21/10/15.
 */
public class RockPaperScissorsModel {

    private int wins = 0;
    private int losses = 0;
    private int ties = 0;

    public enum GameOutcome{
        WIN, LOSE, TIE
    }

    public GameOutcome getGameOutcome(String userChoice, String computerChoice){

        if(userChoice.equalsIgnoreCase("ROCK")){

            if(computerChoice.equalsIgnoreCase("PAPER")){
                //rock is covered by paper
                losses++;
                return GameOutcome.LOSE;
            }
            else if(computerChoice.equalsIgnoreCase("SCISSORS")){
                //rock smashes scissors
                wins++;
                return GameOutcome.WIN;
            }
        }
        else if(userChoice.equalsIgnoreCase("PAPER")){

            if(computerChoice.equalsIgnoreCase("SCISSORS")){
                //paper is cut by scissors
                losses++;
                return GameOutcome.LOSE;
            }
            else if(computerChoice.equalsIgnoreCase("ROCK")){
                //paper covers rock
                wins++;
                return GameOutcome.WIN;
            }
        }
        else if(userChoice.equalsIgnoreCase("SCISSORS")){

            if(computerChoice.equalsIgnoreCase("ROCK")){
                //scissors are smashed by rock
                losses++;
                return GameOutcome.LOSE;
            }
            else if(computerChoice.equalsIgnoreCase("PAPER")){
                //scissors cut paper
                wins++;
                return GameOutcome.WIN;
            }
        }

        //if none of the above if statements is the case, then the choices must be the same
        ties++;
        return GameOutcome.TIE;
    }

    public String getRandomChoice(){
        double d = Math.random();

        if(d < .33){
            return "ROCK";
        }
        else if(d < .66){
            return "PAPER";
        }
        else{
            return "SCISSORS";
        }
    }

    public int getWins(){
        return wins;
    }

    public int getLosses(){
        return losses;
    }

    public int getTies(){
        return ties;
    }
}