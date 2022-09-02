package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalDAO {
    private List<Animal> animals = new ArrayList<Animal>();
    private int animal_id = 1;

    public List<Animal> create(String name, String birthdate, int sex, int specie_id, int client_id) {
        Animal animal = new Animal(animal_id, name, birthdate, sex, specie_id, client_id);
        this.animals.add(animal);
        animal_id++;
        return this.animals;
    }

    public List<Animal> retrieveAll() {
        return this.animals;
    }

    public List<Animal> retrieveByID(int id) {
        return (List<Animal>) this.animals.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
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
