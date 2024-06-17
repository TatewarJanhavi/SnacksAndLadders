package phonepe.model;

public interface BoardElement {

     int getStartValue();
    String getBoardElementType();

    int applyEffect(int currentPosition);


}
