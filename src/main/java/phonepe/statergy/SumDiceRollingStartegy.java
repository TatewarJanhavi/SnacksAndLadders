package phonepe.statergy;

public class SumDiceRollingStartegy  implements  DiceRollingStrategy {
    @Override
    public int getStepsTobeMoved(int[] diceValues) {
        int sum = 0;
        for (int value : diceValues) {
            sum += value;
        }
        return sum;
    }
}
