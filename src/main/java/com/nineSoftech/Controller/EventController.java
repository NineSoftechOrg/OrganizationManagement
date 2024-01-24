package com.nineSoftech.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nineSoftech.Entity.Events;
import com.nineSoftech.Service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	   @Autowired
	    private EventService eventService;

	    @GetMapping("all")
	    public ResponseEntity<List<Events>> getAllEvents() {
	        List<Events> events = eventService.getAllEvents();
	        return new ResponseEntity<>(events, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Events> getEventById(@PathVariable Long id) {
	        Events event = eventService.getEventById(id);
	        if (event != null) {
	            return new ResponseEntity<>(event, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PostMapping("/post")
	    public ResponseEntity<Events> createEvent(@RequestBody Events events) {
	        Events createdEvent = eventService.createEvent(events);
	        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Events> updateEvent(@PathVariable Long id, @RequestBody Events events) {
	        Events updatedEvent = eventService.updateEvent(id, events);
	        if (updatedEvent != null) {
	            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
	        eventService.deleteEvent(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    

	    @GetMapping("/church/{churchId}")
	    public ResponseEntity<List<Events>> getEventsByChurchId(@PathVariable Long churchId) {
	        List<Events> events = eventService.getEventsByManagementId(churchId);
	        return new ResponseEntity<>(events, HttpStatus.OK);
	    }
	    
	    @GetMapping("/group-events")
	    public ResponseEntity<List<Events>> getAllGroupEvents() {
	        List<Events> groupEvents = eventService.getAllGroupEvents();
	        return new ResponseEntity<>(groupEvents, HttpStatus.OK);
	    }

}
