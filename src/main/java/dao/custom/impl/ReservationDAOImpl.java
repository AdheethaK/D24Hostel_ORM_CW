package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(Reservation entity) throws Exception { //🔃
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return false;
    }

    @Override
    public Reservation search(String id) throws Exception { //🔍
        return null;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException { //🔍 ID
        return false;
    }

    @Override
    public ArrayList<String> getAllIds() throws Exception { //🔍 ID ALL
        return null;
    }

    @Override
    public ArrayList<Reservation> getAll() throws Exception { //🔍 ALL
        return null;
    }

    @Override
    public boolean add(Reservation entity) throws Exception { //✔
        return false;
    }
}
