
public class Ticket {

    private boolean reserved;
    private final int number;

    public Ticket(int number) {
        this.number = number;
        reserved = false;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }

    public int getNumber() {
        return number;
    }

}
