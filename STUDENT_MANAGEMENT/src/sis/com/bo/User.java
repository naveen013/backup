package sis.com.bo;

public class User {
	private long id;
	private String name; 
	private String loginId;
	private String loginPassword;
	private String role;

public User() {
}

public User(long id, String name, String loginId, String loginPassword, String role) {
	super();
	this.id = id;
	this.name = name;
	this.loginId = loginId;
	this.loginPassword = loginPassword;
	this.role = role;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getLoginId() {
	return loginId;
}

public void setLoginId(String loginId) {
	this.loginId = loginId;
}

public String getLoginPassword() {
	return loginPassword;
}

public void setLoginPassword(String loginPassword) {
	this.loginPassword = loginPassword;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

}
