package com.nineSoftech.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.UserEvent;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.EventsRepository;
import com.nineSoftech.Repository.UserEventRepository;
import com.nineSoftech.Repository.UserRepository;



@Service
public class UserEventService {

	  @Autowired
	    private UserEventRepository userEventRepository;
	  
	  @Autowired
	    private EventsRepository eventsRepository;
	  
	  @Autowired
	    private UserRepository userRepository;

	    
	    public List<UserEvent> getAllUserEvents() {
	        return userEventRepository.findAll();
	    }

	    
	    public UserEvent getUserEventById(Long id) {
	        Optional<UserEvent> optionalUserEvent = userEventRepository.findById(id);
	        return optionalUserEvent.orElseThrow(() -> new PostNotFoundException("userEvent not found with the given ID."));
	    }

	    
	    public UserEvent createUserEvent(UserEvent userEvent) {
	    	
	    	if(userEvent.getUserId()!= null && userEvent.getEventId()!= null) {
	    		
	    		if(this.userRepository.findById(userEvent.getUserId()).isPresent() && this.eventsRepository.findById(userEvent.getEventId()).isPresent()) {
	    			  return userEventRepository.save(userEvent);
	    		}
	    	}
	    
	        return null;
	    }

	    
	    public UserEvent updateUserEvent(Long id, UserEvent updatedUserEvent) {
	        Optional<UserEvent> optionalUserEvent = userEventRepository.findById(id);
	        if (optionalUserEvent.isPresent()) {
	            UserEvent existingUserEvent = optionalUserEvent.get();
	        
	            existingUserEvent.setEventId(updatedUserEvent.getEventId());
	            existingUserEvent.setUserId(updatedUserEvent.getUserId());
	            return userEventRepository.save(existingUserEvent);
	        }
	        return null; 
	    }

	    
	    public void deleteUserEvent(Long id) {
	        userEventRepository.deleteById(id);
	    }
}
