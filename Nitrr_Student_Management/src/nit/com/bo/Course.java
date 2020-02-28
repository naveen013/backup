package nit.com.bo;

public class Course {
     private long CourseId;
     private String CourseName;
     private long NoOfSeat;
     private long Duration;
     private String Eligibility;
     private String SubjName;
     private String AdmMode;
     private String CourseType;
     private String StudyMode;
     
     public Course(){
    	 
     }

	public long getCourseId() {
		return CourseId;
	}

	public void setCourseId(long courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public long getNoOfSeat() {
		return NoOfSeat;
	}

	public void setNoOfSeat(long noOfSeat) {
		NoOfSeat = noOfSeat;
	}

	public long getDuration() {
		return Duration;
	}

	public void setDuration(long duration) {
		Duration = duration;
	}

	public String getEligibility() {
		return Eligibility;
	}

	public void setEligibility(String eligibility) {
		Eligibility = eligibility;
	}

	public String getSubjName() {
		return SubjName;
	}

	public void setSubjName(String subjName) {
		SubjName = subjName;
	}

	public String getAdmMode() {
		return AdmMode;
	}

	public void setAdmMode(String admMode) {
		AdmMode = admMode;
	}

	public String getCourseType() {
		return CourseType;
	}

	public void setCourseType(String courseType) {
		CourseType = courseType;
	}

	public String getStudyMode() {
		return StudyMode;
	}

	public void setStudyMode(String studyMode) {
		StudyMode = studyMode;
	}
     
}
