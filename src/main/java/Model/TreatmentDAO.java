package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreatmentDAO {
    private List<Treatment> treatments = new ArrayList<Treatment>();
    private int treatment_id = 1;

    public List<Treatment> create(String start_date, String final_date, int animal_id) {
        Treatment treatment = new Treatment(treatment_id, start_date, final_date, animal_id);
        this.treatments.add(treatment);
        treatment_id++;
        return this.treatments;
    }

    public List<Treatment> retrieveAll() {
        return this.treatments;
    }

    public List<Treatment> retrieveByID(int id) {
        return (List<Treatment>) this.treatments.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String start_date, String final_date, int animal_id) {
        int index = 0;

        for (Treatment treatment:this.treatments) {
            if (treatment.getId() == id) {
                Treatment treatment_update = this.treatments.get(index);
                treatment_update.setStartDate(start_date);
                treatment_update.setFinalDate(final_date);
                treatment_update.setAnimalId(animal_id);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Treatment treatment:this.treatments) {
            if (treatment.getId() == id) {
                this.treatments.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
