package com.hierarchical.HierProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchical.HierProject.bean.OrganizationModuleBean;
import com.hierarchical.HierProject.model.ModuleTable;
import com.hierarchical.HierProject.model.Organization;
import com.hierarchical.HierProject.repos.ModuleTableRepo;
import com.hierarchical.HierProject.repos.OrganizationRepo;

@RestController
@RequestMapping(value="/module")
public class ModuleTableController {

	@Autowired
	ModuleTableRepo moduleTableRepo;
	
	@Autowired
	OrganizationRepo organizationRepo;

	
	@PostMapping(value="/addModule")
	public @ResponseBody String addModule(@RequestBody OrganizationModuleBean orgModule) {
		Organization organization=organizationRepo.getOgranization(orgModule.getOrganizationName());
		ModuleTable module=moduleTableRepo.getModule(orgModule.getModuleName(),organization.getOrganization_UUID());
		if(module!=null) {
			return "module already exists";
		}
		moduleTableRepo.addModule(orgModule.getModuleName(),organization.getOrganization_UUID());
		return "Module Stored";
	}
	
	@GetMapping(value="/getModules")
	public Iterable<ModuleTable> getModule(@RequestParam String orgName){
		Organization organization=organizationRepo.getOgranization(orgName);
		Iterable<ModuleTable> modules=moduleTableRepo.getModules(organization.getOrganization_UUID());
		return modules;
	}
	
	@GetMapping(value="/allModules")
	public @ResponseBody Iterable<ModuleTable> getAllModules(){
		return moduleTableRepo.findAll();
	}
}
