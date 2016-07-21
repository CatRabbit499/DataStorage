package dataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CuttlefishSQL{
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/project_cuttlefish";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String MAX_POOL = "250";
	private static final boolean SSL_TOGGLE = true;
	private Connection connection;
	private Properties properties;
	
	private Properties getProperties() {
	    if (properties == null) {
	        properties = new Properties();
	        properties.setProperty("user", USERNAME);
	        properties.setProperty("password", PASSWORD);
	        properties.setProperty("MaxPooledStatements", MAX_POOL);
	        properties.setProperty("SSL", SSL_TOGGLE);
	    }
	    return properties;
	}

	public Connection connect(){
	    if (connection == null){
	        try{
	            Class.forName(DATABASE_DRIVER);
	            connection = DriverManager.getConnection(DATABASE_URL, getProperties());
	        }catch (SQLException | ClassNotFoundException e){
	            e.printStackTrace();
	        }
	    }
	    return connection;
	}
	
	public void disconnect() {
	    if (connection != null) {
	        try {
	            connection.close();
	            connection = null;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
