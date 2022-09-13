package Model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    public static final String DB = "jdbc:sqlite:VeterinaryManagement.db";

    private static Connection connection;

    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB);
                if (connection != null) {
                    DatabaseMetaData metadata = connection.getMetaData();
                }
            } catch (SQLException exception) {
                System.err.println("Exception: " + exception.getMessage());
            }
        }
        return connection;
    }

    protected ResultSet getResultSet(String query) {
        Statement statement;
        ResultSet result_set = null;

        try {
            statement = (Statement) this.connection.createStatement();
            result_set = statement.executeQuery(query);
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }

        return result_set;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement statement;
        int lastId = -1;

        try {
            statement = (Statement) this.connection.createStatement();
            ResultSet result_set = statement.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (result_set.next()) {
                lastId = result_set.getInt("id");
            }
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
        return lastId;
    }

    public static void terminate() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException exception) {
            System.err.println("Exception: " + exception.getMessage());
        }
    }

    protected final boolean createTable() {
        try {
            PreparedStatement stmt;

            stmt = DAO.getConnection().prepareStatement(
            "CREATE TABLE IF NOT EXISTS client (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR," +
                    "document VARCHAR," +
                    "phone VARCHAR," +
                    "email VARCHAR," +
                    "zip_code VARCHAR," +
                    "street_number INT," +
                    "street_complement VARCHAR" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS animal (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR," +
                    "birthdate INTEGER," +
                    "sex VARCHAR," +
                    "specie_id INTEGER," +
                    "client_id INTEGER" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS medical_appointment (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "date_appointment TEXT," +
                    "history VARCHAR," +
                    "treatment_id INTEGER," +
                    "veterinary_id INTEGER" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS medical_exam (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "exam_description VARCHAR," +
                    "medical_appointment_id INTEGER" + "" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS specie (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR UNIQUE" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS treatment(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "start_date VARCHAR," +
                    "final_date VARCHAR," +
                    "animal_id INTEGER" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement(
                "CREATE TABLE IF NOT EXISTS veterinary (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR," +
                    "document VARCHAR," +
                    "phone VARCHAR," +
                    "email VARCHAR," +
                    "zip_code VARCHAR," +
                    "street_number INT," +
                    "street_complement VARCHAR," +
                    "crmv VARCHAR" +
                ");"
            );
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO specie (name) VALUES ('Cachorro')");
            executeUpdate(stmt);

            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO specie (name) VALUES ('Gato')");
            executeUpdate(stmt);

            return true;
        } catch (SQLException exception) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, exception);
        }

        return false;
    }
}
