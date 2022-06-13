class AddressDTO {
    constructor(
        addressId,
        houseNo,
        street,
        landmark,
        city,
        dist,
        state,
        country,
        pincode
    )
    {
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
}

export default AddressDTO;