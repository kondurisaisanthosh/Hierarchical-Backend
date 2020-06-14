package com.hierarchical.HierProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.ModuleTable;

@Repository
public interface ModuleTableRepo extends JpaRepository<ModuleTable,String>{

}
