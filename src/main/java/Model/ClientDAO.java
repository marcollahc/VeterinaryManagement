package Model;

import java.util.List;

public class ClientDAO {
    private List<Client> clients;
    private int client_id = 1;

    public ClientDAO(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        Client client = new Client(client_id, name, document, phone, email, zip_code, street_number, street_complement);
        this.clients.add(client);
        client_id++;
        return this.clients;
    }

    public List<Client> retrieveAll() {
        return this.clients;
    }

    public Client retrieveByID(int id) {
        return (Client) this.clients.stream().filter(item -> item.getId() == id);
    }

    public int update(int id, String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        Client client = (Client) this.clients.stream().filter(item -> item.getId() == id);
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
        this.clients.remove(id);

        return 1;
    }
}
