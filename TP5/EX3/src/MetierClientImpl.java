import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImpl implements IMetier<Client> {
    private List<Client> clients = new ArrayList<>();
    private String fileName;

    public MetierClientImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Client add(Client o) {
        clients.add(o);
        return o;
    }

    @Override
    public List<Client> getAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            clients = (List<Client>) ois.readObject();
        } catch (Exception e) {
            clients = new ArrayList<>();
        }
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        return clients.stream().filter(c -> c.getNom().equalsIgnoreCase(nom)).findFirst().orElse(null);
    }

    @Override
    public void delete(String nom) {
        clients.removeIf(c -> c.getNom().equalsIgnoreCase(nom));
    }

    @Override
    public void saveAll() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
