import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortTicket() {
        AviaSouls manadger = new AviaSouls();

        Ticket ticket1 = new Ticket("Samara", "Moscow", 9501, 16, 18);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 17100, 11, 19);
        Ticket ticket3 = new Ticket("Samara", "Soch", 3448, 12, 15);
        Ticket ticket4 = new Ticket("Samara", "Moscow", 9000, 9, 14);
        Ticket ticket5 = new Ticket("Moscow", "Ircutsk", 9400, 10, 16);

        manadger.add(ticket1);
        manadger.add(ticket2);
        manadger.add(ticket3);
        manadger.add(ticket4);
        manadger.add(ticket5);

        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = manadger.search("Samara", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTicketTime() {
        AviaSouls manadger = new AviaSouls();

        Ticket ticket1 = new Ticket("Samara", "Moscow", 9501, 16, 18);
        Ticket ticket2 = new Ticket("Moscow", "Vladivostok", 17100, 11, 19);
        Ticket ticket3 = new Ticket("Samara", "Soch", 3448, 12, 15);
        Ticket ticket4 = new Ticket("Samara", "Moscow", 9000, 9, 14);
        Ticket ticket5 = new Ticket("Moscow", "Ircutsk", 9400, 10, 16);

        manadger.add(ticket1);
        manadger.add(ticket2);
        manadger.add(ticket3);
        manadger.add(ticket4);
        manadger.add(ticket5);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket4};
        Ticket[] actual = manadger.search("Samara", "Moscow", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
