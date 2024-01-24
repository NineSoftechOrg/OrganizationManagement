package com.nineSoftech.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineSoftech.Entity.EventType;
import com.nineSoftech.Entity.Events;









@Repository
public interface EventsRepository extends JpaRepository<Events, Long> {

	List<Events> findAllByManagementId(Long managementId);

	List<Events> findAllByEventType(EventType group);




}
