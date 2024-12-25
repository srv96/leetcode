package me.query.defaultstats;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FetchTableData {

    public static void main(String[] args) {
        // JDBC URL, username, and password for the database connection
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521/lcdb";
        String username = "system";  // Replace with your database username
        String password = "tiger";  // Replace with your database password

        // SQL query to select all records from the employee table
        String query = "SELECT * FROM employee";

        // Call the method to fetch data from the employee table
        fetchData(jdbcUrl, username, password, query);
    }

    public static void fetchData(String jdbcUrl, String username, String password, String query) {
        // 1. Establish the database connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // 2. Create a Statement object to execute the query
            try (Statement statement = connection.createStatement()) {
                // 3. Execute the query and get the result set
                ResultSet resultSet = statement.executeQuery(query);

                // 4. Process the result set
                while (resultSet.next()) {
                    // Assuming the employee table has columns: id, salary
                    int id = resultSet.getInt("id");
                    int salary = resultSet.getInt("salary");

                    // Print the data from the employee table
                    System.out.println("ID: " + id + ", Salary: " + salary);
                }
            } catch (SQLException e) {
                System.out.println("Error executing the query: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
