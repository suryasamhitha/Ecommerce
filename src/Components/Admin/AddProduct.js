import React, { Component } from "react";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import Product from '../../Models/Product'
import AdminService from '../../Service/AdminService';
import MenuItem from '@material-ui/core/MenuItem';
import { withStyles } from "@material-ui/core/styles";
import {FormControlLabel, Radio, FormControl, FormLabel, RadioGroup} from "@material-ui/core";
import AdminNavbar from "../Navbar";
import BoxForm from "../BoxForm";
const styles = (theme) => ({
  paper: {
    marginTop: theme.spacing(0),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  form: {
    width: "40%", 
    marginTop: 0,
    marginLeft: 10,

  },
  submit: {
    margin: theme.spacing(3, 0, 2),
  },
  TextField:
  {
    backgroundColor: 'white',
    width:"550px",
    border:"4px",
    color:"black",
    },
  Typography:
  {   color:"black",
      paddingTop: "5px",
      paddingBottom:"15px",
      marginTop:"10px",
  },
  colour: {
    color: 'red',
    float: 'right'
  },
});
class AddProduct extends Component {
    service = new AdminService();
  initialState = {
    id:0,
    name: '',
    color: '',
    price: 0,
    description: '',
    quantity: 0,
    category: '',
    imgUrl: '',
    errorMsg: ''
    
  };

  state = { ...this.initialState };

  handleChange = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();

   const product = new Product(
       this.state.id,
       this.state.name,
       this.state.color,
       this.state.price,
       this.state.description,
       this.state.quantity,
       this.state.category,
       this.state.imgUrl
   )


   this.service.addProduct(product)
    .then((res) =>{
        this.setState({...this.initialState});
        alert("Product Added Successfully");
        console.log(res)
    })
    .catch((err) => {
      const error= err.message.substring(
        err.message.indexOf("=") + 1,
        err.message.indexOf("]"));
        this.setState({errorMsg: error})
    })
  };
  handleCategory=(e)=>{
    this.setState({category:e.target.value})
  }

  
  buttonStyle = {
    height: 150
  }

  render() {
    const { name,color, price, description, quantity, category,imgUrl } = this.state;
    const classes  = this.props.classes;
    return (
  
      <div style={this.buttonStyle}>
        <AdminNavbar/>
        <div className = {classes.paper}
        
        style = {{
          backgroundImage:
              "url(https://i.pinimg.com/originals/ed/5f/41/ed5f4134a7c2ba7ed3410e029644e23c.jpg)",
              backgroundRepeat: "no-repeat",
              backgroundSize: "cover",
              backgroundPosition: "center",
              height: "100vh",
              opacity: 0.9, 
        }}
        >
         <BoxForm
            style={{
              maxWidth: "650px",
              maxHeight: "950px",
              paddingTop: "0px",
               marginTop: "25px",
              paddingBottom:"20px",
              marginBottom:"0px",
              marginLeft:"10px",
            }}
            flex
          >
          <Typography component="h1" variant="h3" align = "center" color = "default" marginTop = "20px" className = {classes.Typography}>
            Add product
          </Typography>
          <form className={classes.form} noValidate onSubmit={this.handleSubmit}>
            <Grid container spacing={2}>
              <Grid item xs={12}>
                <TextField
                  variant="filled"
                  required
                  fullWidth
                  id="name"
                  label="Product name"
                  name="name"
                  type="text"
                  autoComplete="name"
                  value={name}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
              </Grid>
              <Grid item xs={12}>
                <TextField
                  variant="filled"
                  required
                  fullWidth
                  id="color"
                  label="Product color"
                  name="color"
                  type="text"
                  autoComplete="color"
                  value={color}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
                </Grid>
                <Grid item xs={12}>
              <TextField
                 variant="filled"
                 required
                 fullWidth
                 id="price"
                 label="price"
                 name="price"
                 type="number"
                 autoComplete="price"
                 value={price}
                 onChange={this.handleChange}
                 className = {classes.TextField}
                />
              </Grid>
              <Grid item xs={12}>
              <TextField
                  variant="filled"
                  required
                  fullWidth
                  id="description"
                  label="description"
                  name="description"
                  type="text"
                  autoComplete="description"
                  value={description}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
              </Grid>
              <Grid item xs={12}>
              <TextField
                  variant="filled"
                  required
                  fullWidth
                  id="quantity"
                  label="quantity"
                  name="quantity"
                  type="number"
                  autoComplete="quantity"
                  InputProps={{ inputProps: { min: 1 } }}
                  value={quantity}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
              </Grid>
              <Grid item xs={12}>
              <FormControl component="fieldset">
                <FormLabel component="legend" className = {classes.TextField}>Category</FormLabel>
                <RadioGroup
                  aria-label="category"
                  name="category"
                  value={category}
                  onChange={this.handleChange}
                >
                  <FormControlLabel
                    value="Sofa and Dining"
                    control={<Radio />}
                    label="Sofa and Dining"
                  />
                  <FormControlLabel
                    value="Beds and Wardrobes"
                    control={<Radio />}
                    label="Beds and Wardrobes"
                  />
                  <FormControlLabel
                    value="Home Decor"
                    control={<Radio />}
                    label="Home Decor"
                  />
                  <FormControlLabel
                    value="Kids Furniture"
                    control={<Radio />}
                    label="Kids Furniture"
                  />
                  <FormControlLabel
                    value="Storage Solutions"
                    control={<Radio />}
                    label="Storage Solutions"
                  />
                  <FormControlLabel
                    value="Outdoor Furniture"
                    control={<Radio />}
                    label="Outdoor Furniture"
                  />
                </RadioGroup>
              </FormControl>
              </Grid> 
              <Grid item xs={12}>
                <TextField
                  variant="filled"
                  required
                  fullWidth
                  id="imgUrl"
                  label="image Url "
                  name="imgUrl"
                  type="text"
                  autoComplete="imgUrl"
                  value={imgUrl}
                  onChange={this.handleChange}
                  className = {classes.TextField}
                />
              </Grid>
              </Grid>
            <p className={classes.colour}>{this.state.errorMsg !== "" ? this.state.errorMsg : null}</p>
            <Button  type="submit"
             fullWidth
             variant="contained"
             color="primary"
             className= {classes.submit}
             size="large"

            >
              Add Product
            </Button>
          </form>
          </BoxForm>
        </div>
        </div>
    );
  }
}

export default  withStyles(styles)(AddProduct);
