package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public String generateNewID() throws Exception { //➕ NEW ID
        return null;
    }

    @Override
    public boolean update(StudentDTO entity) throws Exception { //🔃
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return false;
    }

    @Override
    public StudentDTO search(String id) throws Exception { //🔍
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
    public ArrayList<StudentDTO> getAll() throws Exception { //🔍 ALL
        return null;
    }

    @Override
    public boolean add(StudentDTO entity) throws Exception { //✔
        return false;
    }
}
