package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="org_mod_table")
public class OrganizationModule {

	@Id
	private String org_mod_UUID;
	private String org_id;
	private String mod_id;
	private int org_mod_id;
	public String getOrg_mod_UUID() {
		return org_mod_UUID;
	}
	public void setOrg_mod_UUID(String org_mod_UUID) {
		this.org_mod_UUID = org_mod_UUID;
	}
	public String getOrg_id() {
		return org_id;
	}
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}
	public String getMod_id() {
		return mod_id;
	}
	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}
	public int getOrg_mod_id() {
		return org_mod_id;
	}
	public void setOrg_mod_id(int org_mod_id) {
		this.org_mod_id = org_mod_id;
	}
}
