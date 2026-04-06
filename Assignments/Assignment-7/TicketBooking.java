import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TicketBooking {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 250; i++) {
            final int userId = i;
            executor.submit(() -> {
                system.bookTicket(userId);
                if (userId <= 15) {
                    system.cancelTicket(userId);
                }
            });
        }

        executor.shutdown();
        
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
        }

        System.out.println("Final available tickets: " + system.getAvailableTickets());
    }
}