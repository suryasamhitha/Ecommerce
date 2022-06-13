package com.furniture.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="app_user")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String role;
	
	public AppUser(){}
		
	public AppUser(long id, String password, String role) {
		this.id = id;
		this.password = password;
		this.role = role;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "AppUser [id=" + id + ", password=" + password + ", role=" + role + "]";
	}
	
	
}

