package recaparraylist;

import java.util.*;

public class Theatre {

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        public int compare(Seat seat1, Seat seat2) {
            if (seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else
             return 0;
        }
    };

    private String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    public String getTheatreName() {
        return theatreName;
    }

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNumber = 1; seatNumber <= seatsPerRow; seatNumber++) {
                double price = 12.00;
                if ((row < 'D') && (seatNumber >= 4) && (seatNumber <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNumber < 4) || (seatNumber > 9)) {
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNumber), price );
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There's no seat "+ seatNumber);
            return false;
        }
    }

    // for testing
    public Collection<Seat> getSeats() {
        return seats;
    }

    public void addNewSeat(Seat seat) {
        seats.add(seat);
    }
}
