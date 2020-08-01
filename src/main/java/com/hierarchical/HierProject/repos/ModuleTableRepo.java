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
	@Query(value="INSERT INTO module_table(module_name,organization_UUID)VALUES(?1,?2)",nativeQuery=true)
	@Transactional
	public void addModule(String moduleName,String organization_UUID);
	
	@Query(value="SELECT * FROM module_table WHERE module_name=(?1) and organization_UUID=(?2)",nativeQuery=true)
	public ModuleTable getModule(String moduleName,String organization_UUID);
	
	
	@Query(value="SELECT * FROM module_table WHERE organization_UUID=(?1)",nativeQuery=true)
	public Iterable<ModuleTable> getModules(String organization_UUID);
	
	
	@Modifying
	@Query(value="delete FROM module_table where organization_UUID=(?1)",nativeQuery=true)
	@Transactional
	public void deleteAllModules(String organization_UUID);
	
	
	@Query(value="select count(1) from module_table where organization_UUID=(?1)",nativeQuery=true)
	public int numberOfModules(String org_UUID);
}
