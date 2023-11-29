import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Hotel {
    private static String hotelName;
    private static String location;
    private static String email;
    private static Room[] rooms;
    private int capacity;

    public Hotel(String hotelName, String location, String email, int capacity) {
        this.hotelName = hotelName;
        this.location = location;
        this.email = email;
        this.capacity = capacity;
        this.rooms = initializeRooms(capacity);
        saveHotelDetails();
    }

    public static Hotel createHotel() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the hotel name:");
        String hotelName = scanner.nextLine();

        System.out.println("Enter the hotel location:");
        String location = scanner.nextLine();

        System.out.println("Enter the hotel email:");
        String email = scanner.nextLine();


        int capacity = 100;

        return new Hotel(hotelName, location, email, capacity);
    }

    public void displayRoomInfo() {
        System.out.println("Hotel Information:");
        System.out.println("Name: " + hotelName);
        System.out.println("Location: " + location);
        System.out.println("Email: " + email);

        System.out.println("\nRoom Information:");
        for (Room room : rooms) {
            System.out.println("Room ID: " + room.getRoomID() + ", Occupied: " + room.isOccupied());
        }
        System.out.println("--------------------------------");
    }

    public static void bookRoom(int roomID) {
        Room room = findRoom(roomID, rooms);
        if (room != null) {
            room.setOccupied(true);
            System.out.println("Room " + roomID + " has been booked.");
            saveHotelDetails();
        } else {
            System.out.println("Room " + roomID + " does not exist in the hotel.");
        }
    }

    private Room[] initializeRooms(int capacity) {
        Room[] rooms = new Room[capacity];
        for (int i = 0; i < capacity; i++) {
            rooms[i] = new Room(i);
        }
        return rooms;
    }

    private static Room findRoom(int roomID, Room[] rooms) {
        for (Room room : rooms) {
            if (room.getRoomID() == roomID) {
                return room;
            }
        }
        return null;
    }

    private static void saveHotelDetails() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hotel_details.txt"))) {
            writer.write("Hotel Information:\n");
            writer.write("Name: " + hotelName + "\n");
            writer.write("Location: " + location + "\n");
            writer.write("Email: " + email + "\n");

            writer.write("\nRoom Information:\n");
            for (Room room : rooms) {
                writer.write("Room ID: " + room.getRoomID() + ", Occupied: " + room.isOccupied() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

class Room {
    private int roomID;
    private boolean occupied;

    public Room(int roomID) {
        this.roomID = roomID;
        this.occupied = false;
    }

    public int getRoomID() {
        return roomID;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}