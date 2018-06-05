package recaparraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        List<Seat> reverseSeat = new ArrayList<Seat>(theatre.getSeats());
        Collections.sort(reverseSeat);
        printList(reverseSeat);

        List<Seat> pricesSeat = new ArrayList<Seat>(theatre.getSeats());
        pricesSeat.add(new Seat("B00", 13.00));
        pricesSeat.add(new Seat("A00", 13.00));
        Collections.sort(pricesSeat, Theatre.PRICE_ORDER);
        printList(pricesSeat);

    }

    public static void printList(List<Seat> seats) {
        for (Seat seat : seats) {
            System.out.print(" " + seat.getSeatNumber()+ " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("===================================");
    }
}
