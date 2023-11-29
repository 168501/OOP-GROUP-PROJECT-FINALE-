Public class booking{

}

class Booking extends Room {
    public Booking(int roomID) {
        super(roomID);
    }

    public void checkBookingStatus(Room[] rooms, int roomID) {
        Room room = findRoom(roomID, rooms);
        if (room != null) {
            if (room.isOccupied()) {
                System.out.println("Room " + roomID + " is booked (occupied).");
            } else {
                System.out.println("Room " + roomID + " is not yet booked (not occupied).");
            }
        } else {
            System.out.println("Room " + roomID + " does not exist in the hotel.");
        }
    }

    private static Room findRoom(int roomID, Room[] rooms) {
        for (Room room : rooms) {
            if (room.getRoomID() == roomID) {
                return room;

            }
        }
        return null;
    }
}