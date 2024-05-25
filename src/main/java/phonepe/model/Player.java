package phonepe.model;

import java.util.UUID;

public class Player {

    private String playerName ;

    private int position ;

    public int getSkipTurn() {
        return skipTurn;
    }

    public void setSkipTurn(int skipTurn) {
        this.skipTurn = skipTurn;
    }

    private int skipTurn ;

    public Player( String playerName, int position) {

        this.playerName = playerName;
        this.position = position;
        this.skipTurn = 0 ;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPosition() {
        return position;
    }




}
