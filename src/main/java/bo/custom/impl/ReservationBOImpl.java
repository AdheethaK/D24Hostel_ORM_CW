package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import entity.Reservation;
import entity.Room;

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
        return reservationDAO.update(new Reservation(
                entity.getReservationId(),
                entity.getDate(),
                entity.getStudentId(),
                entity.getRoomTypeId(),
                entity.getStatus()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return reservationDAO.delete(id);
    }

    @Override
    public ReservationDTO search(String id) throws Exception { //🔍
        Reservation reservation =  reservationDAO.search(id);

        return new ReservationDTO(
                reservation.getReservationId(),
                reservation.getDate(),
                reservation.getStudentId(),
                reservation.getRoomTypeId(),
                reservation.getStatus()
        );
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
        return reservationDAO.add(new Reservation(
                entity.getReservationId(),
                entity.getDate(),
                entity.getStudentId(),
                entity.getRoomTypeId(),
                entity.getStatus()
        ));
    }
}
