package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.City;
import model.Team;
import utility.ConnectionManager;

public class TeamDAO
{
	public void createTeam(Team team) throws ClassNotFoundException, SQLException, IOException
	{
		ConnectionManager ob=new ConnectionManager();
		long id=team.getId();
		String name=team.getName();
		String coach=team.getCoach();
		String cap=team.getCaptain();
		City c=team.getCity();
		long idl=c.getCityid();
		System.out.println(idl);
		String sql="insert into team1(name,coach,home_city_id,captain,id) values(?,?,?,?,?)";
		PreparedStatement st=ob.getConnection().prepareStatement(sql);
		st.setLong(5,id);
		st.setString(1, name);
		st.setString(2, coach);
		st.setLong(3, idl);
		st.setString(4, cap);
		st.executeUpdate();
		System.out.println("Done");
		ob.getConnection().close();
	}
}
