package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class EUserBean 
{
	private Integer userId;
	private String firstName;
	private String email;
	private String password;
	
	
	private MultipartFile profilePic;
	private String profilePicPath; 
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EUserBean [userId=" + userId + ", firstName=" + firstName + ", email=" + email + ", password="
				+ password + ", profilePic=" + profilePic + ", profilePicPath=" + profilePicPath + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
