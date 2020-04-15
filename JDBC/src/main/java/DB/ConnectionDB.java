package DB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {

    private final static String URL = "jdbc:mysql://localhost:3306/epam?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
    private final static String username = "root";
    private final static String password = "Terma137099";
    private final static String driver = "com.mysql.jdbc.Driver";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Не удалось найти драйвер для базы данных");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.out.println("Connection is failed");
            e.printStackTrace();
        }
        return connection;
    }
}