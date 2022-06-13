class Customer {
  constructor(
    custId,
    firstName,
    lastName,
    loginId,
    password,
    email,
    phoneNo, role
  ) {
    this.custId = custId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.loginId = loginId;
    this.password = password;
    this.email = email;
    this.phoneNo = phoneNo;
    this.role = role;
  }
}

export default Customer;
