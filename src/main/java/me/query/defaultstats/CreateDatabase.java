package me.query.defaultstats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XE"; // Connect to the existing CDB
        String username = "system";
        String password = "tiger";

        // SQL command to create a new pluggable database
        String createDatabaseSQL =
                "CREATE PLUGGABLE DATABASE mypdb " +
                        "ADMIN USER pdbadmin IDENTIFIED BY admin123 " +
                        "FILE_NAME_CONVERT = ('/opt/oracle/oradata/XEPDB1/', '/opt/oracle/oradata/mypdb/')";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement()) {

            // Execute the CREATE PLUGGABLE DATABASE command
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Database 'mypdb' created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


