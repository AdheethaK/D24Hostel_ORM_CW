package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    public String generateNewID() throws Exception; //➕ NEW ID
    public boolean update(StudentDTO entity) throws Exception; //🔃
    public boolean delete(String id) throws Exception; //🗑️
    public StudentDTO search(String id) throws Exception; //🔍
    public boolean exist(String id) throws SQLException, ClassNotFoundException; //🔍 ID
    public ArrayList<String> getAllIds() throws Exception; //🔍 ID ALL
    public ArrayList<StudentDTO> getAll() throws Exception; //🔍 ALL
    public boolean add(StudentDTO entity) throws Exception; //✔
}
