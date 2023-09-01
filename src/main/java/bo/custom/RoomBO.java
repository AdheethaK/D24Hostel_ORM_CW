package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomBO extends SuperBO {
    public String generateNewID() throws Exception; //➕ NEW ID
    public boolean update(RoomDTO entity) throws Exception; //🔃
    public boolean delete(String id) throws Exception; //🗑️
    public RoomDTO search(String id) throws Exception; //🔍
    public boolean exist(String id) throws SQLException, ClassNotFoundException; //🔍 ID
    public ArrayList<String> getAllIds() throws Exception; //🔍 ID ALL
    public ArrayList<RoomDTO> getAll() throws Exception; //🔍 ALL
    public boolean add(RoomDTO entity) throws Exception; //✔
}
