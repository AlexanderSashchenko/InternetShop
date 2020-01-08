package mate.academy.internetshop.dao;

import java.util.List;
import java.util.Optional;

public interface DaoGeneric<T, ID> {
    T create(T entity);

    Optional<T> get(ID id);

    Optional<T> update(T entity);

    boolean delete(ID id);

    boolean deleteByEntity(T entity);

    List<T> getAllEntities();
}
