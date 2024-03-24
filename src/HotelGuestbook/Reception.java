package HotelGuestbook;

public class Reception {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(12, "The Best Hotel");

        KeyRack keyRack = hotel.getKeyRack();
        Key[] keys = keyRack.getKeys();
        keyRack.showKeyRack(keys);

        Guest guest1 = new Guest("Grace Hopper", 1);
        hotel.welcomeToHotel(guest1);
        keyRack.giveKeyToGuest(guest1, keys);
        Guest guest2 = new Guest("Alice Walker", 2);
        hotel.welcomeToHotel(guest2);
        keyRack.giveKeyToGuest(guest2, keys);
        Guest guest3 = new Guest("Octavia Butler", 3);
        hotel.welcomeToHotel(guest3);
        keyRack.giveKeyToGuest(guest3, keys);

        keyRack.showKeyRack(keys);

        keyRack.takeKeyBackFromGuest(guest1, keys);
        hotel.farewellFromHotel(guest1);
        hotel.getGuestbook().addEntry(guest1, "I had a lovely stay, I will be coming back!");

        hotel.getGuestbook().showGuestbook();

    }
}
