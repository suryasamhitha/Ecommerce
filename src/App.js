import './App.css';
import { BrowserRouter, Route, Switch } from "react-router-dom";
import {Login, SignUp} from "./Components/Login";
import {AdminHome, AddProduct, ViewAllProduct} from './Components/Admin';
import {BookProducts, ViewAllProducts, ViewUserDetails, CustomerHome} from './Components/Customer' 
// import ForgotPassword from "./Components/ForgotPassword";
// import ChangePassword from "./Components/ChangePassword";
// import UpdateUserDetails from "./Components/UpdateUserDetails";
// import Home from './Components/Home';
// import ViewUserDetails from './Components/VIewUserDetails';
// import CustomerNavbar from './Components/CustomerNavbar';
// import AddProduct from './Components/AddProduct';
// import ViewAllProducts from './Components/ViewAllProducts';
// import AdminProductOperation from './Components/AdminProductOperation';
// import AdminHome from './Components/AdminHome';

function App() {
  return (
    <BrowserRouter>
    {/* <CustomerNavbar/> */}
    <Switch>
        {/* <Route path="/" exact component={Home} /> */}
        <Route path="/login" exact component={Login} />
        <Route path="/register" exact component={SignUp} />
        <Route path="/admin/home" exact component={AdminHome} />
        <Route path="/add/product" exact component={AddProduct} />
        <Route path="/viewall/product" exact component={ViewAllProduct} />

        <Route path="/" exact component={CustomerHome} />
        <Route path="/customer/cart" exact component={BookProducts} />
        <Route path="/customer/product/view/all" exact component={ViewAllProducts} />
        <Route path="/user/view" exact component={ViewUserDetails} />
        {/* <Route path="/all" exact component={RenderAllProducts} /> */}
        {/* <Route path="/forgot/password" exact component={ForgotPassword} />
        <Route path="/change/password" exact component={ChangePassword} />
        <Route path="/update/user" exact component={UpdateUserDetails} />
        <Route path="/view/user" exact component={ViewUserDetails} />
        <Route path="/add/product" exact component={AddProduct} />
        <Route path="/product/viewall" exact component={ViewAllProducts} />
        <Route path="/product/operation" exact component={AdminProductOperation} />
         */}
        </Switch>
    </BrowserRouter>
  );
}

export default App;
