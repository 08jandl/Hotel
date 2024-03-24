package HotelKeyRack;

public class KeyRack {

    private int numberOfRooms;

    private final Key[] keys;

    public KeyRack(int numberOfRooms, Key[] keys) {
        this.numberOfRooms = numberOfRooms;
        this.keys = keys;
    }

    public void giveKeyToGuest(Guest guest, Key[] keys) {
        int roomNumber = guest.getRoomNumber();
        Key key = keys[roomNumber];

        if (key != null) {
            guest.setKey(key);
            key.setWithGuest(true); // you can also set the key null, so it is completely out of the keyrack
        } else {
            System.out.println("Missing key, alert police!");
        }
    }

    public void takeKeyBackFromGuest(Guest guest) {
        Key key = guest.getKey();

        key.setWithGuest(false);
        guest.setKey(null);
        key.setWithGuest(false);
    }

    public void showKeyRack(Key[] keys) {
        for (Key key : keys) {
            System.out.println(key);
        }
        System.out.println("----------------------------------");
    }
}
