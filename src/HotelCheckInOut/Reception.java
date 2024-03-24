package HotelCheckInOut;

public class Reception {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(12, "The Best Hotel");

        // showing keyRack before and after operation just to see if everything works as expected
//        KeyRack keyRack = hotel.getKeyRack();
//        Key[] keys = keyRack.getKeys();
//        keyRack.showKeyRack(keys);

        hotel.checkIn("Grace Hopper");
        hotel.checkIn("Alice Walker");
        hotel.checkIn("Octavia Butler");

//        keyRack.showKeyRack(keys);

        hotel.checkOut("Grace Hopper");

        hotel.getGuestbook().showGuestbook();
    }
}
