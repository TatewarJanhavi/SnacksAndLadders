import phonepe.Config;
import phonepe.SnakesAndLadders;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Config config = loadConfig("/Users/janhavi.tatewar/SnakeAndLadder/src/main/resource/input.yaml");
        System.out.println("Press 1 for Auto Generate Board Congifration else any number for load Configration from file");
        int val = scanner.nextInt();
        SnakesAndLadders game;
        if (val == 1) {
            System.out.println("Enter Board Size");
            int size = scanner.nextInt();
            System.out.println("Enter no of Snakes");
            int noOfSnakes = scanner.nextInt();
            System.out.println("Enter no of Ladder");
            int noOfLadder = scanner.nextInt();
            System.out.println("Enter no of Crocodile");
            int noOfCrocodile = scanner.nextInt();
            System.out.println("Enter no of Mine");
            int noOfMine = scanner.nextInt();
            game = new SnakesAndLadders(config, size, noOfSnakes, noOfLadder, noOfCrocodile, noOfMine);
        } else {
            game = new SnakesAndLadders(config);

        }
        game.runGame();
    }


    private static Config loadConfig(String filePath) {
        Config config = new Config();
        try {
            Scanner scanner = new Scanner(new File(filePath));

            // Read snakes
            config.setNumSnakes(scanner.nextInt());

            for (int i = 0; i < config.getNumSnakes(); i++) {
                config.addSnake(scanner.nextInt(), scanner.nextInt());
            }

            // Read ladders
            config.setNumLadders(scanner.nextInt());
            for (int i = 0; i < config.getNumLadders(); i++) {
                config.addLadder(scanner.nextInt(), scanner.nextInt());
            }

            config.setNumsOfCrocodile(scanner.nextInt());
            for (int i = 0; i < config.getNumsOfCrocodile(); i++) {
                config.addCrocodile(scanner.nextInt());
            }

            config.setNumsOfMines(scanner.nextInt());
            for (int i = 0; i < config.getNumsOfMines(); i++) {
                config.addMine(scanner.nextInt());
            }

            // Read players
            config.setNumPlayers(scanner.nextInt());
            for (int i = 0; i < config.getNumPlayers(); i++) {
                String name = scanner.next();
                int position = scanner.nextInt();
                config.addPlayer(name, position);
            }
            config.setBoardSize(scanner.nextInt());
            config.setNumOfDice(scanner.nextInt());
            config.setMovementStrategy(scanner.next());
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Configuration file not found!");
        }
        return config;
    }
}