package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization_table")
public class Organization {

	@Id
	private String organization_UUID;
	private int organization_Id;
	private String organization_name;
	public String getOrganization_UUID() {
		return organization_UUID;
	}
	public void setOrganization_UUID(String organization_UUID) {
		this.organization_UUID = organization_UUID;
	}
	public int getOrganization_Id() {
		return organization_Id;
	}
	public void setOrganization_Id(int organization_Id) {
		this.organization_Id = organization_Id;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

}
