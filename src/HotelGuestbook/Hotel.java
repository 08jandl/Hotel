package HotelGuestbook;

import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private final String hotelName;
    private KeyRack keyRack;
    private final Guestbook guestbook;
    private Map<Guest, Integer> currentGuests;

    public Hotel(int numberOfRooms, String hotelName) {
        this.hotelName = hotelName;
        guestbook = new Guestbook("We would love for you to write in our guestbook!");
        currentGuests = new HashMap<>();
        keyRack = createKeyRack(numberOfRooms);
    }

    public KeyRack createKeyRack(int numberOfRooms) {
        Key[] keys = new Key[numberOfRooms];

        for (int i = 0; i < numberOfRooms; i++) {
            Key key = new Key(i);
            keys[i] = key;
        }

        KeyRack keyRack = new KeyRack(numberOfRooms);
        keyRack.setKeys(keys);
        return keyRack;
    }

    public void welcomeToHotel(Guest guest) {
        System.out.println("Dear " + guest.getName() + " welcome to " + hotelName + "!");
        System.out.println("We hope you enjoy your stay!");
    }

    public void farewellFromHotel(Guest guest) {
        System.out.println("Dear " + guest.getName() + " we hope you have enjoyed your stay at " + hotelName + "!");
        System.out.println("We hope to welcome you back very soon!");
        System.out.println(guestbook.getMessage());
        System.out.println("------------------------------------------------");
    }

    public KeyRack getKeyRack() {
        return keyRack;
    }

    public Guestbook getGuestbook() {
        return guestbook;
    }
}
