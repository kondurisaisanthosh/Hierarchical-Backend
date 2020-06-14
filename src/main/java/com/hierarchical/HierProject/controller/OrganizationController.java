package com.hierarchical.HierProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchical.HierProject.model.Organization;
import com.hierarchical.HierProject.repos.OrganizationRepo;

@RestController
@RequestMapping(value="/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationRepo organizationRepo;
	
	@PostMapping(value="/storeOrganization")
	public @ResponseBody String storeOrganization(@RequestParam String orgName) {
		organizationRepo.storeOrganization(orgName);
		return "organization stored";
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
