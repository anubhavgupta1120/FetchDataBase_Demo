package Resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class JDBC_Connector {

	public static Object[][] connect(String database) throws SQLException {
		Object[][] data;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "", "root",
				"AnubhavGupta");
		Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// always
																													// add
																													// these
																													// arguments
		ResultSet resultSet = statement.executeQuery("select * from TestData;");
		int colCount = resultSet.getMetaData().getColumnCount(); // To get the total count of coloumn
		resultSet.last(); // To move to the last row
		int rowCount = resultSet.getRow(); // get the index of last row so it will become eventually give the total no.
											// of rows
		resultSet.beforeFirst(); // again move back to first row
		data = new Object[rowCount][colCount];
		int i = 0;
		while (resultSet.next()) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = resultSet.getString(j + 1);
			}
			i++;
		}
		con.close();
		System.out.println(Arrays.deepToString(data));
		return data;

	}

}
