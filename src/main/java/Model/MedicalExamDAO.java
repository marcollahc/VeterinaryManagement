package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MedicalExamDAO {
    private List<MedicalExam> medical_exams = new ArrayList<MedicalExam>();
    private int medical_exam_id = 1;

    public List<MedicalExam> create(String exam_description, int medical_appointment_id) {
        MedicalExam medical_exam = new MedicalExam(medical_exam_id, exam_description, medical_appointment_id);
        this.medical_exams.add(medical_exam);
        medical_exam_id++;
        return this.medical_exams;
    }

    public List<MedicalExam> retrieveAll() {
        return this.medical_exams;
    }

    public List<MedicalExam> retrieveByID(int id) {
        return (List<MedicalExam>) this.medical_exams.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String exam_description, int medical_appointment_id) {
        int index = 0;

        for (MedicalExam medical_exam:this.medical_exams) {
            if (medical_exam.getId() == id) {
                MedicalExam medical_exam_update = this.medical_exams.get(index);
                medical_exam_update.setExamDescription(exam_description);
                medical_exam_update.setMedicalAppointmentId(medical_appointment_id);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (MedicalExam medical_exam:this.medical_exams) {
            if (medical_exam.getId() == id) {
                this.medical_exams.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
