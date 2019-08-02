package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = new ConnectionFactory();

	private ConnectionFactory() {
		super();
	}

	public static synchronized ConnectionFactory getInstance() {
		if (cf == null) {
			cf = new ConnectionFactory();
		}
		return cf;
	}

	public Connection getConnection() {
		System.out.println("! Connecting to Database");

		Connection conn = null;

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties prop = new Properties();

		try {
			String cp = "database.properties";
			InputStream stream = loader.getResourceAsStream(cp);
			prop.load(stream);
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("Earl"), prop.getProperty("past"),
					prop.getProperty("time"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Problems... Connection problems...");
			e.printStackTrace();
		}

		return conn;

	}

}
