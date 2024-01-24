package com.nineSoftech.Repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.UserEvent;



@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {

	List<UserEvent> findAllByEventId(Long eventId);


}
