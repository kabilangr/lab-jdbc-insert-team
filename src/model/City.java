package model;


public class City
{
	long cityid;
	String cityname;
	public City(long cityid, String cityname) {
		this.cityid = cityid;
		this.cityname = cityname;
	}
	public long getCityid() {
		return cityid;
	}
	public void setCityid(long cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
}
