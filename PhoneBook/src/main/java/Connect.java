import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Connect {
        private final String HOST = "jdbc:mysql://localhost:3306/itproger";
        private final String USERNAME = "root";
        private final String PASSWORD = "12345";

        private Connection connection;

        public Connect() {
            try {
                connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
