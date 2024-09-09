package Ecommerce.Platform.Service;

public interface BaseService<T, K> {
    T create(K dto);
    T save(T t);
    void remove(int id);
    Iterable<T> findAll();
    T findById(int id);
    T update(int id, K dto);
}
