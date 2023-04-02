package lk.ijse.hibernate.coursework.dao;

public interface CrudDAO<T, ID> {
    //    List<T> getAll() throws Exception;
//   ID  save(T dto) throws Exception;
//    void update(T dto) throws Exception;
//    void delete(T dto) throws Exception;
//    ID generateNewID() throws Exception;
//    T getObject(ID id) throws Exception;
    boolean save(T object);

    void update(T object);

    T get(ID id);

    void delete(T object);
}
