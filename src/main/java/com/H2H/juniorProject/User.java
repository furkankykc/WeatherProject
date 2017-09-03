package com.H2H.juniorProject;

public class User {

	private int id;
	private String username;
	private String password;
	private Boolean isAdmin = false;
	public User(){
	}
	public User(String username,String password,Boolean isAdmin){
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	public User(int id,String username,String password,Boolean isAdmin){
		this(username, password, isAdmin);
		this.id = id;
	}
	public User(String username,String password){
		this(username, password,false);
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
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
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

	
	
}
