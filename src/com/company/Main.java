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




    public static void gamesPlayed() {

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql:carperson");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM People;");
            while (rs.next())
            {
                System.out.println("________________________");
                System.out.print("Name: " + rs.getString("name"));

                System.out.println(", Age: " + rs.getString("age"));
                System.out.println("________________________");



            }

                rs.close();
                st.close();
            }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }

    }
    public static void populate_table(){
//
//        Scanner user = new Scanner(System.in);
//        Scanner date = new Scanner(System.in);
//        Scanner ageof = new Scanner(System.in);
        try {
            String url = "jdbc:postgresql:carperson";
            String username = "justinashmore";
            String password = "001067347";
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO People" + " (name, age, favcar)" + " values (?,?,?)";

            PreparedStatement psmt = conn.prepareStatement(sql);

            Scanner uInput = new Scanner(System.in);
            System.out.print("Enter First Name : ");
            String nameof = uInput.nextLine();
            System.out.print("Enter Age : ");

            Integer age = uInput.nextInt();


            psmt.setString(1, nameof);
            psmt.setInt(2, age);



            psmt.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);

        }


    }

    public static void add_vehicle(){
        try {
            String url = "jdbc:postgresql:carperson";
            String username = "justinashmore";
            String password = "001067347";
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO VehicleOwns2 (name, make, model, year)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement psmt = conn.prepareStatement(sql);
            Scanner uInput = new Scanner(System.in);
            System.out.print("Enter First Name : ");
            String nameof = uInput.nextLine();
            System.out.print("Enter Make of Car : ");

            String make = uInput.nextLine();
            System.out.print("Enter Model of Car : ");
            String model = uInput.nextLine();
            System.out.print("Enter Year of Car : ");
            Integer year = uInput.nextInt();

            psmt.setString(1, nameof);
            psmt.setString(2, make);
            psmt.setString(3, model);
            psmt.setInt(4, year);
            psmt.executeUpdate();

    }catch(SQLException ex){
        ex.printStackTrace();
        System.exit(1);
    }




}

    public static void dvob(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql:carperson");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM vehicleowns2;");
            while (rs.next())
            {
                System.out.println("________________________");

                System.out.println("Name: " + rs.getString("name"));

                System.out.println(", Make: " + rs.getString("make"));
                System.out.println(", Model: " + rs.getString("model"));
                System.out.println(", Year: " + rs.getInt("year"));
                System.out.println("________________________");




            }

            rs.close();
            st.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public static void dcl(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql:carperson");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cars;");
            while (rs.next())
            {
                System.out.println("________________________");



                System.out.println(", Make: " + rs.getString("make"));
                System.out.println(", Model: " + rs.getString("model"));
                System.out.println(", Year: " + rs.getInt("year"));
                System.out.println("________________________");




            }

            rs.close();
            st.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }
    }


    public static void showStatistics(){
        Scanner s = new Scanner(System.in);
        int ch;
        do{
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
            ch = s.nextInt();
            switch(ch) {
                case 1:
                    populate_table();
                    break;
                case 2:
                    System.out.print("People added: ");

                    gamesPlayed();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    add_vehicle();
                    break;
                case 6:
                    dvob();
                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    dcl();
                    break;

            }

        }while(ch!=0);
    }

    public static void main(String[] args) {
//    populate_table(name, day, age);
	showStatistics();
    }
}
