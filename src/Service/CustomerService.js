import axios from "axios";
import BACKEND_URL from "../Backend";

class CustomerService {

  // CUSTOMER 

  updateUser = () => {
    return axios
      .put(`${BACKEND_URL}/CustomerController/customer/update`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  searchUser = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/customer/searchuser/{loginId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  changePassword = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/customer/changepass`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  forgotPassword = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/customer/forgotpass`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  // CUSTOMER SELL PRODUCT
  addSellproduct = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/customersell/add`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  viewAllProducts = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/product/view-all`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  deleteProduct = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/customersell/delete/{productId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

// CART
  addCart = (order) => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/Cart`, order)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  removeCart = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/delete{cartId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  viewAllCustomer = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController//cart/{loginId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

// PAYMENT
  addPayment = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/payment/add`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  deletePayment = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController//payment/{paymentId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  viewPaymentById = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/payment-view/{paymentId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

// TRANSACTION HISTORY
viewTransactions = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/history/{trId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  AllProducts = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/product/view-all`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
}

export default CustomerService;
