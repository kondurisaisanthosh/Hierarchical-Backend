package com.hierarchical.HierProject.repos;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hierarchical.HierProject.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    
	User findByUsername(String username);
    
    @Modifying
    @Query(value="INSERT INTO user_table(username,password)VALUES(?1,?2)",nativeQuery=true)
    @Transactional
    public void storeUserData(String username,String password);
    
    
    @Query(value="SELECT count(1) FROM user_table WHERE username=?1",nativeQuery=true)
	public int checkuser(String username);
    
}
