import React, { Component } from "react";
import { Link, withRouter } from "react-router-dom";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import LoginService from '../../Service/LoginService';
import { withStyles } from "@material-ui/core/styles";
import BoxForm from "../BoxForm";
import Navbar from "../Navbar";

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
    width: '300px',
    marginLeft: "40%",
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
class Login extends Component {
    service = new LoginService();
  initialState = {
    loginId: "",
    password: "",
    role: "customer",
    
  };

  state = { ...this.initialState };

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();
    console.log(this.state);
   
   this.service.login(this.state.loginId, this.state.password)
    .then((res) =>{
        this.setState({...this.initialState});
        console.log(res)
        this.setState({ redirect: true });
        var cart = []
         localStorage.setItem("id", res.id);
         localStorage.setItem("loginId", res.loginId);
         localStorage.setItem("firstName", res.firstName);
         localStorage.setItem("lastName", res.lastName);
         localStorage.setItem("role", res.appUser.role);
         localStorage.setItem("phoneNo", res.phoneNo);
         localStorage.setItem("email", res.email);
         localStorage.setItem("cart", JSON.stringify(cart))

         if(localStorage.getItem("role") === "customer")
         {
          this.props.history.push("/")
         }
         if(localStorage.getItem("role") === "admin")
         {
          this.props.history.push("/admin/home");
         }
         
         
    }) 
    .catch((err) => {
      const error= err.message.substring(
        err.message.indexOf("=") + 1,
        err.message.indexOf("]"));
        this.setState({errorMsg: error})
    })

    this.setState({ ...this.initialState });
  };

  render() {
    const { loginId, password } = this.state;
    const classes  = this.props.classes;
    return (
        <div className = {classes.paper}
     
          style = {{
            backgroundImage:
                "url(https://images.unsplash.com/photo-1534349762230-e0cadf78f5da?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1170&q=80)",
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
              maxHeight: "650px",
              paddingTop: "0px",
              // marginTop: "20px",
              paddingBottom:"20px",
              marginBottom:"250px",
            }}
            flex
          >
         <Typography component="h1" variant="h1" align = "center" color = "default">
            Login
          </Typography>

          <form className = {classes.form} noValidate onSubmit={this.handleSubmit}>
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  className = {classes.TextField}
                  margin = "normal"
                  id="loginId"
                  label="loginId"
                  name="loginId"
                  value={loginId}
                  onChange={this.handleChange}
                />
                <TextField
                  variant="outlined"
                  required
                  fullWidth
                  className = {classes.TextField}
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  value={password}
                  onChange={this.handleChange}
                />
            <p className={classes.colour}>{this.state.errorMsg !== "" ? this.state.errorMsg : null}</p>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              color="primary"
              className= {classes.submit}
              size="large">
                
               Login
            </Button>
            <Grid container>
              <Grid item  justify="flex-start">
                <Link to="/forgot/password" variant="body2" color = "secondary">
                <Typography className={classes.linkColour}>
                  Forgot password
                  </Typography>
                </Link><br/>
                <Link to="register" variant="body2" color = "secondary">
                <Typography className={classes.linkColour}>
                  New User? Create an Account.
                  </Typography>
                </Link>
              </Grid>
            </Grid>
          </form>
          </BoxForm>
        </div>
    );
  }
}

export default withRouter(withStyles(styles)(Login));
