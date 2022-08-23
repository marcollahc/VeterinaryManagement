package Model;

public class Treatment {
    private int id;
    private String start_date;
    private String final_date;

    public Treatment(int id, String start_date, String final_date) {
        this.id = id;
        this.start_date = start_date;
        this.final_date = final_date;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return start_date;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getFinalDate() {
        return final_date;
    }

    public void setFinalDate(String final_date) {
        this.final_date = final_date;
    }
}
