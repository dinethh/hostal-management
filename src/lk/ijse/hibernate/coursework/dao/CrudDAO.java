package lk.ijse.hibernate.coursework.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {
    List<T> getAll() throws Exception;
    ID save(T dto) throws Exception;
    void update(T dto) throws Exception;
    void delete(T dto) throws Exception;
//    ID generateNewID() throws Exception;
    T getObject(ID id) throws Exception;
}
