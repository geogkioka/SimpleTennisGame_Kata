package test;

import main.TennisPlayer;
import main.SimpleTennisGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SimpleTennisGameTest {
    TennisPlayer alice;
    TennisPlayer bob;
    SimpleTennisGame game;

    //set args before tests
    @Before
    public void beforeSimpleTennisGameTest() {
        alice = new TennisPlayer("Alice");
        bob = new TennisPlayer("Bob");
        game = new SimpleTennisGame(alice, bob);
    }

    //check that when a game is initiated the score is "love" for both players
    @Test
    public void newGameReturnsLoveForBoth() {
        //SimpleTennisGame game = new SimpleTennisGame(alice, bob);
        String score = game.getScore();
        assertEquals(("love, love"), score);
    }

    //check that score 1 is translated to fifteen
    @Test
    public void aliceWinsBallReturnsFifteenLove() {
        alice.winsBall();
        String score = game.getScore();
        assertEquals(("fifteen, love"), score);
    }

    //check that score 2 is translated to thirty
    @Test
    public void aliceWinsBallTwiceReturnsThirtyLove() {
        for (int i = 0; i < 2; i++)
            alice.winsBall();
        String score = game.getScore();
        assertEquals(("thirty, love"), score);
    }

    //check that score 3 is translated to forty
    @Test
    public void aliceWinsBall3TimesReturnsFortyLove() {
        for (int i = 0; i < 3; i++)
            alice.winsBall();
        bob.winsBall();
        String score = game.getScore();
        assertEquals(("forty, fifteen"), score);
    }

    //check that the function getLeadPlayer returns correct result
    @Test
    public void aliceWinsMoreBallsThanBob() {
        for (int i = 0; i < 2; i++)
            alice.winsBall();
        bob.winsBall();
        //assertEquals("Alice", game.getLeadPlayer().getName());
        Assert.assertEquals(alice, game.getLeadPlayer());
        for (int i = 0; i < 2; i++)
            bob.winsBall();
        Assert.assertEquals("Bob", game.getLeadPlayer().getName());

    }

    //check conditions regarding deuce
    //both players more than 3 points and exactly the same score
    @Test
    public void WhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqualScoreIsDeuce() {
        for (int i = 1; i <= 3; i++)
            alice.winsBall();
        for (int i = 1; i <= 3; i++)
            bob.winsBall();
        Assert.assertEquals("deuce", game.getScore());
        alice.winsBall();
        Assert.assertNotEquals("deuce", game.getScore());
        bob.winsBall();
        Assert.assertEquals("deuce", game.getScore());
    }

    //check winning conditions
    @Test
    public void aliceWinsGame() {
        for (int i = 0; i <= 4; i++)
            alice.winsBall();
        bob.winsBall();
        String score = game.getScore();
        assertEquals(("Alice wins the game!"), score);
        assertEquals("fifteen", bob.getScoreDescription());

    }

    //check that when one of two players have more than 4 points, but less than 2 points difference from opponent, they have advantage
    // if less than 2 points difference, they win the game!
    @Test
    public void aliceCloseToWinningGame() {
        for (int i = 0; i <= 4; i++)
            alice.winsBall();
        for (int i = 0; i <= 3; i++)
            bob.winsBall();
        String score = game.getScore();
        // assertEquals("forty",bob.getScoreDescription());
        assertNotEquals("Alice wins the game!", score);
        assertEquals("advantage Alice", score);
        alice.winsBall();
        Assert.assertEquals("Alice wins the game!", game.getScore());
    }

}