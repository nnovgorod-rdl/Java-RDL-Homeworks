package ent.pks.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

public class DatabaseProvider {
    private H2DB h2DB;

    public void printDepartmentSortingByName() {
        h2DB = H2DB.getDb();

        ResultSet res;
        try {
            res = h2DB.simpleQuery("SELECT * FROM DEPARTMENT ORDER BY DEP_NAME");
            while (res.next()) {
                String name = res.getString("DEP_NAME");
                out.printf("%s%n", name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println();
    }

    public void printListEmployeeWhereSalaryBiggerThan(String empName) {
        h2DB = H2DB.getDb();

        ResultSet res;
        try {
            res = h2DB.queryFromEmployeeWhereSalaryBiggerThan(empName);
            if (res == null) {
                printBanName();
            } else {
                while (res.next()) {
                    String a = res.getString(1);
                    String b = res.getString(2);
                    String c = res.getString(3);
                    out.printf("%s, %s, %s%n", a, b, c);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println();
    }

    public void printDepartmentSortedByName(String dep) {
        h2DB = H2DB.getDb();

        ResultSet res;
        try {
            res = h2DB.queryFromEmployeeWhereDepartmentSortingByName(dep);
            if (res == null) {
                printBanName();
            } else {
                while (res.next()) {
                    String name = res.getString("EMP_NAME");
                    String salary = res.getString(("EMP_SALARY"));
                    out.printf("%s, %S%n", name, salary);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println();
    }

    public void printBanName() {
        out.println("Bad name");
    }

    public void print(String employee) {
        h2DB = H2DB.getDb();
        ResultSet res;

        try {
            res = h2DB.queryFromEmployee(employee);
            if (res == null) {
                printBanName();
            } else {
                while (res.next()) {
                    String a = res.getString(2);
                    String b = res.getString(4);
                    out.printf("%s, %s%n", a, b);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printDepartmentSortedBySalary(String dep) {
        h2DB = H2DB.getDb();

        ResultSet res;
        try {
            res = h2DB.queryFromEmployeeWhereDepartmentSortingBySalary(dep);
            while (res.next()) {
                String name = res.getString("EMP_NAME");
                String salary = res.getString(("EMP_SALARY"));
                out.printf("%s, %S%n", name, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println();
    }

    public void close() {
        h2DB = H2DB.getDb();
        try {
            h2DB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setManagerDepartment(String manager, String department) {
        h2DB = H2DB.getDb();
        try {
            h2DB.updateDepartmentManager(manager, department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDatabase() {
        h2DB = H2DB.getDb();
        try {
            h2DB.createTable("DEPARTMENT",
                    "DEP_ID INT NOT NULL," +
                            "DEP_NAME VARCHAR(60) NOT NULL," +
                            "CONSTRAINT DEPARTMENT_PKEY PRIMARY KEY (DEP_ID)");

            h2DB.insert("DEPARTMENT", "1, 'ADVENTURE'");
            h2DB.insert("DEPARTMENT", "2, 'ACTION MOVIE'");
            h2DB.insert("DEPARTMENT", "3, 'COMEDY'");

            h2DB.createTable("EMPLOYEE",
                    "EMP_ID INT NOT NULL," +
                            "EMP_NAME VARCHAR(255) NOT NULL," +
                            "DEP_ID INT NOT NULL," +
                            "EMP_SALARY DOUBLE NOT NULL," +
                            "CONSTRAINT EMPLOYEE_PKEY PRIMARY KEY (EMP_ID)," +
                            "CONSTRAINT EMPLOYEE_FKEY FOREIGN KEY (DEP_ID) REFERENCES DEPARTMENT(DEP_ID)");

            h2DB.insert("EMPLOYEE", "1, 'BENEDICT CUMBERBATCH', 1, 1300");
            h2DB.insert("EMPLOYEE", "2, 'DANIEL RADCLIFFE', 1, 1500");
            h2DB.insert("EMPLOYEE", "6, 'JENSEN ACKLES', 1, 1000");
            h2DB.insert("EMPLOYEE", "9, 'ROBERT DE NIRO', 1, 1700");
            h2DB.insert("EMPLOYEE", "12, 'KEANU REEVES', 1, 1800");


            h2DB.insert("EMPLOYEE", "7, 'EDDIE MURPHY', 3, 1300");
            h2DB.insert("EMPLOYEE", "8, 'JACKIE CHAN', 3, 2100");
            h2DB.insert("EMPLOYEE", "4, 'JIM CARREY', 3, 2000");
            h2DB.insert("EMPLOYEE", "3, 'LEONARDO DICAPRIO', 3, 1600");
            h2DB.insert("EMPLOYEE", "11, 'MEL GIBSON', 3, 2000");

            h2DB.insert("EMPLOYEE", "5, 'VIN DIESEL', 2, 1800");
            h2DB.insert("EMPLOYEE", "13, 'SYLVESTER STALLONE', 2, 1400");
            h2DB.insert("EMPLOYEE", "14, 'JEAN-CLAUDE VAN DAMME', 2, 1300");
            h2DB.insert("EMPLOYEE", "15, 'ARNOLD SCHWARZENEGGER', 2, 2200");
            h2DB.insert("EMPLOYEE", "10, 'CHUCK NORRIS', 2, 1600");

            h2DB.alterTable("DEPARTMENT", "ADD COLUMN EMP_ID INT");
            h2DB.alterTable("DEPARTMENT", "ADD CONSTRAINT DEPARTMENT_FKEY " +
                    "FOREIGN KEY (EMP_ID) REFERENCES EMPLOYEE(EMP_ID)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
