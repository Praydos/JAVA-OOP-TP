import java.util.List;

public interface IMetier<T> {
     T add(T t);
     void delete(String t);
     List<T> getAll();
     T findByNom(String nom);
     void saveAll();



}
