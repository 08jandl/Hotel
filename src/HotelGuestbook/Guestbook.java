package HotelGuestbook;

import java.util.HashMap;
import java.util.Map;

public class Guestbook {
    private String message;
    private Map<Guest, String> guestBookEntries;

    public Guestbook(String message) {
        this.message = message;
        this.guestBookEntries = new HashMap<>();
    }

    public void addEntry (Guest guest, String entry) {
        guestBookEntries.put(guest, entry);
    }
    public void showGuestbook () {
        for (Guest guest : guestBookEntries.keySet()) {
            System.out.println(guest.getName() + " wrote this into the guestbook: ");
            System.out.println(guestBookEntries.get(guest));
            System.out.println();
        }
    }

    public String getMessage() {
        return message;
    }

}
