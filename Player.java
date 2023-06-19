public class Player {
    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private int gameLost;
    private int gamesTied;
    private boolean isTurn;
    private char sign;

    public Player() {
    }

    public Player(String name, char sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGameLost() {
        return gameLost;
    }

    public void setGameLost(int gameLost) {
        this.gameLost = gameLost;
    }

    public int getGamesTied() {
        return gamesTied;
    }

    public void setGamesTied(int gamesTied) {
        this.gamesTied = gamesTied;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }
}
