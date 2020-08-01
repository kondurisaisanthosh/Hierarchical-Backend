package com.hierarchical.HierProject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchical.HierProject.exception.ApiRequestException;
import com.hierarchical.HierProject.model.Organization;
import com.hierarchical.HierProject.repos.ModuleTableRepo;
import com.hierarchical.HierProject.repos.OrganizationRepo;

@RestController
@RequestMapping(value="/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	@Autowired
	ModuleTableRepo moduleRepo;
	
	@PostMapping(value="/storeOrganization")
	public Iterable<Organization> storeOrganization(@RequestParam String orgName) {
		
		if(organizationRepo.checkOrg(orgName) ==1) {
			throw new ApiRequestException("Organization name exists");
		}
		
		organizationRepo.storeOrganization(orgName);
		return organizationRepo.findAll();
	}
	
	@PostMapping(value="deleteOrganization")
	public String deleteOrganization(@RequestParam String org_UUID) {
		System.out.println(org_UUID);
		int numberOfModules=moduleRepo.numberOfModules(org_UUID);
		if(numberOfModules>=0) {
			moduleRepo.deleteAllModules(org_UUID);
		}
		organizationRepo.deleteOrganization(org_UUID);
		return "oraganization deleted";
	}
	
	
	@GetMapping(value="/getOrganization")
	public @ResponseBody Organization getOgranization(@RequestParam String orgName) {
		Organization organization=new Organization();
		try {
			organization=organizationRepo.getOgranization(orgName);
			System.out.println(organization.getOrganization_name());
		}catch(NullPointerException e) {
			System.out.println(orgName+" not found");
		}
		return organization;

	}
	
	@GetMapping(value="/allOrganizations")
	public Iterable<Organization> gettingAllOrganizations(){
		return organizationRepo.findAll();
	}
	
}
