package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO{
    public String generateNewID() throws Exception; //➕ NEW ID
    public boolean update(T entity) throws Exception; //🔃
    public boolean delete(String id) throws Exception; //🗑️
    public T search(String id) throws Exception; //🔍
    public boolean exist(String id) throws SQLException, ClassNotFoundException; //🔍 ID
    public ArrayList<String> getAllIds() throws Exception; //🔍 ID ALL
    public ArrayList<T> getAll() throws Exception; //🔍 ALL
    public boolean add(T entity) throws Exception; //✔
}
