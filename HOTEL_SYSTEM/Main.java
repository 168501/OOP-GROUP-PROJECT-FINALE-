package HOTEL_SYSTEM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Hotel hotel = Hotel.createHotel();

        System.out.println("Hotel created successfully!");


        hotel.displayRoomInfo();


        System.out.println("Enter your name:");
        String guestName = scanner.nextLine();

        System.out.println("Enter your email:");
        String guestEmail = scanner.nextLine();

        System.out.println("Enter the room number to book (between 0 and 99):");
        int roomToBook = scanner.nextInt();

        if (roomToBook >= 0 && roomToBook < 100) {
            System.out.println("available.");






        }else {
            System.out.println("Invalid room number. Room number should be between 0 and 99.");
        }


        hotel.displayRoomInfo();
    }
}
