import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketPool {
    private static final int MAX_TICKETS = 4;
    private Lock lock = new ReentrantLock();
    ArrayList<Ticket> tickets = new ArrayList<>();
  public TicketPool(){
      for(int i=0;i<MAX_TICKETS;i++){
          tickets.add(new Ticket("Bilet ",i));
      }
  }
  public int reserve(){
      lock.lock();
      try {
          for (Ticket ticket : tickets
               ) {
              if(!ticket.isReserved()){
                  ticket.setReserved(true);
                  return ticket.getNumber();
              }else {
                  System.out.println("Wątek "+Thread.currentThread().getName()+" czeka na zwolnienie biletu nr "+ticket.getNumber());
              }
          }

      }finally {
          lock.unlock();
      }
  return -1;
  }
  public void release(int ticketNumber){
      lock.lock();
      try{
          tickets.get(ticketNumber).setReserved(false);
      }finally {
          lock.unlock();
      }
  }

}
