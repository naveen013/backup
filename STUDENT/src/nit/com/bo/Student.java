package nit.com.bo;

public class Student {
	private long rollno;
	private String name;
	private long enrollmentno;
	private long sem;
	private String course;
	private String branch;
	private String email;
	
   public Student(){
		
		
		
	}

	public long getRollno() {
		return rollno;
	}

	public void setRollno(long rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getEnrollmentno() {
		return enrollmentno;
	}

	public void setEnrollmentno(long enrollmentno) {
		this.enrollmentno = enrollmentno;
	}

	public long getSem() {
		return sem;
	}

	public void setSem(long sem) {
		this.sem = sem;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
