package com.nineSoftech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
//	User findByEmailOrContact(String email, String contact);

	

}
