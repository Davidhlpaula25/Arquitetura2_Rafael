package com.example.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.main.modelo.Reservation;

public class ReservationRepository {
    public void addReservation(String roomName, String user) {
        String sql = "INSERT INTO reservations (room_name, user_name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomName);
            stmt.setString(2, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservation> getReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT room_name, user_name FROM reservations";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                reservations.add(new Reservation(rs.getString("room_name"), rs.getString("user_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    public void cancelReservation(String roomName, String user) {
        String sql = "DELETE FROM reservations WHERE room_name = ? AND user_name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, roomName);
            stmt.setString(2, user);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
