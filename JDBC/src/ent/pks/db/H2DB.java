package ent.pks.db;

import java.io.File;
import java.sql.*;

public class H2DB {
    final String EMPLOYEE_WHERE_EMP_NAME = "SELECT * FROM EMPLOYEE WHERE EMP_NAME = ?";
    static H2DB db;
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    final String SEP = File.pathSeparator;

    private H2DB() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./h2_db";
        final String USER = "ss";
        final String PASS = "";

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized H2DB getDb() {
        if (db == null) {
            db = new H2DB();
        }
        return db;
    }

    ResultSet simpleQuery(String query) throws SQLException {
        statement = db.connection.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    ResultSet queryFromEmployee(String employeeName) throws SQLException {
        if (employeeName == null) {
            return null;
        }

        ResultSet res;
        int employeeID = 0;
        int departmentID = 0;
        boolean isEmpLeader = false;

        String queryEmp = EMPLOYEE_WHERE_EMP_NAME;
        preparedStatement = db.connection.prepareStatement(queryEmp);
        preparedStatement.setString(1, employeeName.toUpperCase());
        res = preparedStatement.executeQuery();
        while (res.next()) {
            employeeID = res.getInt(1);
        }

        if (employeeID == 0) {
            //Нет такого работника
            return null;
        }

        //Тут уже можно напрямую запросами
        String queryDep = "SELECT * FROM DEPARTMENT WHERE EMP_ID = " + employeeID;
        preparedStatement = db.connection.prepareStatement(queryDep);
        res = preparedStatement.executeQuery();

        while (res.next()) {
            departmentID = res.getInt(1);
            isEmpLeader = true;
        }

        if (isEmpLeader) {
            String queryAllEmployeeOfDepartment = "SELECT * FROM EMPLOYEE WHERE DEP_ID = " + departmentID + " ORDER BY EMP_NAME";
            preparedStatement = db.connection.prepareStatement(queryAllEmployeeOfDepartment);
        } else {
            preparedStatement = db.connection.prepareStatement(queryEmp);
            preparedStatement.setString(1, employeeName.toUpperCase());
        }
        res = preparedStatement.executeQuery();
        return res;
    }


    ResultSet queryFromEmployeeWhereSalaryBiggerThan(String employeeName) throws SQLException {
        ResultSet res;
        double salary = 0;
        preparedStatement = db.connection.prepareStatement(EMPLOYEE_WHERE_EMP_NAME);
        preparedStatement.setString(1, employeeName.toUpperCase());
        res = preparedStatement.executeQuery();


        if (res != null) {
            while (res.next()) {
                salary = res.getDouble("EMP_SALARY");
            }
        }

        if (salary == 0) {
            return null;
        }

        preparedStatement = null;

//        String query = "SELECT EMPLOYEE.EMP_NAME, " +
//                "EMPLOYEE.EMP_SALARY, " +
//                "DEPARTMENT.DEP_NAME  " +
//                "FROM EMPLOYEE, DEPARTMENT " +
//                "WHERE EMPLOYEE.DEP_ID=DEPARTMENT.DEP_ID " +
//                "AND EMPLOYEE.EMP_SALARY > ?";
        String query = "SELECT EMPLOYEE.EMP_NAME, " +
                "EMPLOYEE.EMP_SALARY, " +
                "DEPARTMENT.DEP_NAME  " +
                "FROM EMPLOYEE " +
                "JOIN DEPARTMENT ON EMPLOYEE.DEP_ID=DEPARTMENT.DEP_ID " +
        "WHERE  EMPLOYEE.EMP_SALARY > ?";
        preparedStatement = db.connection.prepareStatement(query);
        preparedStatement.setDouble(1, salary);
        res = preparedStatement.executeQuery();
        return res;
    }

    ResultSet queryFromEmployeeWhereDepartmentSortingByName(String department) throws SQLException {
        ResultSet res;
        int departmentID = 0;
        String queryDepartment = "SELECT * FROM DEPARTMENT WHERE DEP_NAME = ?";
        preparedStatement = db.connection.prepareStatement(queryDepartment);
        preparedStatement.setString(1, department.toUpperCase());
        res = preparedStatement.executeQuery();


        if (res != null) {
            while (res.next()) {
                departmentID = res.getInt(1);
            }
        }

        if (departmentID == 0) {
            return null;
        }

        preparedStatement = null;

        String query = "SELECT * FROM EMPLOYEE WHERE DEP_ID = ? ORDER BY EMP_NAME";
        preparedStatement = db.connection.prepareStatement(query);
        preparedStatement.setInt(1, departmentID);
        res = preparedStatement.executeQuery();
        return res;
    }

    ResultSet queryFromEmployeeWhereDepartmentSortingBySalary(String department) throws SQLException {
        ResultSet res;
        int departmentID = 0;
        String queryDepartment = "SELECT * FROM DEPARTMENT WHERE DEP_NAME = ?";
        preparedStatement = db.connection.prepareStatement(queryDepartment);
        preparedStatement.setString(1, department.toUpperCase());
        res = preparedStatement.executeQuery();


        if (res != null) {
            res.next();
            departmentID = res.getInt(1);

        }

        if (departmentID == 0) {
            return null;
        }

        preparedStatement = null;

        String query = "SELECT * FROM EMPLOYEE WHERE DEP_ID = ? ORDER BY EMP_SALARY";
        preparedStatement = db.connection.prepareStatement(query);
        preparedStatement.setInt(1, departmentID);
        res = preparedStatement.executeQuery();
        return res;
    }

    void insert(String tableName, String insertData) throws SQLException {
        statement = db.connection.createStatement();
        statement.executeUpdate("INSERT INTO " + tableName + " VALUES " +
                "(" +
                insertData +
                ")");
    }

    void createTable(String tableName, String createQuery) throws SQLException {
        statement = db.connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName +
                "(" +
                createQuery +
                ")");
    }

    void alterTable(String tableName, String alterQuery) throws SQLException {
        statement = db.connection.createStatement();
        statement.executeUpdate("ALTER TABLE " + tableName + " " + alterQuery);
    }

    void updateDepartmentManager(String managerName, String department) throws SQLException {
        if (department == null) {
            //Остановим, если отдела нет
            return;
        }
        ResultSet res;
        int departmentManagerID = 0;
        String queryManager = "";
        if (managerName == null) {
            //ничего не делаем, потом просто запишем NULL
        } else {
            queryManager = EMPLOYEE_WHERE_EMP_NAME;
            preparedStatement = db.connection.prepareStatement(queryManager);
            preparedStatement.setString(1, managerName.toUpperCase());
            res = preparedStatement.executeQuery();
            while (res.next()) {
                departmentManagerID = res.getInt(1);
            }
        }

        if (departmentManagerID == 0) {
            System.out.println("Bad name");
            return;
        }

        String setManager = "UPDATE DEPARTMENT SET EMP_ID = ? WHERE DEP_NAME = ?";
        preparedStatement = db.connection.prepareStatement(setManager);
        preparedStatement.setInt(1, departmentManagerID);
        preparedStatement.setString(2, department);
        preparedStatement.execute();
    }

    void close() throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }
}
