package com.hierarchical.HierProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.Organization;

@Repository
public interface OrganizationRepo extends JpaRepository <Organization,String>{

}
