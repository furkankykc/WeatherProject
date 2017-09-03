package com.H2H.juniorProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibatis.common.jdbc.ScriptRunner;

public class SqlRunner {

	public static void main(String[] args) throws ClassNotFoundException,
		SQLException {

		String roadRunnerPath = "h2hproject.sql";

		// Create MySql Connection
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306", "root", "fur3808535qQ@");
		Statement stmt = null;

		try {
			// Initialize object for ScripRunner
			ScriptRunner sr = new ScriptRunner(con, false, false);

			// Give the input file to Reader
			Reader reader = new BufferedReader(
                               new FileReader(roadRunnerPath));

			
			// Exctute script
			sr.runScript(reader);
		} catch (Exception e) {
			System.err.println("Failed to Execute" + ""
					+ " The error is " + e.getMessage());
		}
	}
}