package entity;

import java.sql.Date;

public class PersonEntity {
	private String Cid; //客户身份证号
	private String Cname; //客户姓名
	private String Cphone;  //客户电话号码
	private String roomNo;  //客户电话号码
	private Date comedate;  //入住日期
	private String day; //入住时长
	private String deposit; //押金
	private String goodsprice; //货品价格
	private String catering; //餐饮消费
	private String laundry;//洗衣消费
	private String roomprice; //房间价格
	private String plus; //消费总和
	private String state; //客房状态
	private String staffNo; //负责员工号
	private String account; //是否结账
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getCid() {
		return Cid;
	}
	public void setCid(String cid) {
		Cid = cid;
	}
	public String getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(String goodsprice) {
		this.goodsprice = goodsprice;
	}
	public String getRoomprice() {
		return roomprice;
	}
	public void setRoomprice(String roomprice) {
		this.roomprice = roomprice;
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
	public Date getComedate() {
		return comedate;
	}
	public void setComedate(Date comedate) {
		this.comedate = comedate;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getCatering() {
		return catering;
	}
	public void setCatering(String catering) {
		this.catering = catering;
	}
	public String getLaundry() {
		return laundry;
	}
	public void setLaundry(String laundry) {
		this.laundry = laundry;
	}
	public String getPlus() {
		return plus;
	}
	public void setPlus(String plus) {
		this.plus = plus;
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