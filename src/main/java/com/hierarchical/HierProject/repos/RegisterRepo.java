package com.hierarchical.HierProject.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository<Register,String>{
	
	@Modifying
	@Query(value="INSERT INTO register_table(email,phone,dob,type,userUUID)VALUES(?1,?2,?3,?4,?5)",nativeQuery=true)
	@Transactional
	void storeRegisterData(String email,String phone,String dob,int type,String userUUID);
	
	@Query(value="SELECT * FROM register_table WHERE userUUID=?1",nativeQuery=true)
	public Register getRegisterData(String userUUID);

}
