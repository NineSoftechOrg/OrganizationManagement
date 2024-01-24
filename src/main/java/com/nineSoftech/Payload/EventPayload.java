package com.nineSoftech.Payload;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventPayload {

	
	
	private Long eventId;
	private String eventType;
	private String eventName;
	private String churchName; 
	private LocalDate event_date;
	private LocalTime event_time;
	private String description;
	private long userId;
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getChurchName() {
		return churchName;
	}
	public void setChurchName(String churchName) {
		this.churchName = churchName;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	
}

