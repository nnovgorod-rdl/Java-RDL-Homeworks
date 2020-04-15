package ent.pks;

import ent.pks.db.DatabaseProvider;

import static java.lang.System.out;

public class MainJDBC {

    public static void main(String[] args) {
        DatabaseProvider databaseProvider = new DatabaseProvider();

        // DEPARTMENT ADVENTURE, ACTION MOVIE, COMEDY

        /* ACTORS
        BENEDICT CUMBERBATCH, DANIEL RADCLIFFE, JENSEN ACKLES,
        ROBERT DE NIRO, KEANU REEVES, EDDIE MURPHY,
        JACKIE CHAN, JIM CARREY, LEONARDO DICAPRIO,
        MEL GIBSON, VIN DIESEL, SYLVESTER STALLONE,
        JEAN-CLAUDE VAN DAMME, ARNOLD SCHWARZENEGGER, CHUCK NORRIS
         */

        /*
        Перед первым запуском раскомментировать создание БД
        Потом снова закомментировать
         */
//        databaseProvider.createDatabase();
        databaseProvider.printDepartmentSortingByName();
        databaseProvider.printDepartmentSortedByName("COMEDY");
        databaseProvider.printDepartmentSortedBySalary("ADVENTURe");
        databaseProvider.printListEmployeeWhereSalaryBiggerThan("LEONARDO DICAPRiO");
        //Установим начальников отделов, у ADVENTURE - нет начальника
        databaseProvider.setManagerDepartment("ARNOLD SCHWARZENEGGER", "ACTION MOVIE");
        databaseProvider.setManagerDepartment("JACKIE CHAN", "COMEDY");
        out.println("===");
        databaseProvider.print("LEONARDO DICAPRIO");
        out.println("===");
        databaseProvider.print("ARNOLD SCHWARZENEGGER");

        databaseProvider.close();
    }
}
