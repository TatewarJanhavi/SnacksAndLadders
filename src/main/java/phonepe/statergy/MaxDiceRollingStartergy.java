package phonepe.statergy;

public class MaxDiceRollingStartergy implements  DiceRollingStrategy{

    @Override
    public int getStepsTobeMoved(int[] diceValues) {
        int max = diceValues[0];
        for (int value : diceValues) {
            max = Math.max(max, value);
        }
        return max;
    }
}
