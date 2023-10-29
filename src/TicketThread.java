

public class TicketThread extends Thread {
    private final TicketPool ticketPool;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[0m";

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
                    System.out.println(ANSI_RED+"Wątek "+getName()+" został przerwany"+ANSI_WHITE);
                    interrupt();
                    break;
                }
                System.out.println("Wątek "+getName()+" zwolnił bilet nr" +ticketNumber);
                ticketPool.release(ticketNumber);
            }
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){
                System.out.println(ANSI_RED+"Wątek "+getName()+" został przerwany"+ANSI_WHITE);
                interrupt();
                break;
            }
        }

    }
}

