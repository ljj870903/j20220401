package dao;
//플젝
public class Board {

	private int free_num;		// 글 번호
	private int mem_num;		// 회원번호
	private int b_category;		// 카테고리
	private String b_title;		// 글 제목
	private String b_date;		// 작성일자
	private int b_view;			// 조회수
	private String b_content;	// 글 내용
	private String b_photo;		// 사진 path
	private int b_rc_cnt;		// 추천수
	private int ref;			// 답변글 끼리그룹
	private int re_step;		// ref내의 순서
	private int re_level;		// 들여쓰기
	//조회용 회원조인 --> buffer에는 넣어야함
	private String id;
	private int re_count;
	
	public int getRe_count() {
		return re_count;
	}
	public void setRe_count(int re_count) {
		this.re_count = re_count;
	}
	public int getFree_num() {
		return free_num;
	}
	public void setFree_num(int free_num) {
		this.free_num = free_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getB_category() {
		return b_category;
	}
	public void setB_category(int b_category) {
		this.b_category = b_category;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_view() {
		return b_view;
	}
	public void setB_view(int b_view) {
		this.b_view = b_view;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_photo() {
		return b_photo;
	}
	public void setB_photo(String b_photo) {
		this.b_photo = b_photo;
	}
	public int getB_rc_cnt() {
		return b_rc_cnt;
	}
	public void setB_rc_cnt(int b_rc_cnt) {
		this.b_rc_cnt = b_rc_cnt;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getRe_step() {
		return re_step;
	}
	public void setRe_step(int re_step) {
		this.re_step = re_step;
	}
	public int getRe_level() {
		return re_level;
	}
	public void setRe_level(int re_level) {
		this.re_level = re_level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	

	
	


}
