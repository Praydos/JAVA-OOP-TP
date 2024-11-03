import java.util.List;

public interface IMetierProduit {
    Produit add(Produit p);
    List<Produit> getAll();
    List<Produit> findByNom(String motCle);
    Produit findById(String id); // Changed from long to String
    void delete(String id);      // Changed from long to String
}
