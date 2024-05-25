package phonepe;

import phonepe.model.Crocodile;
import phonepe.model.Mine;
import phonepe.model.Snake;
import phonepe.model.Ladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Config {
    private int numSnakes;
    private int numOfDice  ;
    private int numsOfCrocodile ;
    private int numsOfMines ;

    private final List<Snake> snakes;

    private final List<Crocodile> crocodiles;
    private final List<Mine> mines;

    public Config() {
        this.mines =  new ArrayList<>();
        this.crocodiles = new ArrayList<>();
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.players = new HashMap<>();
    }


    private int boardSize ;

    public int getNumsOfCrocodile() {
        return numsOfCrocodile;
    }

    public void setNumsOfCrocodile(int numsOfCrocodile) {
        this.numsOfCrocodile = numsOfCrocodile;
    }

    public int getNumsOfMines() {
        return numsOfMines;
    }

    public void setNumsOfMines(int numsOfMines) {
        this.numsOfMines = numsOfMines;
    }

    public List<Crocodile> getCrocodiles() {
        return crocodiles;
    }

    public List<Mine> getMines() {
        return mines;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public String getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(String movementStrategy) {
        this.movementStrategy = movementStrategy;
    }

    private String movementStrategy ;

    public int getNumOfDice() {
        return numOfDice;
    }

    public void setNumOfDice(int numOfDice) {
        this.numOfDice = numOfDice;
    }

    private int numLadders;
    private final List<Ladder> ladders;
    private int numPlayers;
    private final HashMap<String, Integer> players;


    public int getNumSnakes() {
        return numSnakes;
    }

    public void setNumSnakes(int numSnakes) {
        this.numSnakes = numSnakes;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void addSnake(int head, int tail) {
        snakes.add(new Snake(head, tail));
    }

    public int getNumLadders() {
        return numLadders;
    }

    public void setNumLadders(int numLadders) {
        this.numLadders = numLadders;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void addLadder(int bottom, int top) {
        ladders.add(new Ladder(bottom, top));
    }
    public void addCrocodile(int startPosition) {
        crocodiles.add(new Crocodile(startPosition));
    }

    public void addMine(int startPosition) {
        mines.add(new Mine(startPosition));
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public HashMap<String, Integer> getPlayers() {
        return players;
    }

    public void addPlayer(String name, int position) {
        players.put(name, position);
    }


}
