package ent.pks;

import ent.pks.db.DatabaseProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

public class SimpleJDBCTest {
    static DatabaseProvider databaseProvider = new DatabaseProvider();
    static File DBFile = new File("E:\\Git\\Java-RDL-Homeworks\\h2_db.mv.db");
    static File TraceFile = new File("E:\\Git\\Java-RDL-Homeworks\\h2_db.trace.db");

    @BeforeAll
    static void createDB() {
        databaseProvider.createDatabase();
    }

    @Test
    void isDBCreated() {
        Assertions.assertTrue(DBFile.exists());
    }

    @AfterAll
    static void deleteDBFiles() {
        if (DBFile.exists()) {
            DBFile.delete();
        }
        if (TraceFile.exists()) {
            TraceFile.delete();
        }
    }
}
