package recaparraylist;

public class Seat implements Comparable<Seat>{

    private String seatNumber;
    private double price;
    private boolean reserved;

    public Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public boolean reserve() {
        if(!this.reserved) {
            this.reserved = true;
            System.out.println("recaparraylist.Seat " + seatNumber + " reserved");
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel() {
        if(this.reserved) {
            this.reserved = false;
            System.out.println("Reservation of seat " + seatNumber + " cancelled");
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(Seat seat) {
        return  this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
    }

    public double getPrice() {
        return price;
    }
}
