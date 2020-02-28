package sis.com.bo;

public class Student {
	
	private long id;
	private String name;
	private String email;
	private long branchId;
	
	public Student(){
		
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getBrachId() {
		return branchId;
	}

	public void setBrachId(long branchId) {
		this.branchId = branchId;
	}

}
