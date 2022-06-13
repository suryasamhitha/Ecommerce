 package com.furniture.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int paymentId;
	@NotBlank(message="Payment mode should be selected")
	private String paymentMode;
	@NotBlank(message="Card number should be given")
	private String cardNumber;
	@NotBlank(message="Card holder name is required")
    private String cardHolderName;
	@NotBlank(message="expiry date is must")
	private String expiryDate;
	@NotNull(message="give the cvv")
	private int cvv;
	@NotNull(message="Property should not be null")
	private int otp;
	
	
	public Payment(int paymentId, @NotBlank(message = "Payment mode should be selected") String paymentMode,
			@NotBlank(message = "Card number should be given") String cardNumber,
			@NotBlank(message = "Card holder name is required") String cardHolderName,
			@NotBlank(message = "expiry date is must") String expiryDate, @NotNull(message = "give the cvv") int cvv,
			@NotNull(message = "Property should not be null") int otp) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.otp = otp;
	}

	public int getId() {
		return paymentId;
	}
	
	public void setId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public int getCvv() {
		return cvv;
	}
	
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public int getOtp() {
		return otp;
	}
	
	public void setOtp(int otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", cardNumber=" + cardNumber
				+ ", cardHolderName=" + cardHolderName + ", expiryDate=" + expiryDate + ", cvv=" + cvv + ", otp=" + otp
				+ "]";
	}
	
}