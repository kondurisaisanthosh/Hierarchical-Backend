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
import com.hierarchical.HierProject.exception.ApiRequestException;
import com.hierarchical.HierProject.model.ModuleTable;
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
		ModuleTable module=moduleTableRepo.getModule(orgModule.getModuleName(),orgModule.getOrganizationUUID());
		if(module!=null) {
			throw new ApiRequestException("module already exists");
		}
		moduleTableRepo.addModule(orgModule.getModuleName(),orgModule.getOrganizationUUID());
		return "Module Stored";
	}
	
	
	
	@GetMapping(value="/getModules")
	public Iterable<ModuleTable> getModule(@RequestParam String orgUUID){
		Iterable<ModuleTable> modules=moduleTableRepo.getModules(orgUUID);
		return modules;
	}
	
	@GetMapping(value="/allModules")
	public @ResponseBody Iterable<ModuleTable> getAllModules(){
		return moduleTableRepo.findAll();
	}
}
