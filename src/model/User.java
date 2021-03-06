package model;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 2222L;
	
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private String email;
	private String phone;
	
	public User() {}

	public User(String userId, String userPwd, String userName, int age, String email, String phone) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return this.userId + ", " + this.userPwd + ", " + 
				this.userName + ", " + this.age + ", " + 
				this.email + ", " + this.phone;
	}
}






