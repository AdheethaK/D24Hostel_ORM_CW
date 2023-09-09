package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Reservation;
import entity.Room;
import entity.Student;

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
                entity.getArrivalDate(),
                entity.getDepartureDate(),
                getStudent(entity.getStudentId()),
                getRoom(entity.getRoomTypeId()),
                entity.getStatus()
        ));
    }
    private Student getStudent(StudentDTO studentDTO){//convert StudentDTO to Student type
        return new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContactNo(),
                studentDTO.getDob(),
                studentDTO.getGender()
        );
    }
    private Room getRoom(RoomDTO roomDTO){//convert RoomDTO to Room type
        return new Room(
                roomDTO.getRoomTypeId(),
                roomDTO.isTypeFOOD(),
                roomDTO.isTypeAC(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty()
        );
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
                reservation.getArrivalDate(),
                reservation.getDepartureDate(),
                getStudentDTO(reservation.getStudentId()),
                getRoomDTO(reservation.getRoomTypeId()),
                reservation.getStatus()
        );
    }
    private StudentDTO getStudentDTO(Student student){//convert Student to StudentDTO type
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getContactNo(),
                student.getDob(),
                student.getGender()
        );
    }
    private RoomDTO getRoomDTO(Room room){//convert Room to RoomDTO type
        return new RoomDTO(
                room.getRoomTypeId(),
                room.isTypeFOOD(),
                room.isTypeAC(),
                room.getKeyMoney(),
                room.getQty()
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
        ArrayList<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (Reservation res : reservationDAO.getAll()){
            reservationDTOS.add(new ReservationDTO(
                    res.getReservationId(),
                    res.getArrivalDate(),
                    res.getDepartureDate(),
                    getStudentDTO(res.getStudentId()),
                    getRoomDTO(res.getRoomTypeId()),
                    res.getStatus()
            ));
        }
        return reservationDTOS;
    }

    @Override
    public boolean add(ReservationDTO entity) throws Exception { //✔
        return reservationDAO.add(new Reservation(
                entity.getReservationId(),
                entity.getArrivalDate(),
                entity.getDepartureDate(),
                getStudent(entity.getStudentId()),
                getRoom(entity.getRoomTypeId()),
                entity.getStatus()
        ));
    }
}
