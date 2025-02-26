package com.example.main.modelo;

public class Reservation {
    private String roomName;
    private String user;

    public Reservation(String roomName, String user) {
        this.roomName = roomName;
        this.user = user;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reserva para " + user + " na sala " + roomName;
    }
}
