package com.hierarchical.HierProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hierarchical.HierProject.model.ModuleTable;
import com.hierarchical.HierProject.model.OrganizationModule;
import com.hierarchical.HierProject.repos.ModuleTableRepo;

@RestController
@RequestMapping(value="/module")
public class ModuleTableController {

	@Autowired
	ModuleTableRepo moduleTableRepo;
	
	@PostMapping(value="/addModule")
	public @ResponseBody String addModule(@RequestBody OrganizationModule moduleName) {
//		moduleTableRepo.addModule(moduleName);
		return "Module Stored";
	}
	
	@GetMapping(value="/getModule")
	public  @ResponseBody ModuleTable getModule(@RequestParam String moduleName){
		ModuleTable module=moduleTableRepo.getModule(moduleName);
		return module;
	}
	
	@GetMapping(value="/allModules")
	public @ResponseBody Iterable<ModuleTable> getAllModules(){
		return moduleTableRepo.findAll();
	}
}
