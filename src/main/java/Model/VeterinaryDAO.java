package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeterinaryDAO extends DAO {
    private static VeterinaryDAO instance;

    private VeterinaryDAO() {
        getConnection();
        createTable();
    }

    public static VeterinaryDAO getInstance() {
        return ((instance == null) ? (instance = new VeterinaryDAO()) : instance);
    }

    public Veterinary create(String name, String document, String phone, String email, String zip_code, int street_number, String street_complement, String crmv) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO veterinary (name, document, phone, email, zip_code, street_number, street_complement, crmv) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, document);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, zip_code);
            statement.setInt(6, street_number);
            statement.setString(7, street_complement);
            statement.setString(8, crmv);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(VeterinaryDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("veterinary", "id"));
    }

    public boolean isLastEmpty() {
        Veterinary lastVeterinary = this.retrieveByID(lastId("veterinary", "id"));
        if (lastVeterinary != null) {
            return lastVeterinary.getName().isBlank();
        }

        return false;
    }

    private Veterinary buildObject(ResultSet result_set) {
        Veterinary veterinary = null;

        try {
            veterinary = new Veterinary(
                    result_set.getInt("id"),
                    result_set.getString("name"),
                    result_set.getString("document"),
                    result_set.getString("phone"),
                    result_set.getString("email"),
                    result_set.getString("zip_code"),
                    result_set.getInt("street_number"),
                    result_set.getString("street_complement"),
                    result_set.getString("crmv")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return veterinary;
    }

    public List retrieve(String query) {
        List<Veterinary> veterinarians = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                veterinarians.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return veterinarians;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM veterinary");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM veterinary WHERE id = " + lastId("veterinary", "id"));
    }

    public Veterinary retrieveByID(int id) {
        List<Veterinary> veterinarians = this.retrieve("SELECT * FROM veterinary WHERE id = " + id);

        return (veterinarians.isEmpty() ? null : veterinarians.get(0));
    }

    public List retrieveBySimilarName(String name) {
        return this.retrieve("SELECT * FROM veterinary WHERE name LIKE '" + name + "'%");
    }

    public void update(Veterinary veterinary) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE veterinary SET name = ?, document = ?, phone = ?, email = ?, zip_code = ?, street_number = ?, street_complement = ?, crmv = ? WHERE id = ?");
            statement.setString(1, veterinary.getName());
            statement.setString(2, veterinary.getDocument());
            statement.setString(3, veterinary.getPhone());
            statement.setString(4, veterinary.getEmail());
            statement.setString(5, veterinary.getZipCode());
            statement.setInt(6, veterinary.getStreetNumber());
            statement.setString(7, veterinary.getStreetComplement());
            statement.setString(8, veterinary.getCrmv());
            statement.setInt(9, veterinary.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Veterinary veterinary) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM veterinary WHERE id = ?");
            statement.setInt(1, veterinary.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
