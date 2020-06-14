package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_table")
public class Register {
	
	@Id
	private String registerUUID;
	private String email;
	private String phone;
	private String dob;
	private String userUUID;
	private int type;
	private int register_id;
	public String getRegisterUUID() {
		return registerUUID;
	}
	public void setRegisterUUID(String registerUUID) {
		this.registerUUID = registerUUID;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUserUUID() {
		return userUUID;
	}
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRegister_id() {
		return register_id;
	}
	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}

}
