package stu.hub.pojo;

public class User {

	private int sid;
	private String name;
	private String login_id;
	private String gender;
	private String course;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	private String institute;
	private int yearOfAdmission;
	
	
	public User(int id,String name, String uid, String gender, String email, String password, String contactNo,
			String address, String institute,String course, int yearOfAdmission) {
		super();
		this.sid = id;
		this.name = name;
		this.gender = gender;
		this.login_id = uid;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
		this.institute = institute;
		this.course=course;
		this.yearOfAdmission = yearOfAdmission;
	}

	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int sid,String nm,String e) {
		super();
		this.sid = sid;
		this.name=nm;
		this.login_id = e;
	}
	
	public User(String login,String email) {
		this.login_id=login;
		this.email= email;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}



	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course=course;
	}


	public int getYearOfAdmission() {
		return yearOfAdmission;
	}


	public void setYearOfAdmission(int yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}


	
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", login_id=" + login_id + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

}
