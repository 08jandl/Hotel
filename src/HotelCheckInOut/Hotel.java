package HotelCheckInOut;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
    private final String hotelName;
    private final KeyRack keyRack;
    private final Guestbook guestbook;
    private final Map<Guest, Integer> currentGuests;

    public Hotel(int numberOfRooms, String hotelName) {
        this.hotelName = hotelName;
        keyRack = createKeyRack(numberOfRooms);
        guestbook = new Guestbook("We would love for you to write in our guestbook!", new HashMap<>());
        currentGuests = new HashMap<>();
    }

    private KeyRack createKeyRack(int numberOfRooms) {
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
        System.out.println("------------------------------------------------");
    }

    public void checkIn(String name) {
        int nextFreeRoom = getNextFreeRoom();
        if (nextFreeRoom == -1) {
            System.out.println("Sorry, we are fully booked");
        } else {
            Guest guest = new Guest(name, nextFreeRoom);
            welcomeToHotel(guest);
            keyRack.giveKeyToGuest(guest, keyRack.getKeys());
            currentGuests.put(guest, nextFreeRoom);
        }
    }

    private int getNextFreeRoom() {
        int roomNumber = -1;
        for (Key key : keyRack.getKeys()) {
            if (!key.isWithGuest()) {
                return key.getRoomNumber() + 1;
            }
        } return roomNumber;
    }

    public void checkOut(String name) {
        Guest guest = null;
        for (Guest g : currentGuests.keySet()) {
            if (g.getName().equals(name)) {
                guest = g;
            }
        }
        if (guest != null) {
            Scanner scanner = new Scanner(System.in);
            keyRack.takeKeyBackFromGuest(guest, keyRack.getKeys());
            farewellFromHotel(guest);
            System.out.println(guestbook.getMessage());
            System.out.println("Please enter your name:");
            String nameGb = scanner.nextLine();
            System.out.println("Please enter your message: ");
            String messageGb = scanner.nextLine();
            if (nameGb.equals(guest.getName())) {
                guestbook.addEntry(guest, messageGb);
            }
            currentGuests.remove(guest);
        } else {
            System.out.println("Sorry, there is no current guest by the name " + name);
        }
    }

    public KeyRack getKeyRack() {
        return keyRack;
    }

    public Guestbook getGuestbook() {
        return guestbook;
    }

    public Map<Guest, Integer> getCurrentGuests() {
        return currentGuests;
    }
}
