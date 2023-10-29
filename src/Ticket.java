
public class Ticket {

    private String name;
    private boolean reserved;
    private int number;

    public Ticket(String name, int number) {
        this.number = number;
        this.name = name;
        reserved = false;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getName() {
        return name;
    }

    public boolean isReserved() {
        return reserved;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
