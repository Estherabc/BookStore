package entity;

public class reserveEntity {
	private String Cid;
	private String Cname;
	private String Cphone;
	private String roomNo;
	private String comedate;
	private String day;
	private String state;
	private String staffNo;
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getCphone() {
		return Cphone;
	}
	public void setCphone(String cphone) {
		Cphone = cphone;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public String getComedate() {
		return comedate;
	}
	public void setComedate(String comedate) {
		this.comedate = comedate;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStaffNo() {
		return staffNo;
	}
	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

}
