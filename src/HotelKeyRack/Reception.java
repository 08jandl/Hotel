package HotelKeyRack;

public class Reception {
    public static void main(String[] args) {
        Key key1 = new Key(1);
        Key key2 = new Key(2);
        Key key3 = new Key(3);
        Key[] keys = new Key[]{key1, key2, key3};
        KeyRack keyRack = new KeyRack(3, keys);

        keyRack.showKeyRack(keys);

        Guest guest1 = new Guest("Grace Hopper", 1);
        Guest guest2 = new Guest("Alice Walker", 2);
        Guest guest3 = new Guest("Octavia Butler", 3);
        keyRack.giveKeyToGuest(guest1, keys);
        keyRack.giveKeyToGuest(guest2, keys);

        keyRack.showKeyRack(keys);

        keyRack.giveKeyToGuest(guest3, keys);
        keyRack.takeKeyBackFromGuest(guest1);

    }
}
