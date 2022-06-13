import { Container } from "@material-ui/core";
import React from "react";
//import Footer from "../Footer";
import AdminNavbar from "./AdminNavbar";

function AdminHeader(props) {
  return (
    <>
      <AdminNavbar/>
      <Container>
          {props.children}
      </Container>
    </>
  );
}

export default AdminHeader;