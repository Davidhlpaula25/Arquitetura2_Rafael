package com.example.main;

import java.util.Scanner;

import com.example.repositorio.ReservationRepository;
import com.example.repositorio.RoomRepository;
import com.example.servico.ReservationService;
import com.example.servico.RoomService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoomRepository roomRepository = new RoomRepository();
        ReservationRepository reservationRepository = new ReservationRepository();
        RoomService roomService = new RoomService(roomRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, roomService);

        roomService.addRoom("Sala A");
        roomService.addRoom("Sala B");

        int option;
        do {
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Cancelar reserva");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite seu nome: ");
                    String user = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String room = scanner.nextLine();
                    reservationService.makeReservation(room, user);
                    break;
                case 2:
                    reservationService.listReservations();
                    break;
                case 3:
                    System.out.print("Digite seu nome: ");
                    String cancelUser = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String cancelRoom = scanner.nextLine();
                    reservationService.cancelReservation(cancelRoom, cancelUser);
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}