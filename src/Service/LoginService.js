import axios from "axios";
import BACKEND_URL from "../Backend";

class LoginService {


  addUser = (user) => {
    return axios
      .post(`${BACKEND_URL}/LoginController/register`, user)
      .then((res) => res.data)
      .catch((err) => {
        throw new Error(err.response.data.message);
      });
  };
  // Signin service
  login = (loginId,password) => {
    return axios
      .get(`${BACKEND_URL}/LoginController/login/${loginId}/${password}`)
      .then((res) => {
        localStorage.setItem("user", JSON.stringify(res.data));
        return res.data;
      })
      // .catch((err) => {
      //   throw new Error(err.response.data.message);
      // });
  };

  // Check if logged in
  isLoggedIn = () => {
    return JSON.parse(localStorage.getItem("user"));
  };

  // Logout
  signout = () => {
    localStorage.removeItem("user");
    // next();
  };
}

export default LoginService;

