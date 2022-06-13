import axios from "axios";
import BACKEND_URL from "../Backend";

class AdminService {
  //ADMIN
  updateAdmin = (user) => {
    return axios
      .get(`${BACKEND_URL}/AdminController/admin/update`, user)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  viewAdmin = (loginId) => {
    return axios
      .get(`${BACKEND_URL}/AdminController/admin/view/{loginId}` , loginId)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  // PRODUCT
  addProduct = (product) => {
    return axios.post(`${BACKEND_URL}/AdminController/product/add`, product)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  updateProduct = (product) => {
    return axios
      .put(`${BACKEND_URL}/AdminController/product/update`, product)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  deleteProduct = (productId) => {
    return axios
      .delete(`${BACKEND_URL}/AdminController/product/delete/${productId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  getProductById = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/product/view-id/{productId}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  getProductByName = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/product/view-name/{name}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  getProductByCategory = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/product/view-category/{category}`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  getAllProducts = () => {
    return axios
      .get(`${BACKEND_URL}/CustomerController/product/view-all`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  //TRANSACTION HISTORY
  viewAllTransaction = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/allhistory`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

  updateStatus  = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/transaction/update`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };

// PRODUCT SELL STATUS
updateProductStatus = () => {
    return axios
      .get(`${BACKEND_URL}/AdminController/customer/update`)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
}

export default AdminService;
