import React from "react";
import {
  AppBar,
  Button,
  Container,
  makeStyles,
  Toolbar,
  Typography,
} from "@material-ui/core";
import { Link, withRouter } from "react-router-dom";
import LoginService from "../Service/LoginService";


const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
    width: "100vw",
  },
  header: {
    color: "black",
    // boxShadow: "0px, 0px, 0px, 0px",
    background: "#65ADA3",
     opacity: 0.9,
  },
  title: {
    flexGrow: 1,
  },
  btn: {
    margin: "10px 10px",
    color: "white",
    fontSize:"25px",
    fontWeight:"bold",
    marginLeft:"10px",
  },
  btns: {
    margin: "0px 0px",
    marginRight:"0px",
    color: "black",
    align:"center",
    fontWeight:"bold",
    fontSize:"25px",

  },
}));

function Navbar(props) {
  const classes = useStyles();

  const loginService = new LoginService();
  const { isLoggedIn } = loginService;

  return (
    <div className={classes.root}>
      <AppBar position="sticky" className={classes.header}>
        <Toolbar style={{ boxShadow: "0 2px 2px 0px #fff", zIndex: 9 }}>
          {/* <img
            src={Logo}
            alt="Logo"
            style={{ width: "22rem", height: "6rem" }}
          /> */}
          <Container style={{ display: "flex" }}>
            <Typography variant="h6" className={classes.title} href="/">
              {/* iVisaApp */}
            </Typography>
            {isLoggedIn() && isLoggedIn().role === "customer" && (
            <Button
              className={classes.btn}
              href="/"
              variant="inherit"
              color="white"
            >
              Home
            </Button>
            )}
             {isLoggedIn() && isLoggedIn().role === "admin" && (
            <Button
              className={classes.btn}
              href="/admin/home"
              variant="inherit"
              color="white"
            >
              Home
            </Button>
            )}

            {isLoggedIn() && isLoggedIn().role === "customer" && (
              <Button
                className={classes.btn}
                href="/customer/product/view/all"
                variant="inherit"
                color="black"
              >
                Product
              </Button>
            )}

            {isLoggedIn() && isLoggedIn().role === "admin" && (
              <Button
                className={classes.btn}
                href="/add/product"
                variant="inherit"
                color="black"
              >
                Add Product
              </Button>
            )}
            {!isLoggedIn() && (
              <>
                <Button className={classes.btns} href="/login" color="black" variant="inherit">
                  Login
                </Button>
                {/* <Button className={classes.btn} href="/register" color="black">
                  SignUp
                </Button> */}
              </>
            )}
            {isLoggedIn() && (
              <Button
                className={classes.btns}
                href="/"
                
                onClick={() => {
                  loginService.signout(() => {
                    props.history.push("/");
                  });
                }}
              >
                Logout
              </Button>
            )}
          </Container>
        </Toolbar>
      </AppBar>
    </div>
  );
}

export default withRouter(Navbar);









// import React from 'react';
// import { makeStyles } from '@material-ui/core/styles';
// import AppBar from '@material-ui/core/AppBar';
// import Toolbar from '@material-ui/core/Toolbar';
// import Typography from '@material-ui/core/Typography';
// import IconButton from '@material-ui/core/IconButton';
// import AccountCircle from '@material-ui/icons/AccountCircle';
// import MenuItem from '@material-ui/core/MenuItem';
// import Menu from '@material-ui/core/Menu';
// import Home from '@material-ui/icons/Home';
// // import Logo from  '../Assests/NatureCart.png';
// import { Link } from "react-router-dom";

// const useStyles = makeStyles((theme) => ({
//   root: {
//     flexGrow: 2,
//   },
//   menuButton: {
//     marginRight: theme.spacing(3),
//   },
//   title: {
//     flexGrow: 2,
//   },
//   logo: {
//         width: 250,
//   },
//   iconColor: {
//     color: "black"
//   },
//   colour: {
//     color: 'black'
//   }
// }));

// export default function AdminNavbar() {
//   const classes = useStyles();
//   const [auth] = React.useState(true);
//   const [anchorEl, setAnchorEl] = React.useState(null);
//   const open = Boolean(anchorEl);

//   const handleMenu = (event) => {
//     setAnchorEl(event.currentTarget);
//   };

//   const handleClose = () => {
//     setAnchorEl(null);
//   };

//   const handleLogout = () => {
//     setAnchorEl(null);
//     localStorage.clear()
// }

//   return (

//     <div className={classes.root}>

    
//         <AppBar 
//       position="sticky"
//       style={{
//           backgroundColor:"transparent",
//           color:"black",
//           width:"100vw",
//           height:"100px"
//       }}
//       >
//         <Toolbar>
// {/*
//                  <Typography> <img src={Logo} alt="logo" width = "100px" className={classes.logo} /></Typography>
//            */}
//           <Typography variant="h6" className={classes.title}>
//           <object align="right" spacing={2}> 
//           <IconButton
//                 aria-label="home"
//                 aria-haspopup="true"
//                 className={classes.iconColor}
//                 component = {Link}
//                 to ="/admin/home"
//               >
//                   <Home/>
//               </IconButton>
//             </object>
//           <object align="right" vspace="20px" >
//             Hi Admin
//             </object>
//           </Typography>

//           {auth && (
//             <div>
//               <IconButton
//                 aria-label="account of current user"
//                 aria-controls="menu-appbar"
//                 aria-haspopup="true"
//                 onClick={handleMenu}
//                 color="contained"
//               >
//                 <AccountCircle />
//               </IconButton>
//               <Menu
//                 id="menu-appbar"
//                 anchorEl={anchorEl}
//                 anchorOrigin={{
//                   vertical: 'top',
//                   horizontal: 'right',
//                 }}
//                 keepMounted
//                 transformOrigin={{
//                   vertical: 'top',
//                   horizontal: 'right',
//                 }}
//                 open={open}
//                 onClose={handleClose}
//               >
               
//                 <Link to = "/">
//                   <MenuItem className={classes.colour} onClick={handleLogout}>Logout</MenuItem>
//                 </Link>
//               </Menu>
//             </div>
//           )}
//         </Toolbar>
//       </AppBar>
//     </div>
//   );
// }
