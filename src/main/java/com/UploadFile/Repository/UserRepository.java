package com.UploadFile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UploadFile.Dao.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	
//public User findById(int id);	

}
