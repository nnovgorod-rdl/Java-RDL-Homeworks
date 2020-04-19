import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tasks {
    Statement statement = null;
    Connection connection = null;

    public Tasks(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
    }

    void task1(String departmentName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT e.* FROM DEPARTMENT d , EMPLOYEES e WHERE d.ID =" +
                " e.DEPARTMENT_ID AND d.NAME = '" + departmentName + "' ORDER BY e.SALARY");
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String patronymic = resultSet.getString(4);
            int salary = resultSet.getInt(5);
            int departmentId = resultSet.getInt(6);
            System.out.println(surname + " " + name + " " + patronymic + " | " + salary + " | " + departmentId);
        }
    }

    void task2(String departmentName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT e.*, d.name FROM DEPARTMENT d , EMPLOYEES e WHERE d.ID =" +
                " e.DEPARTMENT_ID AND d.NAME = '" + departmentName + "' ORDER BY e.surname, e.name, e.patronymic");
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String patronymic = resultSet.getString(4);
            int salary = resultSet.getInt(5);
            String nameOfDepartment = resultSet.getString(7);
            System.out.println(surname + " " + name + " " + patronymic + " | " + salary + " | " + nameOfDepartment);
        }
    }

    void task3(int sum) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT e.*, d.name FROM DEPARTMENT d , EMPLOYEES e WHERE d.ID =" +
                " e.DEPARTMENT_ID and e.salary > " + sum);
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String patronymic = resultSet.getString(4);
            int salary = resultSet.getInt(5);
            String nameOfDepartment = resultSet.getString(7);
            System.out.println(surname + " " + name + " " + patronymic + " | " + salary + " | " + nameOfDepartment);
        }
    }

    void task4(String name, String surname, String patronymic) throws SQLException {
        ResultSet getUserFromEmployeesTable = statement.executeQuery("select * from EMPLOYEES e WHERE e.name = '" + name +
                "' and e.SURNAME = '" + surname + "' and e.PATRONYMIC = '" + patronymic + "'");
        if (getUserFromEmployeesTable.next()) {
            Statement statement2 = connection.createStatement();
            int userId = getUserFromEmployeesTable.getInt(1);
            ResultSet checkThatUserIsBoss = statement2.executeQuery("SELECT * FROM DEPARTMENT d WHERE d.BOSS_ID =" + userId);
            if (checkThatUserIsBoss.next()) {
                checkThatUserIsBoss = statement2.executeQuery("SELECT d.NAME FROM DEPARTMENT d WHERE d.BOSS_ID = " + userId);
                if (checkThatUserIsBoss.next()) {
                    String departmentName = checkThatUserIsBoss.getString(1);
                    task2(checkThatUserIsBoss.getString(1));
                }
            } else {
                    String userName = getUserFromEmployeesTable.getString(2);
                    String userSurname = getUserFromEmployeesTable.getString(3);
                    String userPatronymic = getUserFromEmployeesTable.getString(4);
                    int userSalary = getUserFromEmployeesTable.getInt(5);
                    System.out.println(userSurname + " " + userName + " " + userPatronymic + " | " + userSalary);
                }
        } else {
            System.out.println("User does not exist in Employees table");
        }
    }
}
