public class TicketSystem {
    private int availableTickets = 100;
    private boolean[] userHasTicket = new boolean[251]; 

    public synchronized void bookTicket(int userId) {
        if (availableTickets > 0 && !userHasTicket[userId]) {
            availableTickets--;
            userHasTicket[userId] = true;
            System.out.println("User " + userId + " BOOKED. Tickets left: " + availableTickets);
        }
    }

    public synchronized void cancelTicket(int userId) {
        if (userHasTicket[userId]) {
            userHasTicket[userId] = false;
            availableTickets++;
            System.out.println("User " + userId + " CANCELED. Tickets left: " + availableTickets);
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}