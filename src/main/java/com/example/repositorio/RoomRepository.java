package com.example.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.example.main.modelo.Room;

public class RoomRepository {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(String name) {
        rooms.add(new Room(name));
    }

    public List<Room> getRooms() {
        return rooms;
    }
}