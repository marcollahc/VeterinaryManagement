package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpecieDAO {
    private List<Specie> species = new ArrayList<Specie>();
    private int specie_id = 1;

    public List<Specie> create(String name) {
        Specie specie = new Specie(specie_id, name);
        this.species.add(specie);
        specie_id++;
        return this.species;
    }

    public List<Specie> retrieveAll() {
        return this.species;
    }

    public List<Specie> retrieveByID(int id) {
        return (List<Specie>) this.species.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String name) {
        int index = 0;

        for (Specie specie:this.species) {
            if (specie.getId() == id) {
                Specie specie_update = this.species.get(index);
                specie_update.setName(name);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Specie specie:this.species) {
            if (specie.getId() == id) {
                this.species.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
