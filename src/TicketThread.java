
public class TicketThread extends Thread {
    Ticket[] tickets;

    public TicketThread(Ticket[] tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {

        while (true) {
            for (Ticket ticket : tickets) {

                try {
                    ticket.reserve();
                    ticket.returnTicket();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Wątek " + Thread.currentThread().getName() + " został przerwany");
                    return;
                }

            }

        }
    }
}

