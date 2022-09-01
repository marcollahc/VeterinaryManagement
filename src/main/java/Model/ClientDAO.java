package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClientDAO {
    private List<Client> clients = new ArrayList<Client>();
    private int client_id = 1;

    public List<Client> create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        Client client = new Client(client_id, name, document, phone, email, zip_code, street_number, street_complement);
        this.clients.add(client);
        client_id++;
        return this.clients;
    }

    public List<Client> retrieveAll() {
        return this.clients;
    }

    public List<Client> retrieveByID(int id) {
        return (List<Client>) this.clients.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        Client client = this.clients.get(id - 1);
        client.setName(name);
        client.setDocument(document);
        client.setPhone(phone);
        client.setEmail(email);
        client.setZipCode(zip_code);
        client.setStreetNumber(street_number);
        client.setStreetComplement(street_complement);

        return 1;
    }

    public int delete(int id) {
        this.clients.remove(id - 1);

        return 1;
    }
}
