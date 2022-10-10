package Model;

public class Treatment {
    private int id;
    private String start_date;
    private String final_date;
    private int animal_id;

    public Treatment(int id, String start_date, String final_date, int animal_id) {
        this.id = id;
        this.start_date = start_date;
        this.final_date = final_date;
        this.animal_id = animal_id;
    }

    public int getId() {
        return this.id;
    }

    public String getStartDate() {
        return this.start_date;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getFinalDate() {
        return this.final_date;
    }

    public void setFinalDate(String final_date) {
        this.final_date = final_date;
    }

    public int getAnimalId() {
        return this.animal_id;
    }

    public void setAnimalId(int animal_id) {
        this.animal_id = animal_id;
    }
}
