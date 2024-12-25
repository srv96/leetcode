package me.query.defaultstats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowDataBase {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/XE"; // Update the URL if necessary
        String username = "system";
        String password = "tiger";

        String query = "SELECT PDB_ID, PDB_NAME, STATUS FROM DBA_PDBS"; // Use DBA_PDBS to get all PDBs
//        String query = "SELECT pdb_name, status FROM dba_pdbs WHERE pdb_name = 'LCDB'"; // Use DBA_PDBS to get all PDBs

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Available Pluggable Databases in Oracle:");
            System.out.println("-----------------------------------");

            while (rs.next()) {
                String pdbId = rs.getString("PDB_ID");
                String pdbName = rs.getString("PDB_NAME");
                String status = rs.getString("STATUS");
                System.out.printf("PDB ID: %s | PDB Name: %s | Status: %s%n", pdbId, pdbName, status);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
