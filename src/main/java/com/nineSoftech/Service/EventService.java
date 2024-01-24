package com.nineSoftech.Service;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nineSoftech.Entity.EventType;
import com.nineSoftech.Entity.Events;
import com.nineSoftech.Exception.PostNotFoundException;
import com.nineSoftech.Repository.EventsRepository;
import com.nineSoftech.Repository.ManagementRepository;



@Service
public class EventService{
	
	

    @Autowired
    private EventsRepository eventsRepository;
    
    @Autowired
    private ManagementRepository managementRepository ;

    
    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }

    
    public Events getEventById(Long id) {
        Optional<Events> optionalEvent = eventsRepository.findById(id);
        return optionalEvent.orElseThrow(() -> new PostNotFoundException("Event not found with the given ID."));
    }

    
    public Events createEvent(Events events) {
    	
    	if(events.getManagementId()!= null) {
    		if(this.managementRepository.findById(events.getManagementId()).isPresent()) {
    			 return eventsRepository.save(events);
    		}
    	}
    	return null;
       
    }

    
    public Events updateEvent(Long id, Events updatedEvent) {
        Optional<Events> optionalEvent = eventsRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Events existingEvent = optionalEvent.get();
           
            existingEvent.setEventName(updatedEvent.getEventName());
            existingEvent.setManagementId(updatedEvent.getManagementId());
            existingEvent.setEvent_date(updatedEvent.getEvent_date());
            existingEvent.setEvent_time(updatedEvent.getEvent_time());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setEventType(updatedEvent.getEventType());
            return eventsRepository.save(existingEvent);
        }
        return null; 
    }

    
    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }
    
    public List<Events> getEventsByManagementId(Long managementId) {
        return eventsRepository.findAllByManagementId(managementId);
    }
    
    public List<Events> getAllGroupEvents() {
        return eventsRepository.findAllByEventType(EventType.GROUP);
    }
	
}
