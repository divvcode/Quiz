package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) throws SQLException {

	    Class.forName("com.mysql.jdbc.Driver");

	   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz", "root", "");

	    
	    Statement statement = connection.createStatement();

	
	    ResultSet resultSet = statement.executeQuery("SELECT * FROM questions");

	  
	    while (resultSet.next()) {

	      
	        String question = resultSet.getString("question");
	        String answer = resultSet.getString("answer");

	        System.out.println(question + " = " + answer);
	    }

	    connection.close();
	    statement.close();
	    resultSet.close();
	}
}