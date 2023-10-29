import java.util.Random;

public class TicketThread extends Thread {
    private TicketPool ticketPool;

    public TicketThread(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            int ticketNumber = ticketPool.reserve();
            if(ticketNumber!=-1){
                System.out.println("Wątek "+getName()+" zarezerwował bilet nr "+ticketNumber);
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    System.out.println("Wątek "+getName()+" został przerwany");
                    interrupt();
                    break;
                }
                System.out.println("Wątek "+getName()+" zwolnił bilet nr" +ticketNumber);
                ticketPool.release(ticketNumber);
            }
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println("Wątek "+getName()+" został przerwany");
                interrupt();
                break;
            }
        }

    }
}

