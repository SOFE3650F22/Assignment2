public class Ticket {
    
    public String ticketRecord(String currentItem, String currentPrice, String currentBill) {
        String ticket = currentBill + "\n" + currentItem + ": " + currentPrice;
        return ticket;
    }

    public void printTicket(String currentBill, String total) {
        System.out.println(currentBill);
        System.out.println(total);
    }
}
