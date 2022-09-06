package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
}
