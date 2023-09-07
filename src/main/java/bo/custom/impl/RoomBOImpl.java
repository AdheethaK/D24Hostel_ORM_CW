package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(RoomDTO entity) throws Exception { //🔃
        return roomDAO.update(new Room(
                entity.getRoomTypeId(),
                entity.isTypeFOOD(),
                entity.isTypeAC(),
                entity.getKeyMoney(),
                entity.getQty()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return roomDAO.delete(id);
    }

    @Override
    public RoomDTO search(String id) throws Exception { //🔍
        Room room =  roomDAO.search(id);

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
        return roomDAO.getAllIds();
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception { //🔍 ALL
        return null;
    }

    @Override
    public boolean add(RoomDTO entity) throws Exception { //✔
        return roomDAO.add(new Room(
                entity.getRoomTypeId(),
                entity.isTypeFOOD(),
                entity.isTypeAC(),
                entity.getKeyMoney(),
                entity.getQty()
        ));
    }
}
