package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class AnimalDAO extends DAO {
    private static AnimalDAO instance;

    private AnimalDAO() {
        getConnection();
        createTable();
    }

    public static ClientDAO getInstance() {
        return ((instance == null) ? (instance = new AnimalDAO()) : instance));
    }

    public List<Animal> create(String name, String birthdate, int sex, int specie_id, int client_id) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO animal (name, birthdate, sex, specie_id, client_id) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, birthdate);
            statement.setString(3, String.valueOf(sex));
            statement.setString(4, String.valueOf(specie_id));
            statement.setString(5, String.valueOf(client_id));
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

    public List<Animal> retrieveAll() {
        return this.animals;
    }

    public List<Animal> retrieveByID(int id) {
        return (List<Animal>) this.animals.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public List<Animal> retrieveByClientID(int id) {
        return (List<Animal>) this.animals.stream().filter(item -> item.getClientId() == id).collect(Collectors.toList());
    }

    public int update(int id, String name, String birthdate, int sex, int specie_id, int client_id) {
        int index = 0;

        for (Animal animal:this.animals) {
            if (animal.getId() == id) {
                Animal animal_update = this.animals.get(index);
                animal_update.setName(name);
                animal_update.setBirthdate(birthdate);
                animal_update.setSex(sex);
                animal_update.setSpecieId(specie_id);
                animal_update.setClientId(client_id);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Animal animal:this.animals) {
            if (animal.getId() == id) {
                this.animals.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
