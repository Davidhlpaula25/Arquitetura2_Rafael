package com.example.servico;

import com.example.repositorio.RoomRepository;

public class RoomService {
    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void addRoom(String name) {
        roomRepository.addRoom(name);
    }

    public boolean roomExists(String name) {
        return roomRepository.getRooms().stream().anyMatch(room -> room.getName().equalsIgnoreCase(name));
    }
}
