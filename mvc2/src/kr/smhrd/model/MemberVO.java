package kr.smhrd.model;

public class MemberVO {
	// 회원 : 번호, 아이디, 비번, 이름, 전화번호, 이메일
	
	private int num;
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String email;
	
	// 디폴트 생성자를 명시적으로. (아래에서 생성자 추가를 하기 때문 / Spring에서도 써먹는다.)
	public MemberVO() { }

	// DB에서 작업할 때
	public MemberVO(int num, String id, String pass, String name, String tel, String email) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	
	// 회원가입용 - num은 시퀀스로 부여
	public MemberVO(String id, String pass, String name, String tel, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pass=" + pass + ", name=" + name + ", tel=" + tel + ", email="
				+ email + "]";
	}
	
	
	
	
}
