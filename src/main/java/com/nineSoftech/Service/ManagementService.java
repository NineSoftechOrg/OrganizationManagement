package com.nineSoftech.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.Management;
import com.nineSoftech.Exception.DeleteApiException;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.ManagementRepository;



@Service
public class ManagementService {

   


    @Autowired
    private ManagementRepository managementRepository;

    
    public List<Management> getAllManagementes() {
        return managementRepository.findAll();
    }

    
    public Management getManagementById(Long id) {
        Optional<Management> optionalManagement = managementRepository.findById(id);
        return optionalManagement.orElseThrow(() -> new PostNotFoundException("management not found with the given ID."));
    }

    
    public Management createManagement(Management management) {
        return managementRepository.save(management);
    }

    
    public Management updateManagement(Long id, Management updatedManagement) {
        Optional<Management> optionalManagement = managementRepository.findById(id);
        if (optionalManagement.isPresent()) {
            Management existingManagement = optionalManagement.get();
           
            existingManagement.setManagement_name(updatedManagement.getManagement_name());
            existingManagement.setManagement_head_name(updatedManagement.getManagement_head_name());
            existingManagement.setManagement_location(updatedManagement.getManagement_location());
            existingManagement.setManagement_capacity(updatedManagement.getManagement_capacity());
            return managementRepository.save(existingManagement);
        }
        return null; 
    }

    
    public void deleteManagement(Long id) {
    	try {
    		Optional<Management> optional= managementRepository.findById(id);
        	if(optional.isPresent()) {
        		 managementRepository.deleteById(id);
        	}else {
        		throw new PostNotFoundException("management not found with the given ID");
        	}
    	}catch(Exception e){
    		e.printStackTrace();
    		throw  new DeleteApiException("Deleting failed");
    	}
    	
       
    }
	
}
