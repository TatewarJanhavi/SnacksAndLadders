package phonepe.model;

public class Ladder implements BoardElement {
    private int start;
    private  int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String getBoardElementType() {
        return "LADDER" ;
    }

    @Override
    public int applyEffect(int currentPosition) {
        if (currentPosition == start) {
            return end;
        }
        return currentPosition;
    }
}
