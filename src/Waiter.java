import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Thread{

    ArrayList<TicketThread> tcTh;

    public Waiter(ArrayList<TicketThread> tcTh) {
        this.tcTh = tcTh;
    }

    @Override
    public void  run(){


              tcTh.forEach(Thread::interrupt);


    }
}
