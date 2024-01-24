package com.nineSoftech.Entity;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private UserType roleType;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;

	@Column(unique = true)
	@NotNull
	private String contact;

	@Email
	@NotNull
	@Column(unique = true)
	private String email;
	private String address;
	private String password;
	private int active;
	private Long managementId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserType getRoleType() {
		return roleType;
	}
	public void setRoleType(UserType roleType) {
		this.roleType = roleType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Long getManagementId() {
		return managementId;
	}
	public void setManagementId(Long managementId) {
		this.managementId = managementId;
	}
	public User(Long id, UserType roleType, String firstName, String lastName, LocalDate dateOfBirth,
			@NotNull String contact, @Email @NotNull String email, String address, String password, int active,
			Long managementId) {
		super();
		this.id = id;
		this.roleType = roleType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.password = password;
		this.active = active;
		this.managementId = managementId;
	}
	 
	public User() {}


}
