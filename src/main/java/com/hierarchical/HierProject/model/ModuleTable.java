package com.hierarchical.HierProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="module_table")
public class ModuleTable {

	@Id
	private String module_UUID;
	private String module_name;
	private int module_id;
	private String organization_UUID;
	
	public String getModule_UUID() {
		return module_UUID;
	}
	public void setModule_UUID(String module_UUID) {
		this.module_UUID = module_UUID;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getOrganization_UUID() {
		return organization_UUID;
	}
	public void setOrganization_UUID(String organization_UUID) {
		this.organization_UUID = organization_UUID;
	}
}
