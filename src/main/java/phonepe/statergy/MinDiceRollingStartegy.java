package phonepe.statergy;

public class MinDiceRollingStartegy implements  DiceRollingStrategy{
    @Override
    public int getStepsTobeMoved(int[] diceValues) {
        int min = diceValues[0];
        for (int value : diceValues) {
            min = Math.min(min , value);
        }
        return min ;
    }
}
