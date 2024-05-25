package phonepe.model;

public class Mine implements BoardElement{
    int startValue ;

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }

    public Mine(int startValue) {
        this.startValue = startValue;
    }

    @Override
    public String getBoardElementType() {
        return "MINE";
    }

    @Override
    public int applyEffect(int currentPosition) {
        return Integer.MIN_VALUE;
    }
}
