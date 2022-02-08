package com.company;

import java.sql.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    String name;
    Date day;
    int age;

    Main(String name, Date day, int age) {
        this.name = name;
        this.day = day;
        this.age = age;
    }




    public static String gamesPlayed() {
        String result = "";
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql:carperson");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM People;");
            while (rs.next())
            {
                System.out.print("Name: " + rs.getString("name"));
                System.out.print(", Date: " + rs.getString("day"));
                System.out.println(", Age: " + rs.getString("age"));

            }
                result = rs.getString("name");
                rs.close();
                st.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }
        return result;
    }
    public static void populate_table(String name, Date day, int age){
//        Connection conn = null;
//
//        Scanner user = new Scanner(System.in);
//        Scanner date = new Scanner(System.in);
//        Scanner ageof = new Scanner(System.in);
        try {

            String sql = "INSERT INTO CUSTOMERS" + " (customerID, firstname, lastname, age)" + " values (?,?,?,?)";

            PreparedStatement psmt = con.prepareStatement(sql);

            Scanner uInput = new Scanner(System.in);
            String fn = uInput.nextLine();
            String ln = uInput.nextLine();
            Integer cID = uInput.nextInt();
            Integer age = uInput.nextInt();

            psmt.setInt(1,cID);
            psmt.setString(2,fn);
            psmt.setString(3,ln);
            psmt.setInt(4,age);

            psmt.executeUpdate();
            return confirm;
        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }
        return confirm;

    }

}
    public static void showStatistics(){
        System.out.println("Car LOT");
        System.out.println("1.Add Person");
        System.out.println("2.Display Person");
        System.out.println("3.Remove Person");
        System.out.println("4.Update Person");
        System.out.println("5.Add Vehicle Owned By");
        System.out.println("6.Display Vehicle Owned By");
        System.out.println("7.Remove Vehicle Owned By");
        System.out.println("8.Update Vehicle Owned By");
        System.out.println("9.Display Vehicles");

        System.out.print("People added: ");

        System.out.println(gamesPlayed());

    }
    public static void main(String[] args) {
	showStatistics();
    }
}
