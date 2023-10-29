
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Ticket[] tickets = new Ticket[3];
        Object monitor = new Object();
        ArrayList<TicketThread> tcTh = new ArrayList<>();
        tickets[0] = new Ticket("Bilet 1");
        tickets[1] = new Ticket("Bilet 2");
        tickets[2] = new Ticket("Bilet 3");



       for (int i=0; i<10; i++) {
           Thread thread = new Thread(() -> {
              synchronized (monitor){
                  
              }
           });
            TicketThread tc = new TicketThread(tickets);
            tcTh.add(tc);
            tc.start();
            Thread.sleep(300);
       }
    Thread.sleep(5000);
        tcTh.forEach(tc->tc.interrupt());



    }
}