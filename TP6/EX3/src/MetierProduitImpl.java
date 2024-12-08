import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits = new ArrayList<>();
    private String fileName;

    public MetierProduitImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Produit add(Produit o) {
        produits.add(o);
        return o;
    }


    public List<Produit> getFromFile() throws FileNotFoundException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);


    }

    @Override
    public List<Produit> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            produits = (List<Produit>) ois.readObject();
        } catch (Exception e) {
            produits = new ArrayList<>();
        }
        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        return produits.stream().filter(p -> p.getNom().equalsIgnoreCase(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        produits.removeIf(p -> p.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(produits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
