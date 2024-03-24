package HotelGuestbook;

public class KeyRack {

    private int numberOfRooms;

    private Key[] keys = new Key[numberOfRooms];

    public KeyRack(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void giveKeyToGuest(Guest guest, Key[] keys) {
        int roomNumber = guest.getRoomNumber();
        Key key = keys[roomNumber];

        if (key != null) {
            guest.setKey(key);
            key.setWithGuest(true);
        } else {
            System.out.println("Missing key, alert police!");
        }
    }

    public void takeKeyBackFromGuest(Guest guest, Key[] keys) {
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

    public Key[] getKeys() {
        return keys;
    }

    public void setKeys(Key[] keys) {
        this.keys = keys;
    }
}
