package ks;

public class bean {
	private String username;
	private String userpwd;
	private String sex;
	private String blood;
	private String place;
	private String[] hobby=null;
	public String getusername(){return username;}
	public void setusername(String username){this.username=username;}
	public String getuserpwd(){return userpwd;}
	public void setuserpwd(String userpwd){this.userpwd=userpwd;}
	public String getsex(){return sex;}
	public void setsex(String sex){this.sex=sex;}
	public String getblood(){return blood;}
	public void setblood(String blood){this.blood=blood;}
	public String getplace(){return place;}
	public void setplace(String place){this.place=place;}
	public String[] gethobby(){return hobby;}
	public void sethobby(String[] hobby){this.hobby=hobby;}
}
