/**
 * [Database for our ]
 *
 * @author Kevin Pena Alvarez
 * @version 0.1.0
 * @since 4/13/26
 **/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    // "jdbc:sqlite:" tells the JDBC which driver to use.
    //The path after it is the database file location
    private static final String DB_URL = "jdbc:sqlite:app.db";
    private Connection connection;

    //runs when Database object is created
    public Database() {
        try{
            // Opens (or creates) app.db in the project root
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Database Connected.");
            createTables(); //creates Schema on first run
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    // close() closes the database connection when done
    public  void close() {
        try {
            if ( connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e ) {
            System.err.println("Close failed" + e.getMessage());
        }
    }

    //creates three tables
    private void createTables() {
        // table for users: username and password
        String usersTable = """ 
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT ,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL
            );
            """;
        //tables for items
        String itemsTable = """
            CREATE TABLE IF NOT EXISTS items (
                id INTEGER PRIMARY KEY AUTOINCREMENT ,
                name TEXT NOT NULL ,
                done INTEGER NOT NULL DEFAULT 0 ,
                created TEXT DEFAULT (datetime('now'))
            );
            """;
        //table for categories
        String categoriesTable = """
           CREATE TABLE IF NOT EXISTS categories (
                id INTEGER PRIMARY KEY AUTOINCREMENT ,
                category_name TEXT NOT NULL
            );
            """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(usersTable);
            stmt.execute(itemsTable);
            stmt.execute(categoriesTable);
        } catch (SQLException e ) {
            System.err.println("Create tables failed " + e.getMessage());
        }
    }

    //create User
    public void createUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User added.");
        } catch (SQLException e) {
            System.err.println("insertUser failed: " + e.getMessage());
        }
    }

    //checks for login
    public boolean checkUser(String username, String password) {
        String sql = "Select * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); //this returns true if a match is found
        } catch (SQLException e) {
            System.err.println("checkUser failed: " + e.getMessage());
        }
        return false;
    }

    //CRUD operation read
    public List<String> getAllItems() {
        List<String> items = new ArrayList<>();
        String sql = "Select name from items";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                items.add(rs.getString("name"));
            }
        } catch (SQLException e ) {
            System.err.println("getAllItems failed " + e.getMessage());
        }
        return items;
    }

    //CRUD operation update
    public void markDone (int id) {
        String sql = "UPDATE items SET done = 1 WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("markDone failed: " + e.getMessage());
        }
    }

    //CRUD operation delete
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("deleteItem failed: " + e.getMessage());
        }
    }

    //CRUD operation insert
    public void insertItem (String name) {
        String sql = "INSERT INTO items (name) VALUES (?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name); //binds parameter 1 to 'name'
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("insertItem failed: " + e.getMessage());
        }
    }

    //helper method for tests
    public void clearItems() {
        String sql = "DELETE FROM items";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            stmt.executeUpdate("DELETE FROM sqlite_sequence WHERE name='items'");
        } catch (SQLException e) {
            System.err.println("clearItems failed: " + e.getMessage());
        }
    }

}
