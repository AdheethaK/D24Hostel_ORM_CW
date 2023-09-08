package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Room;
import entity.Student;

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
        return studentDAO.update(new Student(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getContactNo(),
                entity.getDob(),
                entity.getGender()
        ));
    }

    @Override
    public boolean delete(String id) throws Exception { //🗑️
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO search(String id) throws Exception { //🔍
        Student student =  studentDAO.search(id);

        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getContactNo(),
                student.getDob(),
                student.getGender()
        );
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException { //🔍 ID
        return false;
    }

    @Override
    public ArrayList<String> getAllIds() throws Exception { //🔍 ID ALL
        return studentDAO.getAllIds();
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception { //🔍 ALL
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : studentDAO.getAll()){
            studentDTOS.add(new StudentDTO(
                    s.getId(),
                    s.getName(),
                    s.getAddress(),
                    s.getContactNo(),
                    s.getDob(),
                    s.getGender()
            ));
        }
        return studentDTOS;
    }

    @Override
    public boolean add(StudentDTO entity) throws Exception { //✔
        return studentDAO.add(new Student(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getContactNo(),
                entity.getDob(),
                entity.getGender()
        ));
    }
}
