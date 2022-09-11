package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalExamDAO extends DAO {
    private static MedicalExamDAO instance;

    private MedicalExamDAO() {
        getConnection();
        createTable();
    }

    public static MedicalExamDAO getInstance() {
        return ((instance == null) ? (instance = new MedicalExamDAO()) : instance);
    }

    public MedicalExam create(String exam_description, int medical_appointment_id) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO medical_exam (exam_description, medical_appointment_id) VALUES (?, ?)");
            statement.setString(1, exam_description);
            statement.setInt(2, medical_appointment_id);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(MedicalExamDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("medical_exam", "id"));
    }

    public boolean isLastEmpty() {
        MedicalExam lastMedicalExam = this.retrieveByID(lastId("medical_exam", "id"));
        if (lastMedicalExam != null) {
            return lastMedicalExam.getExamDescription().isBlank();
        }

        return false;
    }

    private MedicalExam buildObject(ResultSet result_set) {
        MedicalExam medical_exam = null;

        try {
            medical_exam = new MedicalExam(
                result_set.getInt("id"),
                result_set.getString("exam_description"),
                result_set.getInt("medical_appointment_id")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return medical_exam;
    }

    public List retrieve(String query) {
        List<MedicalExam> medical_exams = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                medical_exams.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return medical_exams;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM medical_exam");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM medical_exam WHERE id = " + lastId("medical_exam", "id"));
    }

    public MedicalExam retrieveByID(int id) {
        List<MedicalExam> medical_exams = this.retrieve("SELECT * FROM medical_exam WHERE id = " + id);

        return (medical_exams.isEmpty() ? null : medical_exams.get(0));
    }

    public List retrieveByMedicalAppointmentId(String id) {
        return this.retrieve("SELECT * FROM medical_exam WHERE medical_appointment_id = " + id);
    }

    public void update(MedicalExam medical_exam) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE medical_exam SET exam_description = ?, medical_appointment_id = ? WHERE id = ?");
            statement.setString(1, medical_exam.getExamDescription());
            statement.setInt(2, medical_exam.getMedicalAppointmentId());
            statement.setInt(3, medical_exam.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(MedicalExam medical_exam) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM medical_exam WHERE id = ?");
            statement.setInt(1, medical_exam.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
