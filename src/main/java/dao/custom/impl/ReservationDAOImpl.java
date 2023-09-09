package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(Reservation entity) throws Exception { //🔃
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
        Reservation entity = new Reservation();
        entity.setReservationId(id);
        session.delete(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reservation search(String id) throws Exception { //🔍
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reservation entity = (Reservation) session.get(Reservation.class,id);
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
        return null;
    }

    @Override
    public ArrayList<Reservation> getAll() throws Exception { //🔍 ALL
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createQuery("from Reservation");
        ArrayList<Reservation> list = (ArrayList<Reservation>) query.list();
        for (Reservation reservation: list){
            System.out.println(reservation.getReservationId());
            System.out.println(reservation.getArrivalDate().toString());
            System.out.println(reservation.getDepartureDate().toString());
            System.out.println(reservation.getStudentId());
            System.out.println(reservation.getRoomTypeId());
            System.out.println(reservation.getStatus());
        }

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Reservation entity) throws Exception { //✔
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
