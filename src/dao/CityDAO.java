package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

public class CityDAO
{
	public City getCityByName(String name) throws SQLException, ClassNotFoundException, IOException
	{
		ConnectionManager ob=new ConnectionManager();
		Statement st=ob.getConnection().createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM CITY");
		City city=null;
				while(rs.next())
				{
					if((name.equals(rs.getString("city_NAME"))))
					{
						city=new City(rs.getLong("ID"),name);
						ob.getConnection().close();
					}
				}
 return city;
	}
	public void createCity(City c) throws ClassNotFoundException, SQLException, IOException
	{
		
		long id=c.getCityid();
		String name=c.getCityname();
		ConnectionManager ob=new ConnectionManager();
		String sql="insert into CITY(id,city_name) values(?,?)";
		PreparedStatement st=ob.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.setString(2, name);
		st.executeUpdate();
		System.out.println("Done");
		ob.getConnection().close();
	}
}

