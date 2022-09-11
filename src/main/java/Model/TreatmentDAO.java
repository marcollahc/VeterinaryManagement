package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TreatmentDAO extends DAO {
    private static TreatmentDAO instance;

    private TreatmentDAO() {
        getConnection();
        createTable();
    }

    public static TreatmentDAO getInstance() {
        return ((instance == null) ? (instance = new TreatmentDAO()) : instance);
    }

    public Treatment create(String start_date, String final_date, int animal_id) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("INSERT INTO treatment (start_date, final_date, animal_id) VALUES (?, ?, ?)");
            statement.setString(1, start_date);
            statement.setString(2, final_date);
            statement.setInt(3, animal_id);
            executeUpdate(statement);
        } catch (SQLException exception) {
            Logger.getLogger(TreatmentDAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return this.retrieveByID(lastId("treatment", "id"));
    }

    public boolean isLastEmpty() {
        Treatment lastTreatment = this.retrieveByID(lastId("treatment", "id"));
        if (lastTreatment != null) {
            return lastTreatment.getStartDate().isBlank();
        }

        return false;
    }

    private Treatment buildObject(ResultSet result_set) {
        Treatment treatment = null;

        try {
            treatment = new Treatment(
                result_set.getInt("id"),
                result_set.getString("start_date"),
                result_set.getString("final_date"),
                result_set.getInt("animal_id")
            );
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return treatment;
    }

    public List retrieve(String query) {
        List<Treatment> treatments = new ArrayList();
        ResultSet result_set = getResultSet(query);

        try {
            while (result_set.next()) {
                treatments.add(buildObject(result_set));
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return treatments;
    }

    public List retrieveAll() {
        return this.retrieve("SELECT * FROM treatment");
    }

    public List retrieveLast() {
        return this.retrieve("SELECT * FROM treatment WHERE id = " + lastId("treatment", "id"));
    }

    public Treatment retrieveByID(int id) {
        List<Treatment> treatments = this.retrieve("SELECT * FROM treatment WHERE id = " + id);

        return (treatments.isEmpty() ? null : treatments.get(0));
    }

    public List retrieveByAnimalId(String id) {
        return this.retrieve("SELECT * FROM treatment WHERE animal_id = " + id);
    }

    public List retrieveByDate(String start_date, String final_date) {
        return this.retrieve("SELECT * FROM treatment WHERE start_date >= '" + start_date + "' AND final_date <= '" + final_date + "'");
    }

    public void update(Treatment treatment) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("UPDATE treatment SET start_date = ?, final_date = ?, animal_id = ? WHERE id = ?");
            statement.setString(1, treatment.getStartDate());
            statement.setString(2, treatment.getFinalDate());
            statement.setInt(3, treatment.getAnimalId());
            statement.setInt(4, treatment.getId());
            executeUpdate(statement);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void delete(Treatment treatment) {
        try {
            PreparedStatement statement;
            statement = DAO.getConnection().prepareStatement("DELETE FROM treatment WHERE id = ?");
            statement.setInt(1, treatment.getId());
            executeUpdate(statement);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }
}
