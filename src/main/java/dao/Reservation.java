package dao;

public class Reservation {
	
	private int res_num; 			//예약번호
	private int mem_num;			//예약요청회원번호	
	private int pet_num;			//펫번호
	private int ps_num;				//펫시터 회원번호
	private String res_date;		//예약글작성일자
	private String res_status;		//예약상태
	private String sit_date;		//돌봄진행날짜
	private String sit_start;		//방문시작시간
	private String sit_end;			//방문종료시간
	private String request;			//요청사항
	private String name;			//회원 이름
	private String address;			//회원 주소
	private String res_st;			//코드 예약상태
	private int count;				//펫 총마리
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getRes_st() {
		return res_st;
	}
	public void setRes_st(String res_st) {
		this.res_st = res_st;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getPet_num() {
		return pet_num;
	}
	public void setPet_num(int pet_num) {
		this.pet_num = pet_num;
	}
	public int getPs_num() {
		return ps_num;
	}
	public void setPs_num(int ps_num) {
		this.ps_num = ps_num;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public String getRes_status() {
		return res_status;
	}
	public void setRes_status(String res_status) {
		this.res_status = res_status;
	}
	public String getSit_date() {
		return sit_date;
	}
	public void setSit_date(String sit_date) {
		this.sit_date = sit_date;
	}
	public String getSit_start() {
		return sit_start;
	}
	public void setSit_start(String sit_start) {
		this.sit_start = sit_start;
	}
	public String getSit_end() {
		return sit_end;
	}
	public void setSit_end(String sit_end) {
		this.sit_end = sit_end;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	
	

}
