package entity;

import java.sql.Date;

public class PersonEntity {
	private String Cid; //�ͻ����֤��
	private String Cname; //�ͻ�����
	private String Cphone;  //�ͻ��绰����
	private String roomNo;  //�ͻ��绰����
	private Date comedate;  //��ס����
	private String day; //��סʱ��
	private String deposit; //Ѻ��
	private String goodsprice; //��Ʒ�۸�
	private String catering; //��������
	private String laundry;//ϴ������
	private String roomprice; //����۸�
	private String plus; //�����ܺ�
	private String state; //�ͷ�״̬
	private String staffNo; //����Ա����
	private String account; //�Ƿ����
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