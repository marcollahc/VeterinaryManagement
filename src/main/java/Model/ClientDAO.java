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
        int index = 0;

        for (Client client:this.clients) {
            if (client.getId() == id) {
                Client client_update = this.clients.get(index);
                client_update.setName(name);
                client_update.setDocument(document);
                client_update.setPhone(phone);
                client_update.setEmail(email);
                client_update.setZipCode(zip_code);
                client_update.setStreetNumber(street_number);
                client_update.setStreetComplement(street_complement);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Client client:this.clients) {
            if (client.getId() == id) {
                this.clients.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
