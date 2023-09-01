package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);


    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(ReservationDTO entity) throws Exception { //🔃
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return false;
    }

    @Override
    public ReservationDTO search(String id) throws Exception { //🔍
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
    public ArrayList<ReservationDTO> getAll() throws Exception { //🔍 ALL
        return null;
    }

    @Override
    public boolean add(ReservationDTO entity) throws Exception { //✔
        return false;
    }
}
