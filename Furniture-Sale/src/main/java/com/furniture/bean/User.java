package com.furniture.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.furniture.bean.AppUser;


// POJO class for Customer 
	@Entity
	@Table(name="user_details")
	public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
		private long id;
	    private String firstName;
	    private String lastName;
	    @Column(unique = true)
		private String loginId;
		private String password;
		private String email;
		private String phoneNo;
		private String role;
//		@Embedded
//		@OneToOne(cascade=CascadeType.ALL)
//		@JoinColumn(name="pass_id")
//		/* @JsonProperty(access = Access.WRITE_ONLY) */
//		private AppUser appUser;
//		
		public User() {}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
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
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public User(long id, String firstName, String lastName, String loginId, String password, String email,
				String phoneNo, String role) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.loginId = loginId;
			this.password = password;
			this.email = email;
			this.phoneNo = phoneNo;
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId
					+ ", password=" + password + ", email=" + email + ", phoneNo=" + phoneNo + ", role=" + role + "]";
		}
		
		
//		public User(long id, String firstName, String lastName, String loginId, String email, String phoneNo,  AppUser appUser) {
//			super();
//			this.id = id;
//			this.firstName = firstName;
//			this.lastName = lastName;
//			this.loginId = loginId;
////			this.password = password;
//			this.email = email;
//			this.phoneNo = phoneNo;
////			this.role = role;
//			this.appUser = appUser;
//		}
//		public long getId() {
//			return id;
//		}
//		public void setId(long id) {
//			this.id = id;
//		}
//		public String getFirstName() {
//			return firstName;
//		}
//		public void setFirstName(String firstName) {
//			this.firstName = firstName;
//		}
//		public String getLastName() {
//			return lastName;
//		}
//		public void setLastName(String lastName) {
//			this.lastName = lastName;
//		}
//		public String getLoginId() {
//			return loginId;
//		}
//		public void setLoginId(String loginId) {
//			this.loginId = loginId;
//		}
////		public String getPassword() {
////			return password;
////		}
////		public void setPassword(String password) {
////			this.password = password;
////		}
//		public String getEmail() {
//			return email;
//		}
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		public String getPhoneNo() {
//			return phoneNo;
//		}
//		public void setPhoneNo(String phoneNo) {
//			this.phoneNo = phoneNo;
//		}
////		public String getRole() {
////			return role;
////		}
////		public void setRole(String role) {
////			this.role = role;
////		}
//		
//		public AppUser getAppUser() {
//			return appUser;
//		}
//		public void setAppUser(AppUser appUser) {
//			this.appUser = appUser;
//		}
//
//		@Override
//		public String toString() {
//			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", loginId="
//					+ loginId + ", email=" + email
//					+ ", phoneNo=" + phoneNo +  "]";
//		}	
		
	}