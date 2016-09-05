package dataStorage;

import java.io.IOException;
import java.sql.SQLException;

public class DataStorage{
	public static void main(String[] args) throws IOException, SQLException{
		CuttlefishSQL.loadDriver();
		CuttlefishSQL.dbConnect();
		//DatabaseInterface.derp();
		CuttlefishSQL.submitSQL("truncate teacher_list");
		CuttlefishSQL.submitSQL("insert into teacher_list (ID, Name, Supervisor, Classes) VALUES (1, \"Teacher 1\", \"Supervisor 1\", \"Class 1~Class 2~Class 3~Class 4\")");
		CuttlefishSQL.submitSQL("insert into teacher_list (ID, Name, Supervisor, Classes) VALUES (2, \"Teacher 2\", \"Supervisor 1\", \"Class 5~Class 6~Class 7~Class 8\")");
		System.out.println(CuttlefishSQL.submitSQL("select * from teacher_list where name = 'Teacher 1'"));
	}
}