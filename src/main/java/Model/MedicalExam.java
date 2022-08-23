package Model;

public class MedicalExam {
    private int id;
    private String exam_description;

    public MedicalExam(int id, String exam_description) {
        this.id = id;
        this.exam_description = exam_description;
    }

    public int getId() {
        return id;
    }

    public String getExamDescription() {
        return exam_description;
    }

    public void setExamDescription(String exam_description) {
        this.exam_description = exam_description;
    }
}
