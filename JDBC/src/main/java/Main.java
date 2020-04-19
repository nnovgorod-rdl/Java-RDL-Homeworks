import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String USER = "SYSTEM";
    private static final String PASSWORD = "1";

    public static void main(String[] args) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("Oracle JDBC Driver Registered!");

        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            CreateTable startTables = new CreateTable(statement);
            //в классе CreateTable создаются таблицы и заполняются значениями
            startTables.createTable();
            startTables.insertData();

            //для каждой таски написан свой метод
            Tasks tasks = new Tasks(statement, connection);
            System.out.println("---------------Task1--------------------");
            tasks.task1("QA");
            System.out.println("---------------Task2--------------------");
            tasks.task2("QA");
            System.out.println("---------------Task3--------------------");
            tasks.task3(50000);
            System.out.println("---------------Task4--------------------");
            //если вводим руководителя филиала (юзеры с id 5,8,10,11) то выведется весь департамент, отсоритованный по ФИО
            //если обычного сотрудника - только его
            //если некорректные данные - будет сообщение что пользователя не существует
            tasks.task4("Sofia", "Lunkina", "Nikolaevna");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
