package phonepe;

import phonepe.model.*;
import phonepe.statergy.DiceRollingStrategy;
import phonepe.statergy.MaxDiceRollingStartergy;
import phonepe.statergy.MinDiceRollingStartegy;
import phonepe.statergy.SumDiceRollingStartegy;

import java.util.*;

public class SnakesAndLadders {

    private static final int startPosition = 1;

    private final Config config;
    private final Board board;
    private final Deque<Player> players;


    private final List<Player> listOfPlayer;

    public SnakesAndLadders(Config config) {
        this.config = config;
        this.board = new Board(config.getSnakes(), config.getLadders(), config.getCrocodiles(), config.getMines());
        players = new LinkedList<>();
        listOfPlayer = new ArrayList<>();
        createPlayersForNewGame(config.getPlayers());

    }


    public SnakesAndLadders(Config config, int boardSize, int numOfSnakes, int noOfLadder, int noOfCrocodile, int noOfMine) {
        this.config = config;
        this.board = generateRandomBoard(boardSize, numOfSnakes, noOfLadder, noOfCrocodile, noOfMine);
        players = new LinkedList<>();
        listOfPlayer = new ArrayList<>();
        createPlayersForNewGame(config.getPlayers());
    }

    private void createPlayersForNewGame(HashMap<String, Integer> playersDetailsMap) {
        for (Map.Entry<String, Integer> entry : playersDetailsMap.entrySet()) {
            String playerName = entry.getKey();
            Integer playerCurrentPosition = entry.getValue();
            Player player = new Player(playerName, playerCurrentPosition);
            System.out.println(player.getPlayerName());
            players.add(player);
            listOfPlayer.add(player);
        }
    }

    public void runGame() {
        System.out.println("Lets start the game ");
        while (true) {
            Player player = players.removeFirst();
            int newPosition = 0;
            int currentPositon = player.getPosition();
            if (player.getSkipTurn() > 0) {
                int value = player.getSkipTurn();
                player.setSkipTurn(--value);
                players.addLast(player);
                continue;
            }
            DiceRollingStrategy diceRollingStrategy = getMovementStartegy();
            // do {
            int[] diceValues = rollDice(config.getNumOfDice());
            printDiceValue(diceValues);
            int steps = diceRollingStrategy.getStepsTobeMoved(diceValues);

            System.out.print(player.getPlayerName() + " rolled a with steps " + steps + " ");
            newPosition = board.movePlayer(player, steps);
            if (newPosition == Integer.MIN_VALUE) {
                player.setSkipTurn(1);
            }
            if (newPosition > config.getBoardSize() * config.getBoardSize()) {
                System.out.println("New Position is greater than board size ");
            }
//                 }while(newPosition > config.getBoardSize() * config.getBoardSize());
            if (newPosition != Integer.MIN_VALUE && newPosition <= config.getBoardSize() * config.getBoardSize()) {
                System.out.println("and  moved from " + currentPositon + " to " + newPosition);
                checkAnotherPlayerAtSamePosition(newPosition, player);
                player.setPosition(newPosition);
                if (newPosition == config.getBoardSize() * config.getBoardSize()) {
                    System.out.println("Player " + player.getPlayerName() + " wins the game");
                    return;
                }
            }
            players.addLast(player);

        }
    }

    private void printDiceValue(int[] diceValue) {
        System.out.print("Dice value are ");
        for (int val : diceValue) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    private void checkAnotherPlayerAtSamePosition(int newPosition, Player currentPlayer) {
        for (Player player : listOfPlayer) {
            if (player.getPosition() == newPosition && !player.getPlayerName().equals(currentPlayer.getPlayerName())) {
                System.out.println("Conflict in position therfore reseting the " + player.getPlayerName() + " position");
                player.setPosition(startPosition);
            }
        }
    }

    private int[] rollDice(int numDice) {
        int[] diceValues = new int[numDice];
        for (int i = 0; i < numDice; i++) {
            diceValues[i] = new Random().nextInt(6) + 1;
        }
        return diceValues;
    }


    private DiceRollingStrategy getMovementStartegy() {
        if (config.getMovementStrategy().equals("SUM")) {
            return new SumDiceRollingStartegy();
        } else if (config.getMovementStrategy().equals("MAX")) {
            return new MaxDiceRollingStartergy();
        } else if (config.getMovementStrategy().equals("MIN")) {
            return new MinDiceRollingStartegy();
        } else {
            throw new IllegalArgumentException("Invalid movement strategy: " + config.getMovementStrategy());
        }
    }


    private static Board generateRandomBoard(int boardSize, int numOfSnakes, int numOfLadders, int numOfCrocdile, int numOfMine) {
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        List<Crocodile> crocodiles = new ArrayList<>();
        List<Mine> mines = new ArrayList<>();
        Random random = new Random();
        Set<Integer> positionInUsed = new HashSet<>();

        // Place snakes
        for (int i = 0; i < numOfSnakes; i++) {
            int head;
            int tail;
            do {
                head = random.nextInt(boardSize * boardSize - 2) + 2;
                tail = random.nextInt(head - 1);
            } while (positionInUsed.contains(head) || positionInUsed.contains(tail));
            System.out.println("position of snakes " + head + " " + tail);
            snakes.add(new Snake(head, tail));
            positionInUsed.add(head);
            positionInUsed.add(tail);
        }

        // Place ladders (ensure they don't land on snakes)
        for (int i = 0; i < numOfLadders; i++) {
            int bottom;
            int top;
            do {
                bottom = random.nextInt(boardSize * boardSize - 1) + 1;
                top = random.nextInt(boardSize * boardSize - bottom) + bottom;
            } while (positionInUsed.contains(bottom) || positionInUsed.contains(top));
            System.out.println("position of ladder " + bottom + " " + top);
            ladders.add(new Ladder(bottom, top));
            positionInUsed.add(bottom);
            positionInUsed.add(top);
        }

        for (int i = 0; i < numOfCrocdile; i++) {
            int top;
            do {
                top = random.nextInt(boardSize * boardSize - 5) + 5;
            } while (positionInUsed.contains(top));
            System.out.println("position of crocodile " + top);
            crocodiles.add(new Crocodile(top));
            positionInUsed.add(top);
        }
        for (int i = 0; i < numOfMine; i++) {
            int top;
            do {
                top = random.nextInt(boardSize * boardSize - 1) + 1;
            } while (positionInUsed.contains(top));
            System.out.println("position of mine " + top);
            mines.add(new Mine(top));
            positionInUsed.add(top);
        }

        return new Board(snakes, ladders, crocodiles, mines);

    }


}
