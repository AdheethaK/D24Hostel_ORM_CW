package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(Student entity) throws Exception { //🔃
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
        Student entity = new Student();
        entity.setId(id);
        session.delete(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String id) throws Exception { //🔍
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student entity = (Student) session.get(Student.class,id);
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

        Query query=session.createQuery("select id from Student ");
        ArrayList<String> list = (ArrayList<String>) query.list();
        for (String id: list){
            System.out.println(id);
        }

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public ArrayList<Student> getAll() throws Exception { //🔍 ALL
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query=session.createQuery("from Student");
        ArrayList<Student> list = (ArrayList<Student>) query.list();
        for (Student student: list){
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getAddress());
            System.out.println(student.getContactNo());
            System.out.println(student.getDob().toString());
            System.out.println(student.getGender());
        }

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Student entity) throws Exception { //✔
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }
}
