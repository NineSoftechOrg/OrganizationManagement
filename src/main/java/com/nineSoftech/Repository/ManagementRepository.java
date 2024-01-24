package com.nineSoftech.Repository;

import java.util.Optional;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.Management;

@Repository
public interface ManagementRepository extends JpaRepository< Management, Long> {

	

	
}
