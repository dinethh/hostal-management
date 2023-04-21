package lk.ijse.hibernate.coursework.dao;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO {
    List<T> getAll();

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(String id);
    ID generateNewID() throws Exception;
    T search(String id);
    T getObject(String id);
}
