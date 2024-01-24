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

import com.nineSoftech.Entity.UserEvent;
import com.nineSoftech.Service.UserEventService;

@RestController
@RequestMapping("/user_event")
public class UserEventController {
	
	

    @Autowired
    private UserEventService userEventService;

    @GetMapping("/all")
    public ResponseEntity<List<UserEvent>> getAllUserEvents() {
        List<UserEvent> userEvents = userEventService.getAllUserEvents();
        return new ResponseEntity<>(userEvents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEvent> getUserEventById(@PathVariable Long id) {
        UserEvent userEvent = userEventService.getUserEventById(id);
        if (userEvent != null) {
            return new ResponseEntity<>(userEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public ResponseEntity<UserEvent> createUserEvent(@RequestBody UserEvent userEvent) {
    	 UserEvent createdUserEvent = userEventService.createUserEvent(userEvent);
	        return new ResponseEntity<>(createdUserEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEvent> updateUserEvent(@PathVariable Long id, @RequestBody UserEvent userEvent) {
        UserEvent updatedUserEvent = userEventService.updateUserEvent(id, userEvent);
        if (updatedUserEvent != null) {
            return new ResponseEntity<>(updatedUserEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserEvent(@PathVariable Long id) {
        userEventService.deleteUserEvent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
