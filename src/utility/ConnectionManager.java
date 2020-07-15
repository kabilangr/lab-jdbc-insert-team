package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionManager
{
	public Connection getConnection() throws SQLException, ClassNotFoundException, IOException
	{
		Properties pro=null;
		pro=loadPropertiesFile();
		final String driver=pro.getProperty("driver");
		final String url=pro.getProperty("url");
		final String name=pro.getProperty("username");
		final String pass=pro.getProperty("password");
		Class.forName(driver);
		Connection ob=null;
		ob=DriverManager.getConnection(url,name,pass);
		if(ob!=null)
			System.out.println("Established");
		return ob;
	}
	public static Properties loadPropertiesFile() throws IOException
	{
		Properties pro=new Properties();
		InputStream in=ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		pro.load(in);
		in.close();
		return pro;
	}
}
