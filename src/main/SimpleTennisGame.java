package main;
public class SimpleTennisGame{

    private TennisPlayer tennisPlayer1;
    private TennisPlayer tennisPlayer2;

    public SimpleTennisGame(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
    }

    public String getScore() {
        //According to the rules of the game (by Wikipedia)

        //if one player scored at least two points more than the opponent and have at least 4 points
        if ((Math.abs(tennisPlayer1.getScore() - tennisPlayer2.getScore()) >= 2) && (tennisPlayer1.getScore() >= 4 || tennisPlayer1.getScore() >= 4)) {
            //then he/she wins the game
            return getLeadPlayer().getName() + " wins the game!";
        }
        // if both players at least 3 points
        else if (tennisPlayer1.getScore() >= 3 && tennisPlayer2.getScore() >= 3) {
            // if at least three points have been scored by each player[above] and the scores are equal, the score is “deuce”.
            if (tennisPlayer1.getScore() == tennisPlayer2.getScore()) {
                return "deuce";
            } // If at least three points have been scored by each side and a player has one more point than his opponent, the score is "advantage".
            else if (Math.abs(tennisPlayer1.getScore() - tennisPlayer2.getScore()) == 1) {
                return "advantage " + getLeadPlayer().getName();
            }
        } else
            return tennisPlayer1.getScoreDescription() + ", " + tennisPlayer2.getScoreDescription();

        return null;
    }

    public TennisPlayer getLeadPlayer() {
        return (tennisPlayer1.getScore() > tennisPlayer2.getScore()) ? tennisPlayer1 : tennisPlayer2;
    }
}