package com.nineSoftech.Entity;

import java.time.LocalDate;


import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="events")
public class Events {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	@NotNull
	private String eventName;

	@NotNull
	private Long managementId;
	@NotNull
	private LocalDate event_date;
	private LocalTime event_time;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private EventType eventType;
	
	private Integer count;
	

	 
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEventName() {
		return eventName;
	}



	public void setEventName(String eventName) {
		this.eventName = eventName;
	}



	public Long getManagementId() {
		return managementId;
	}



	public void setManagementId(Long managementId) {
		this.managementId = managementId;
	}



	public LocalDate getEvent_date() {
		return event_date;
	}



	public void setEvent_date(LocalDate event_date) {
		this.event_date = event_date;
	}



	public LocalTime getEvent_time() {
		return event_time;
	}



	public void setEvent_time(LocalTime event_time) {
		this.event_time = event_time;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public EventType getEventType() {
		return eventType;
	}



	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}



	public Events() {}
		
	
}
