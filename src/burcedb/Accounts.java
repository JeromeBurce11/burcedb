/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burcedb;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Accounts {

    private String username;
    private String password;
    private int Id;

    Accounts() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Accounts(int Id, String username, String password) {
        this.Id = Id;
        this.username = username;
        this.password = password;
    }

    public Accounts(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return String.format("%d\t%s\t%s", this.Id, this.username, this.password);
    }

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/loginaccounts";
    static final String USER = "root";
    static final String PASS = "";
    Scanner input = new Scanner(System.in);

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createUserPass() {
//        String username;
        boolean status = true;
        while (status) {
            System.out.print("Username: ");
            try {
                username = input.next();
                if (isString(username) == true) {
                    System.out.println("Invalid input!");
                } else {
                    while (true) {
                        try {
                            System.out.print("Password: ");
                            password = input.next();
                            if (password.length() < 8) {
                                throw new Exception("Password must have 8 characters!");
                            } else {
                                while (true) {
                                    System.out.print("Confirm Password: ");
                                    String password1 = input.next();
                                    if (password.equals(password1)) {
                                        System.out.println(" password match!");
                                        
                                        status = false;
                                        break;

                                    } else {
                                        System.out.println(" Mismatch password!");
                                    }
                                }
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            } catch (Exception e) {
                break;
            }

        }
    }

    public boolean isString(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void save() {
        String sql = "INSERT INTO Accounts VALUES (id,'" + username + "','" + password + "')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM acc WHERE id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id) {
        System.out.print("Input username to update: ");
        String newuse = input.next();
        System.out.print("Input password to update: ");
        String pass = input.next();
        String sql = "UPDATE `acc` SET `username`='" + newuse + "',`password`='" + pass + "' WHERE id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
