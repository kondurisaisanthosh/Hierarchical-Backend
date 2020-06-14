package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization_user")
public class OrganizationUser {
	
	@Id
	private String org_user_UUID;
	private String org_user_id;
	private String user_UUID;
	private String org_UUID;
	public String getOrg_user_UUID() {
		return org_user_UUID;
	}
	public void setOrg_user_UUID(String org_user_UUID) {
		this.org_user_UUID = org_user_UUID;
	}
	public String getOrg_user_id() {
		return org_user_id;
	}
	public void setOrg_user_id(String org_user_id) {
		this.org_user_id = org_user_id;
	}
	public String getUser_UUID() {
		return user_UUID;
	}
	public void setUser_UUID(String user_UUID) {
		this.user_UUID = user_UUID;
	}
	public String getOrg_UUID() {
		return org_UUID;
	}
	public void setOrg_UUID(String org_UUID) {
		this.org_UUID = org_UUID;
	}
}
