package nit.com.bo;

public class House {
	
	private String name;
	private String location;
	private String category;
    private long bedroom;
    private String email;
    private long mobile;
    private String imgName;
    public House(){
    	
    }

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getBedroom() {
		return bedroom;
	}

	public void setBedroom(long bedroom) {
		this.bedroom = bedroom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
    
}
