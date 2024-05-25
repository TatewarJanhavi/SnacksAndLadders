package phonepe.model;

public class Crocodile implements BoardElement {

    private int startValue;

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }


    public Crocodile(int startValue) {
        this.startValue = startValue;
    }

    @Override
    public String getBoardElementType() {
        return "CROCODILE";
    }

    @Override
    public int applyEffect(int currentPosition) {
        return currentPosition - 5;
    }
}
