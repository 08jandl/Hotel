package HotelKeyRack;

public class Guest {
    private String name;
    private int roomNumber;
    private Key key;

    public Guest(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber - 1; // because we are saving into keys array, and room number 0 is awkward
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
