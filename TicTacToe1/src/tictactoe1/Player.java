package tictactoe1;

public class Player
{

    private String playerName = "";
    private int playerTotal = 0;//board total while playing
    private char playerMarker;//x or o used by player
    private int playerScore = 0;//overal wins by player
    private int total = 0;

    public Player(String name)
    {
        //send name at construction
        playerName = name;
    }

    public int getPlayerTotal()
    {
        return playerTotal;
    }

    public void addPlayerTotal(int total)
    {
        playerTotal = playerTotal + total;
    }

    public void setPlayerTotal(int playerTotal)
    {
        this.playerTotal = playerTotal;
    }

    public char getPlayerMarker()
    {
        return playerMarker;
    }

    public void setPlayerMarker(char playerMarker)
    {
        this.playerMarker = playerMarker;
    }

    public int getPlayerScore()
    {
        return playerScore;
    }

    public void setPlayerScore(int playerScore)
    {
        this.playerScore = playerScore;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }
    public void addplayerTotal(int x)
    {
        playerTotal = playerTotal + x;
    }
    public void addPlayerScore()
    {
        playerScore = playerScore + 1;
    }
}//player