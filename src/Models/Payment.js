class Payment {
  constructor(
    paymentId,
    paymentMode,
    carNumber,
    cardHolderName,
    expiryDate,
    cvv,
    otp
  ) {
    this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.otp = otp;
  }
}

export default Payment;
