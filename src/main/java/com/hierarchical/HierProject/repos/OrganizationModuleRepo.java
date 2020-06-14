package com.hierarchical.HierProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.OrganizationModule;

@Repository
public interface OrganizationModuleRepo extends JpaRepository<OrganizationModule,String>{

}
