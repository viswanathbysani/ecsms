package com.ibm.ecs.promotion.promotionservice.model;

public class User {

	public User()
	{
		
	}
	
	   
    public String username;
	
	public String password;
	
	public String name;
	
	public String email;
	
	public String address;
	
	public boolean isMember;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", address=" + address + ", isMember=" + isMember + "]";
	}
	

}
