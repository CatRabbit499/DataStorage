package dataStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CuttlefishSQL{
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	
	public static void loadDriver(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void dbConnect(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/project_cuttlefish?user=root&password=");
		}catch(SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
	public static void submitSQL(String input){
		try{
		    stmt = con.createStatement();
		    rs = stmt.executeQuery(input);
		    if(stmt.execute(input)){
		        rs = stmt.getResultSet();
		        printOutput(rs);
		    }
		    else{
		    	System.out.println("Unable to execute query ;-;");
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    if(rs != null){
		        try{
		            rs.close();
		        }catch(SQLException sqlEx){}
		        rs = null;
		    }
		    if(stmt != null){
		        try{
		            stmt.close();
		        } catch(SQLException sqlEx){}
		        stmt = null;
		    }
		}
	}

	private static void printOutput(ResultSet rs) throws SQLException{
		ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }
	}
}
