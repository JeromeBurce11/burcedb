/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burcedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class PersonalInformation extends Accounts {

    Scanner input = new Scanner(System.in);
    private String fname;
    private String lname;
    private int age;
    private int accNumber;
    private int id;
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/loginaccounts";
//    static final String USER = "root";
//    static final String PASS = "";
//    
//    public Connection connect() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public PersonalInformation() {
    }

    public PersonalInformation(int id, int accNumber, String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.accNumber = accNumber;
        this.id = id;
    }

    public PersonalInformation(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;

    }

    public PersonalInformation(int Id, int accNumber, String fname, String lname) {

        this.id = id;
        this.accNumber = accNumber;
        this.fname = fname;
        this.lname = lname;

    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d\t%d\t%s\t%s\t%d", this.id, this.accNumber, this.fname, this.lname, this.age);
    }
    
    public void personalInformation() {
        this.checkFname();
        this.checkLname();
        this.checkAge();
    }
     public void saveinfo() {
        String sql = "INSERT INTO personalinformation VALUES (id, AccoundId,'" + this.fname + "','" +this.lname + "','"+this.age+"')";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void checkAge() {

        String ageS;
        while (true) {

            try {
                while (true) {
                    System.out.println("age: ");
                    Scanner age = new Scanner(System.in);
                    ageS = age.nextLine();
                    int convert = Integer.parseInt(ageS);
                    if (convert == 0) {
                        System.out.println("months of age!");
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("invalid input!");
            }
        }
        this.age = Integer.parseInt(ageS);
    }

    public void checkFname() {
        String FName = null;

        while (true) {
            System.out.println("enter Firstname: ");
            Scanner firstname = new Scanner(System.in);
            try {
                FName = firstname.nextLine();
                Integer.parseInt(FName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;

            }

        }
        this.fname = FName;
    }

    public void checkLname() {
        String LName = null;
        while (true) {
            System.out.println("enter Lastname: ");
            Scanner lastname = new Scanner(System.in);
            try {
                LName = lastname.nextLine();
                Integer.parseInt(LName);
                System.out.println("try again! ");

            } catch (Exception e) {
                break;
            }
        }
        this.lname = LName;
    }

    public void addDataOnExistingAccountPInfo() {
        System.out.println("Account ID: ");
        int a = input.nextInt();

        
                this.checkFname();
                this.checkLname();
                this.checkAge();

        
     
      
    }
    
    
    


}
