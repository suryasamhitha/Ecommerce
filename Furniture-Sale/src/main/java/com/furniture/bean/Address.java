package com.furniture.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "address")

public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long addressId;
	private String houseNo;
	private String street;
	private String landmark;
	private String city;
	private String dist;
	private String state;
	private String country;
	private String pincode;
	public Address(long addressId, String houseNo, String street, String landmark, String city, String dist,
			String state, String country, String pincode) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.street = street;
		this.landmark = landmark;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", street=" + street + ", landmark="
				+ landmark + ", city=" + city + ", dist=" + dist + ", state=" + state + ", country=" + country
				+ ", pincode=" + pincode + "]";
	}
	
}
