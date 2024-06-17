package phonepe.model;

public class Snake implements BoardElement{
    private  int head;
    private  int tail;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;

    }

    @Override
    public int getStartValue() {
        return head;
    }

    @Override
    public String getBoardElementType() {
        return "SNAKE" ;
    }

    @Override
    public int applyEffect(int currentPosition) {
        if (currentPosition == head) {
            return tail;
        }
        return currentPosition;
    }
}
