import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import MenuItem from '@material-ui/core/MenuItem';
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import { Link } from "react-router-dom";
// import AppUser from '../../Models/User'
import User from '../../Models/User';
import addUser  from '../../Service/LoginService';
import { withStyles } from "@material-ui/core/styles";
import LoginService from "../../Service/LoginService";
import BoxForm from "../BoxForm";
import Navbar from "../Navbar";
import { Nav } from "reactstrap";

const styles = (theme) => ({
  paper: {
    // marginTop: theme.spacing(10),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    backgroundColor: theme.palette.secondary.main, 
  },
  form: {
    width: "50%",
    marginTop: 20,
    marginLeft: 10,
   
    border: '2px',

  },
  linkColour: {
    color: 'blue',
    width: '400px',
    marginLeft: "20%",
  },
  submit: {
    margin: theme.spacing(3, 0, 2),
    color:'white',
    width: '400px',
    marginLeft: "10%",
  },
  TextField:
  {
    backgroundColor: 'offwhite',
    marginBottom: '10px',
     width: '500px',
  },
  Typography:
  {
      paddingTop: 50,
  },
  colour: {
    color: 'red'
  },

});

class SignUp extends Component {
    service = new LoginService();
  initialState = {
    firstName: '',
    lastName:'',
    loginId:'',
    password:'',
    email:'',
    phoneNo:'',
    errorMsg: ''
  };

  state = { ...this.initialState };

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();

    const user = new User(
       this.state.firstName,
       this.state.lastName,
       this.state.loginId,
       this.state.password,
       this.state.email,
       this.state.phoneNo
    )

   this.service.addUser(user)
    .then((res) =>{
        this.setState({...this.initialState});
        console.log(res)
        this.props.history.push("/login")
    })
    .catch((err) => {
          const error= err.message.substring(
          err.message.indexOf("=") + 1,
          err.message.indexOf("]"));
          this.setState({errorMsg: error})
        }
    )
  };

  render() {
    const { firstName, lastName, loginId, password , email,phoneNo} = this.state;
    const classes  = this.props.classes;
    return (
        <div className={classes.paper}
        style = {{
          backgroundImage:
              "url(https://images.ctfassets.net/hrltx12pl8hq/5iJ98pkz6tIJeG4aSwp5SI/ffd32cb0e3090f88aaf6a4275720c397/01-interiors_549055441.jpg?fit=fill&w=480&h=270)",
              backgroundRepeat: "no-repeat",
              backgroundSize: "cover",
              backgroundPosition: "center",
              height: "100vh",
              opacity: 0.9, 
        }}
        >
        <Navbar/>
        <BoxForm
            style={{
              maxWidth: "650px",
              maxHeight: "700px",
              paddingTop: "0px",
              marginTop: "0px",
              paddingBottom:"20px",
              marginBottom:"120px",
              // backgroundColor: "beige",
            }}
            flex
          >
          <Typography component="h1" variant="h2" align = "center" color = "default" marginTop = "20px" className = {classes.Typography}>
            Sign Up
          </Typography>

          <form className={classes.form} noValidate onSubmit={this.handleSubmit}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  id="firstName"
                  label="First name"
                  name="firstName"
                  type="text"
                  autoComplete="firstName"
                  value={firstName}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="lastName"
                  label="Last name"
                  type="text"
                  id="lastName"
                  autoComplete="lastName"
                  value={lastName}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />

              
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="loginId"
                  label="loginId"
                  type="text"
                  id="loginId"
                  autoComplete="loginId"
                  value={loginId}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
                 <TextField
                  variant="outlined"
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="password"
                  value={password}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
                <TextField
                 variant="outlined"
                  required
                  fullWidth
                  name="email"
                  label="Email address"
                  type="email"
                  id="email"
                  autoComplete="email"
                  value={email}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  inputProps={{ maxLength: 10, minLength: 10 }}
                  name="phoneNo"
                  label="phone number"
                  type="text"
                  id="phoneNo"
                  autoComplete="phoneNo"
                  value={phoneNo}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
            <p className={classes.colour}>{this.state.errorMsg !== "" ? this.state.errorMsg : null}</p>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className= {classes.submit}
              size="large"
            >
              Register
            </Button>
                <Link to="/login"  variant="body2">
                  <Typography className={classes.linkColour}>
                  Already have an account? Login
                  </Typography>
                </Link>

          </form>
          </BoxForm>
        </div>
    );
  }
}

export default withStyles(styles)(SignUp);
















// import React, { Component } from 'react';
// import {
//     BoldLink,
//     BoxContainer,
//     FormContainer,
//     Input,
//     MutedLink,
//     SubmitButton,
//   } from "./common";

// import User from "../../Models/User";
// import {addUser} from "../../Service/SignUpService";

  
// class SignUp extends Component {

//   state = {
//     firstName:"",
//     lastName:"",
//     loginId: "",
//     password: "",
//     email: "",
//     phoneNo: "",
//     role: "customer",
//     loading: false,
//     error: undefined,
// };

// handleChange = (e) => {
// this.setState({ [e.target.name]: e.target.value });
// };

// handleSubmit = (e) => {
// e.preventDefault();
// console.log(this.state);

// const user = new User(
//   this.state.firstName,
//   this.state.lastName,
//   this.state.loginId,
//   this.state.password,
//   this.state.email,
//   this.state.phoneNo,
//   this.state.role
// );

// addUser(user)
//   .then((res) => {
//     this.setState({...this.initialState});
//     console.log(res);
//     this.props.history.push("/login");
//   })
//   .catch((err) => {
//     this.setState({
//       error: err.message,
//     });
//     console.log(err.message);
//   });

// // this.setState({ ...this.initialState });
// };

//     render() {
//         return (
//             <div className="auth-wrapper">
//             <div className="auth-inner">

//             <h3>Sign-Up</h3>
//     <BoxContainer>
//         <Input type="text" defaultValue={this.state.firstName} onChange={this.handleChange} placeholder="Enter First Name" />
//         <Input type="text" defaultValue={this.state.lastName} onChange={this.handleChange} placeholder="Enter Last Name" />
//         <Input type="text" defaultValue={this.state.loginId} onChange={this.handleChange} placeholder="Enter Login Id" />
//         <Input type="password" defaultValue={this.state.password} onChange={this.handleChange} placeholder="Enter Password" />
//         <Input type="text" defaultValue={this.state.email} onChange={this.handleChange} placeholder="Enter Email" />
//         <Input type="text" defaultValue={this.state.phoneNo} onChange={this.handleChange} placeholder="Enter Phone Number" />

//       {/* <Marginer direction="vertical" margin={10} /> */}
//       <SubmitButton type="submit" onClick={this.addUser}>Sign Up</SubmitButton>
//       {/* <Marginer direction="vertical" margin="1em" /> */}
//       <MutedLink href="#">
//         Already have an account?
//         <BoldLink href="loginForm" >
//           Sign In
//         </BoldLink>
//       </MutedLink>
//     </BoxContainer>
//     </div>
//     </div>
//         );
//     }
// }

// export default SignUp;