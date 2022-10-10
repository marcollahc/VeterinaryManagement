package Model;

public class MedicalExam {
    private int id;
    private String exam_description;
    private int medical_appointment_id;

    public MedicalExam(int id, String exam_description, int medical_appointment_id) {
        this.id = id;
        this.exam_description = exam_description;
        this.medical_appointment_id = medical_appointment_id;
    }

    public int getId() {
        return this.id;
    }

    public String getExamDescription() {
        return this.exam_description;
    }

    public void setExamDescription(String exam_description) {
        this.exam_description = exam_description;
    }

    public int getMedicalAppointmentId() {
        return this.medical_appointment_id;
    }

    public void setMedicalAppointmentId(int medical_appointment_id) {
        this.medical_appointment_id = medical_appointment_id;
    }
}
