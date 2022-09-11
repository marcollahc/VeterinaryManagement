package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicalAppointmentDAO extends DAO {
    private static MedicalAppointmentDAO instance;

    private MedicalAppointmentDAO() {
        getConnection();
        createTable();
    }

    public static MedicalAppointmentDAO getInstance() {
        return ((instance == null) ? (instance = new MedicalAppointmentDAO()) : instance);
    }

    public MedicalAppointment create(String date_appointment, String history, int treatment_id, int veterinary_id) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO medical_appointment (date_appointment, history, treatment_id, veterinary_id) VALUES (?, ?, ?, ?)");
            statement.setString(1, date_appointment);
            statement.setString(2, history);
            statement.setInt(3, treatment_id);
            statement.setInt(4, veterinary_id);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(MedicalAppointmentDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("medical_appointment", "id"));
    }

    public boolean isLastEmpty() {
        MedicalAppointment lastMedicalAppointment = this.retrieveByID(lastId("medical_appointment", "id"));
        if (lastMedicalAppointment != null) {
            return lastMedicalAppointment.getDateAppointment().isBlank();
        }

        return false;
    }

    private MedicalAppointment buildObject(ResultSet result_set) {
        MedicalAppointment medical_appointment = null;

        try {
            medical_appointment = new MedicalAppointment(
                result_set.getInt("id"),
                result_set.getString("date_appointment"),
                result_set.getString("history"),
                result_set.getInt("treatment_id"),
                result_set.getInt("veterinary_id")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return medical_appointment;
    }

    public List retrieve(String query) {
        List<MedicalAppointment> medical_appointments = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                medical_appointments.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return medical_appointments;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM medical_appointment");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM medical_appointment WHERE id = " + lastId("medical_appointment", "id"));
    }

    public MedicalAppointment retrieveByID(int id) {
        List<MedicalAppointment> medical_appointments = this.retrieve("SELECT * FROM medical_appointment WHERE id = " + id);

        return (medical_appointments.isEmpty() ? null : medical_appointments.get(0));
    }

    public List retrieveByTreatmentId(int id) {
        return this.retrieve("SELECT * FROM medical_appointment WHERE treatment_id = " + id);
    }

    public List retrieveByVeterinaryId(int id) {
        return this.retrieve("SELECT * FROM medical_appointment WHERE veterinary_id = " + id);
    }

    public void update(MedicalAppointment medical_appointment) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE medical_appointment SET date_appointment = ?, history = ?, treatment_id = ?, veterinary_id = ? WHERE id = ?");
            statement.setString(1, medical_appointment.getDateAppointment());
            statement.setString(2, medical_appointment.getHistory());
            statement.setInt(3, medical_appointment.getTreatmentId());
            statement.setInt(4, medical_appointment.getVeterinaryId());
            statement.setInt(5, medical_appointment.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(MedicalAppointment medical_appointment) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM medical_appointment WHERE id = ?");
            statement.setInt(1, medical_appointment.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
