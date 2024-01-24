package com.nineSoftech.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "management")
public class Management {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	@NotNull
	private String management_name;
	private String management_head_name;
	private String management_location;
	private Long management_capacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManagement_name() {
		return management_name;
	}

	public void setManagement_name(String management_name) {
		this.management_name = management_name;
	}

	public String getManagement_head_name() {
		return management_head_name;
	}

	public void setManagement_head_name(String management_head_name) {
		this.management_head_name = management_head_name;
	}

	public String getManagement_location() {
		return management_location;
	}

	public void setManagement_location(String management_location) {
		this.management_location = management_location;
	}

	public Long getManagement_capacity() {
		return management_capacity;
	}

	public void setManagement_capacity(Long management_capacity) {
		this.management_capacity = management_capacity;
	}

	public Management(Long id, String management_name, String management_head_name, String management_location,
			Long management_capacity) {
		super();
		this.id = id;
		this.management_name = management_name;
		this.management_head_name = management_head_name;
		this.management_location = management_location;
		this.management_capacity = management_capacity;
	}

	public Management() {
	}

}
