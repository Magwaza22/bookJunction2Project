package za.ac.cput.repository;

public interface IReposity <T, ID>{
    T create (T t);
    T read(ID id);
    T update (T t);
    boolean delete(ID id);

}
