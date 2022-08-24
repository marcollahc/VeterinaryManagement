package Model;

public class MedicalAppointment {
    private int id;
    private String date_appointment;
    private String history;
    private int treatment_id;
    private int veterinary_id;

    public MedicalAppointment(int id, String date_appointment, String history, int treatment_id, int veterinary_id) {
        this.id = id;
        this.date_appointment = date_appointment;
        this.history = history;
        this.treatment_id = treatment_id;
        this.veterinary_id = veterinary_id;
    }

    public int getId() {
        return id;
    }

    public String getDateAppointment() {
        return date_appointment;
    }

    public void setDateAppointment(String date_appointment) {
        this.date_appointment = date_appointment;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getTreatmentId() {
        return treatment_id;
    }

    public void setTreatmentId(int treatment_id) {
        this.treatment_id = treatment_id;
    }

    public int getVeterinaryId() {
        return veterinary_id;
    }

    public void setVeterinaryId(int veterinary_id) {
        this.veterinary_id = veterinary_id;
    }
}
