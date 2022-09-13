package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnimalDAO extends DAO {
    private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    public static AnimalDAO getInstance() {
        return ((instance == null) ? (instance = new AnimalDAO()) : instance);
    }

    public Animal create(String name, String birthdate, int sex, int specie_id, int client_id) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO animal (name, birthdate, sex, specie_id, client_id) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, birthdate);
            statement.setInt(3, sex);
            statement.setInt(4, specie_id);
            statement.setInt(5, client_id);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("animal", "id"));
    }

    public boolean isLastEmpty() {
        Animal lastAnimal = this.retrieveByID(lastId("animal", "id"));
        if (lastAnimal != null) {
            return lastAnimal.getName().isBlank();
        }

        return false;
    }

    private Animal buildObject(ResultSet result_set) {
        Animal animal = null;

        try {
            animal = new Animal(
                result_set.getInt("id"),
                result_set.getString("name"),
                result_set.getString("birthdate"),
                result_set.getInt("sex"),
                result_set.getInt("specie_id"),
                result_set.getInt("client_id")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return animal;
    }

    public List retrieve(String query) {
        List<Animal> animals = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                animals.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return animals;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM animal WHERE id = " + lastId("animal", "id"));
    }

    public Animal retrieveByID(int id) {
        List<Animal> animals = this.retrieve("SELECT * FROM animal WHERE id = " + id);

        return (animals.isEmpty() ? null : animals.get(0));
    }

    public List retrieveAnimalsByID(int id) {
        return this.retrieve("SELECT * FROM animal WHERE client_id = " + id);
    }

    public List retrieveBySimilarName(String name) {
        return this.retrieve("SELECT * FROM animal WHERE name LIKE '" + name + "'%");
    }

    public void update(Animal animal) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE animal SET name = ?, birthdate = ?, sex = ?, specie_id = ?, client_id = ? WHERE id = ?");
            statement.setString(1, animal.getName());
            statement.setString(2, animal.getBirthdate());
            statement.setInt(3, animal.getSex());
            statement.setInt(4, animal.getSpecieId());
            statement.setInt(5, animal.getClientId());
            statement.setInt(6, animal.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Animal animal) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id = ?");
            statement.setInt(1, animal.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
