package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(Room entity) throws Exception { //🔃
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room entity = new Room();
        entity.setRoomTypeId(id);
        session.delete(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String id) throws Exception { //🔍
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room entity = (Room) session.get(Room.class,id);
        transaction.commit();
        session.close();
        return entity;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException { //🔍 ID
        return false;
    }

    @Override
    public ArrayList<String> getAllIds() throws Exception { //🔍 ID ALL
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createQuery("select roomTypeId from Room ");
        ArrayList<String> list = (ArrayList<String>) query.list();
        for (String id: list){
            System.out.println(id);
        }

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public ArrayList<Room> getAll() throws Exception { //🔍 ALL
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createQuery("from Room");
        ArrayList<Room> list = (ArrayList<Room>) query.list();
        for (Room room: list){
            System.out.println(room.getRoomTypeId());
            System.out.println(room.isTypeFOOD());
            System.out.println(room.isTypeAC());
            System.out.println(room.getKeyMoney());
            System.out.println(room.getQty());
        }

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Room entity) throws Exception { //✔
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
