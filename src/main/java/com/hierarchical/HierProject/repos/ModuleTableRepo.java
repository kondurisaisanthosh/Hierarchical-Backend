package com.hierarchical.HierProject.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.ModuleTable;

@Repository
public interface ModuleTableRepo extends JpaRepository<ModuleTable,String>{
	
	@Modifying
	@Query(value="INSERT INTO module_table(module_name) VALUES (?1)",nativeQuery=true)
	@Transactional
	public void addModule(String moduleName);
	
	@Query(value="SELECT * FROM module_table WHERE module_name=(?1)",nativeQuery=true)
	public ModuleTable getModule(String moduleName);
}
