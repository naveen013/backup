package stu.com.bo;

public class Course {
	
	private long id;
	private String courseName;
	private long hours;
	
	public Course(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}
	

}
