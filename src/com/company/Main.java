package com.company;

import java.sql.*;

import java.sql.SQLException;

public class Main {




    public static Integer gamesPlayed() {
        Integer result = -1;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql:javasql1");
            PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM words_of_the_day WHERE (SELECT COUNT(*) FROM guesses WHERE guesses.day = words_of_the_day.day) > ?"
            );
            st.setInt(1,1);
            ResultSet rs =st.executeQuery();
            while (rs.next())
            {

                result = rs.getInt(1);
            }

            // with open(_)
            rs.close();
            st.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            System.exit(1);
        }
        return result;
    }
    public static void showStatistics(){
        System.out.println("STATISTICS");
        System.out.print("Played: ");
        System.out.println(gamesPlayed());
    }
    public static void main(String[] args) {
	showStatistics();
    }
}
