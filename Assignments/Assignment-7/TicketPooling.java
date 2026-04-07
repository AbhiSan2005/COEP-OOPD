import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketPooling {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        TicketSystem system = new TicketSystem();
        for (int i = 0; i < 250; i++) {
            final int userId = i + 1;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    system.bookTicket(userId);
                    if (userId <= 15) {
                        system.cancelTicket(userId);
                    }
                }
            });
        }
        executorService.shutdown();

        System.out.println("Final available tickets: " + system.getAvailableTickets());
    }
    
}
