package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Connector {

	public static Object[][] connect(String database) throws SQLException {
		Object[][] data = new Object[1][2];
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"", "root", "AnubhavGupta");
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from TestData;");
		while (resultSet.next()) {
			data[0][0] = resultSet.getString("username");
			data[0][1] = resultSet.getString("password");
		}
		
		return data;

	}

}
