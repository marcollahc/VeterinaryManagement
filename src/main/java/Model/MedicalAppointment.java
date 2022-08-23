package Model;

public class MedicalAppointment {
    private int id;
    private String date_appointment;
    private String history;

    public MedicalAppointment(int id, String date_appointment, String history) {
        this.id = id;
        this.date_appointment = date_appointment;
        this.history = history;
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
}
