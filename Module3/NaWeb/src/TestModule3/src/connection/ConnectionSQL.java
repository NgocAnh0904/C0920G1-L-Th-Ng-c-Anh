package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionSQL {
    private String jdbcURL = "jdbc:mysql://localhost:3306/Test_Module3?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NgocAnh0904";
    private static Connection connection;
    public ConnectionSQL() {
    }
    public Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
