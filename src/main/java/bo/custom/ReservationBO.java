package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBO extends SuperBO {
    public String generateNewID() throws Exception; //➕ NEW ID
    public boolean update(ReservationDTO entity) throws Exception; //🔃
    public boolean delete(String id) throws Exception; //🗑️
    public ReservationDTO search(String id) throws Exception; //🔍
    public boolean exist(String id) throws SQLException, ClassNotFoundException; //🔍 ID
    public ArrayList<String> getAllIds() throws Exception; //🔍 ID ALL
    public ArrayList<ReservationDTO> getAll() throws Exception; //🔍 ALL
    public boolean add(ReservationDTO entity) throws Exception; //✔
}
