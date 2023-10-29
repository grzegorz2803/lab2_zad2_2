
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket {
    private Lock lock = new ReentrantLock();
    private String name;
    private boolean reserved;

    public Ticket(String name) {
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

    public void reserve() throws InterruptedException {

        if (reserved) {
            System.out.println("Wątek " + Thread.currentThread().getName() + " czeka na zwolnienie  " + name);
        } else {
            lock.lock();
            try {
                reserved = true;
                System.out.println("Wątek " + Thread.currentThread().getName() + " zarezerwował " + name);
            } finally {
                if (((ReentrantLock) lock).isHeldByCurrentThread()) {
                    lock.unlock();
                }


            }
        }

    }
    public void returnTicket() throws InterruptedException {
        reserved = false;
        System.out.println("Wątek " + Thread.currentThread().getName() + " zwolnił  " + name);
    }

}
