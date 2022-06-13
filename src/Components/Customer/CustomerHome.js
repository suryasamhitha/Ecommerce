import React from "react";
import { Link } from "react-router-dom";
import "./Home.css";
import CustomerHeader from './CustomerHeader'

export default function AdminHome() {

  return (
    <div> 
      {/* <CustomerHeader/> */}
    <div className="info">

      <div className="content">
        <div className="head">
          <h1>Ready for new Furnitures</h1>
          <p>Buy new stock at reasonable cost</p>

          <Link to="/login">
            <button>Get Started</button>
          </Link>
        </div>
      </div>
      <div className="pic"></div>
    </div>
    </div>
  );
}











// import React, {useState} from "react";
// import { UncontrolledCarousel, Container, Row, Col } from "reactstrap";
// import CustomerHeader from './CustomerHeader';
// import ViewAllProduct from "./ViewAllProducts";
// import BookProducts from './BookProducts';
// import Grid from '@material-ui/core/Grid';
// // import Footer  from './Footer';
// const PAGE_PRODUCTS = 'products';
// const PAGE_CART = 'cart';


// function CustomerHome () 
// {
//   const [cart, setCart] = useState([]);
//   const [page, setPage] = useState(PAGE_PRODUCTS);

//   const navigateTo = (nextPage) => {
//     setPage(nextPage);
//   };
//   const getCartTotal = () => {
//     return cart.reduce(
//       (sum, { quantity }) => sum + quantity,
//       0
//     );
//   }
//   return(
//     <div>
//           <CustomerHeader/>
            
       
//           {page === PAGE_PRODUCTS && (
           
//       <ViewAllProduct cart={cart} setCart={setCart} />
      
//     )}
         
         
//   {page === PAGE_CART && (
//     <BookProducts cart={cart} setCart={setCart} />
//   )}

//     </div>
//       )
 

// }

// export default CustomerHome;