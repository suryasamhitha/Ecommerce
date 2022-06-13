import { Container } from "@material-ui/core";
import React from "react";
//import Footer from "../Footer";
import CustomerNavbar from "../Navbar";

function CustomerHeader(props) {
  return (
    <>
      <CustomerNavbar />
      <Container>
          {props.children}
      </Container>
    </>
  );
}

export default CustomerHeader;