package phonepe.model;

import exceptions.InvalidBoardException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    /**
     * the key is the starting position (head for snake, start for ladder) and the value is the corresponding BoardElement object (Snake or Ladder). This allows for fast lookup based on the position.
     */
    private final Map<Integer, BoardElement> boardElementsMap;

    public Board( List<BoardElement> boardElements) {
        boardElementsMap = new HashMap<>();
        createBoardElementMap(boardElements);
    }

    private void createBoardElementMap(List<BoardElement> boardElements) {
        for(BoardElement boardElement : boardElements){
            boardElementsMap.put(boardElement.getStartValue() , boardElement);
        }


    }

    public BoardElement getElementAtPosition(int position) {
        if (boardElementsMap.containsKey(position)) {
            return boardElementsMap.get(position);
        }
        return null;
    }

    public int movePlayer(Player player, int steps) {
        int currentPlayerPosition = player.getPosition();
        int newPosition = currentPlayerPosition + steps;
        BoardElement element = getElementAtPosition(newPosition);

        if (element != null) {
            int tobePosition = newPosition;
            newPosition = element.applyEffect(newPosition);
            if (element.getBoardElementType().equals("LADDER")) {
                System.out.print(",climbed the ladder at " + tobePosition + " ");
            } else if (element.getBoardElementType().equals("SNAKE")) {
                System.out.print(", bitten by snake at " + tobePosition + " ");
            } else if (element.getBoardElementType().equals("CROCODILE")) {
                System.out.print(", bitten by crocodile at " + tobePosition + " ");
            } else if (element.getBoardElementType().equals("MINE")) {
                System.out.println("move to MINE , need to skip two turns ");
                return Integer.MIN_VALUE;
            }
        }
        return newPosition;
    }


}
