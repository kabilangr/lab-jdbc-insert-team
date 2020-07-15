package controller;

import java.io.*;
import java.sql.*;
import model.*;
import dao.*;

public class Main{
	public static void main(String args[]) throws Exception, SQLException, IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(in.readLine());
		switch(x)
		{
		case 1:
		{
			System.out.println("Enter id and name:");
			long id=Long.parseLong(in.readLine());
			String name=in.readLine();
			City ob=new City(id,name);
			CityDAO ob1=new CityDAO();
			ob1.createCity(ob);
			break;
		}
		case 2:
		{
			System.out.println("Enter id,name,coach,captain,city name:");
			long id=Long.parseLong(in.readLine());
			String name=in.readLine();
			String coach=in.readLine();
			String cap=in.readLine();
			String cname=in.readLine();
			City ob=null;
			CityDAO ob1=new CityDAO();
             ob=ob1.getCityByName(cname);
			Team t=new Team(name,coach,cap,ob,id);
			TeamDAO obj=new TeamDAO();
			obj.createTeam(t);
			break;
		}
		default:
		{
			
		}
		}
	}
}
