package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends DAO {
    private static ClientDAO instance;

    private ClientDAO() {
        getConnection();
        createTable();
    }

    public static ClientDAO getInstance() {
        return ((instance == null) ? (instance = new ClientDAO()) : instance);
    }

    public Client create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO client (name, document, phone, email, zip_code, street_number, street_complement) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, document);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, zip_code);
            statement.setInt(6, street_number);
            statement.setString(7, street_complement);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("client", "id"));
    }

    public boolean isLastEmpty() {
        Client lastClient = this.retrieveByID(lastId("client", "id"));
        if (lastClient != null) {
            return lastClient.getName().isBlank();
        }

        return false;
    }

    private Client buildObject(ResultSet result_set) {
        Client client = null;

        try {
            client = new Client(
                result_set.getInt("id"),
                result_set.getString("name"),
                result_set.getString("document"),
                result_set.getString("phone"),
                result_set.getString("email"),
                result_set.getString("zip_code"),
                result_set.getInt("street_number"),
                result_set.getString("street_complement")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return client;
    }

    public List retrieve(String query) {
        List<Client> clients = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                clients.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return clients;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM client");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM client WHERE id = " + lastId("client", "id"));
    }

    public Client retrieveByID(int id) {
        List<Client> clients = this.retrieve("SELECT * FROM client WHERE id = " + id);

        return (clients.isEmpty() ? null : clients.get(0));
    }

    public List retrieveBySimilarName(String name) {
        return this.retrieve("SELECT * FROM client WHERE name LIKE '" + name + "'%");
    }

    public void update(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE client SET name = ?, document = ?, phone = ?, email = ?, zip_code = ?, street_number = ?, street_complement = ? WHERE id = ?");
            statement.setString(1, client.getName());
            statement.setString(2, client.getDocument());
            statement.setString(3, client.getPhone());
            statement.setString(4, client.getEmail());
            statement.setString(5, client.getZipCode());
            statement.setInt(6, client.getStreetNumber());
            statement.setString(7, client.getStreetComplement());
            statement.setInt(8, client.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Client client) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM client WHERE id = ?");
            statement.setInt(1, client.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
