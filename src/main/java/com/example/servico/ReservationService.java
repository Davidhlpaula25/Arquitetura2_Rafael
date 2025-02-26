package com.example.servico;

import java.util.List;

import com.example.main.modelo.Reservation;
import com.example.repositorio.ReservationRepository;

public class ReservationService {
    private ReservationRepository reservationRepository;
    private RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
    }

    public void makeReservation(String roomName, String user) {
        if (roomService.roomExists(roomName)) {
            reservationRepository.addReservation(roomName, user);
            System.out.println("Reserva feita com sucesso!");
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    public void listReservations() {
        List<Reservation> reservations = reservationRepository.getReservations();
        if (reservations.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    public void cancelReservation(String roomName, String user) {
        reservationRepository.cancelReservation(roomName, user);
        System.out.println("Reserva cancelada.");
    }
}
