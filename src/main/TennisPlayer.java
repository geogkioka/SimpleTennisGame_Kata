package main;

public class TennisPlayer {
    String name;
    int score;

    //Constructor
    public TennisPlayer(String name){
        this.name = name;
    }

    //Getters and setters **not used**
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void winsBall() {
        score = score + 1;
    }

    public String getScoreDescription(){
        int score = getScore();
        switch (score) {
            case 0:
                return "love";
            case 1:
                return "fifteen";
            case 2:
                return "thirty";
            case 3:
                return "forty";
            }
        throw new IllegalArgumentException("Illegical score: " + score);
    }
}