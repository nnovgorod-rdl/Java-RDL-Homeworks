import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    Statement statement = null;

    CreateTable(Statement statement) {
        this.statement = statement;
    }

    void createTable() throws SQLException {
        try {
            String SQL = "create table department (\n" +
                    "id number not null,\n" +
                    "name varchar(200) not null,\n" +
                    "boss_id number,\n" +
                    "primary key (id))";
            statement.executeUpdate(SQL);
            System.out.println("Table department created");
            SQL = "create table employees (\n" +
                    "id number not null,\n" +
                    "name varchar(200) not null,\n" +
                    "surname varchar(200) not null,\n" +
                    "patronymic varchar(200),\n" +
                    "salary number,\n" +
                    "department_id number not null,\n" +
                    "primary key(id),\n" +
                    "constraint fkDepartment foreign key (department_id)\n" +
                    "references department(id))";
            statement.executeUpdate(SQL);
            System.out.println("Table employees created");
            SQL = "alter table department\n" +
                    "add constraint fkEmployee foreign key (boss_id)\n" +
                    "references employees(id)";
            statement.executeUpdate(SQL);
            System.out.println("The tables is interconnected.");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    void insertData() throws SQLException {
        statement.execute("insert into department (id,name) values (1,'Business Analyses')");
        statement.execute("insert into department (id,name) values (2,'Development')");
        statement.execute("insert into department (id,name) values (3,'QA')");
        statement.execute("insert into department (id,name) values (4,'Test Automation')");

        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(1,'Paramonov','Maksim',null,25000,4)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(2,'Cherenkov','Vadim','Artemovich',54000,4)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(3,'Chernous','Evgen','Evgenich',80000,3)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(4,'Romanov','Nikolay','Petrovich',30000,4)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(5,'Streltsov','Danila','Andreich',100000,3)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(6,'Zotova','Polina',null,15000,2)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(7,'Somov','Roman','Vladimirovich',40000,3)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(8,'Leshikova','Elvira','Petrovna',65000,4)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(9,'Koshurinova','Svetlana','Igorevna',45000,3)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(10,'Lunkina','Sofia','Nikolaevna',29000,2)");
        statement.execute("insert into employees (id,surname,name,patronymic,salary,department_id) values(11,'Ruvniak','Lilia','Anatolievna',53000,1)");

        statement.executeUpdate("update department set boss_id = 11 where id = 1");
        statement.executeUpdate("update department set boss_id = 10 where id = 2");
        statement.executeUpdate("update department set boss_id = 5 where id = 3");
        statement.executeUpdate("update department set boss_id = 8 where id = 4");
    }

}