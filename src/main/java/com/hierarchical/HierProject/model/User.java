package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	
	@Id
    private String user_UUID;
    private String username;
    private String password;
    private int user_id;
	public String getUser_UUID() {
		return user_UUID;
	}
	public void setUser_UUID(String user_UUID) {
		this.user_UUID = user_UUID;
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
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
    
}
