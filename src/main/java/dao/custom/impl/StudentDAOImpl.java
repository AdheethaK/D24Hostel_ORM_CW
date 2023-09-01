package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(Student entity) throws Exception { //🔃
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return false;
    }

    @Override
    public Student search(String id) throws Exception { //🔍
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
    public ArrayList<Student> getAll() throws Exception { //🔍 ALL
        return null;
    }

    @Override
    public boolean add(Student entity) throws Exception { //✔
        return false;
    }
}
