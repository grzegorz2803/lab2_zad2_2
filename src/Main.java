
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TicketPool ticketPool = new TicketPool();
        ArrayList<TicketThread> tcTh = new ArrayList<>();
        for(int i=0; i<10; i++){
            TicketThread tc = new TicketThread(ticketPool);
            tcTh.add(tc);
            tc.start();
            Thread.sleep(1000);
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
    String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("k")) {
                tcTh.forEach(Thread::interrupt);
                break;
            }else {
                try{
                    int threadToInterrupt = Integer.parseInt(userInput);
                    tcTh.get(threadToInterrupt).interrupt();
                }catch (NumberFormatException e){
                    System.out.println("Błędne dane");
                }
            }
        }
        sc.close();
    }
}