import React, { useState } from 'react';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import TextField from '@material-ui/core/TextField';
import CartItem from '../../Models/CartItem'
import addCart from '../../Service/CustomerService';
// import './CSS/cards.css'
// import Footer from './Footer/Footer'
import CustomerNavbar from '../Navbar';

const useStyles = makeStyles({
    root: {
      minWidth: 300,
      padding:20,
      display: 'inline-block',
    },
    bullet: {
      
      margin: '0 2px',
      transform: 'scale(0.8)',
    },
    title: {
      fontSize: 30,
    },
    pos: {
      marginBottom: 12,
    },
    divHeight: {
      position: 'relative',
      bottom: '2px',
      marginTop: '30px'
    },
    footerHeight: 
    {
      position: 'fixed',
      bottom: '2px',
      marginTop: '30px'
    },
    colour: {
      color: 'red',
      marginLeft: "30px"
    },
    dialog:
    {
      marginRight: '100px',
      width: '150px',
    }
  });

export default function AddCarts() {
  // service =  new CustomerService();
  const classes = useStyles();
  const [open, setOpen] =useState()
  const [email, setEmail] =useState('')
  const [country, setCountry] =useState('')
  const [state, setState] =useState('')
  const [district, setDistrict] =useState('')
  const [address, setAddress] =useState('')
  const [pincode, setPincode] =useState(0)
  const [phoneNo, setPhoneNo] =useState('')
  const [ date, setDate] = useState('')
  const [quantity, setQuantity] = useState(JSON.parse(localStorage.getItem("quantity")))
  const [customerCart, setCustomerCart] = useState(JSON.parse(localStorage.getItem("cart")))
const [errorMsg, setErrorMsg] = useState("")
  const getTotalSum = () => {
    let cartSum = JSON.parse(localStorage.getItem("cart"))
     return(parseInt(cartSum.reduce(
      (sum, { price, quantity }) => sum + price * quantity,
      0
    )))
  };

  const handleClose = () =>  {
    setOpen(false)
  };
  const handleOpen = () => {
    setOpen(true)
  };

  const clearCart = () => {
    let emptyCart = []
    localStorage.setItem("cart", JSON.stringify(emptyCart))
    setCustomerCart([])
  };

  const quantitySet = (product, newQuantity) => {
    let cartQuantity = JSON.parse(localStorage.getItem("cart"))
    
    
    let updatedQuantity = cartQuantity.find(
      (item) => item.name === product.name
    ).quantity = parseInt(newQuantity);

    setQuantity(updatedQuantity)
    localStorage.setItem("cart", JSON.stringify(cartQuantity))
  };

  const removeFromCart = (productToRemove) => {
    let cartRemove = JSON.parse(localStorage.getItem("cart"))

     let updatedCart  = cartRemove.filter((product) => product.productId !== productToRemove.productId)

     console.log("local ",updatedCart)
     
    localStorage.setItem("cart", JSON.stringify(updatedCart))
    setCustomerCart(updatedCart)
    console.log("state ", customerCart)
  };

  const handleSubmit = () => {

   let finalCart = JSON.parse(localStorage.getItem("cart"))

    var productId =[]
    var quantity = []

    for (let index = 0; index < finalCart.length; index++) {
       productId.push(finalCart[index].productId)
       quantity.push(finalCart[index].quantity)
    }

    const order = new CartItem( quantity, productId, phoneNo, email, localStorage.getItem("loginId"), date, address)
    console.log(order)
    addCart(order)
    .then((res) =>{
      alert("Order Placed Successfully");
      setOpen(false);
      clearCart();
    
    })

    .catch((err) => {
      const error= err.message.substring(
        err.message.indexOf("=") + 1,
        err.message.indexOf("]"));
        setErrorMsg(error);
    })
    

  }
  const checkIfEmpty = () => {

    let cartLength = JSON.parse(localStorage.getItem("cart"))
    if(cartLength?.length === 0)
    {
      return <div className=" footerHeight">
                <div className="divStyler"/>
                <h1>Your Cart is empty!</h1>
                {/* <footer className={classes.footerHeight}>
                <Footer/>
                </footer> */}
              </div>
    }
  }

  const findCost = () => {
    let cartCost = JSON.parse(localStorage.getItem("cart"))
    if(cartCost?.length>0)
    {
      return(
        <div className="buttonPad">
          
        <h2>Total Cost: Rs.{getTotalSum()}</h2><br/>
        <Button className="buttonPad" variant="contained" color="primary"  onClick={clearCart}>Clear Cart</Button>
        <Button className="buttonPad" variant="contained" color="secondary" onClick = {handleOpen}>Buy Now</Button>
        </div>
      )
      
    }
  }
  return (
    
    <div>
      <CustomerNavbar/>
    <h1>Cart</h1>
    {checkIfEmpty()}
        <div >
        {customerCart && customerCart.map((product, index) => (
            <div className="cardStyle">
            <Card variant="outlined" key={index}>
            <img src={product.imgUrl} height="200px" width="auto" alt={product.name}/>
            <CardContent>
                <Typography className={classes.title} variant="h5"  gutterBottom>{product.name}</Typography>
                <Typography  component="h2">{product.description}</Typography>
                <Typography className={classes.pos} color="textSecondary">{product.price}</Typography>
                <TextField type="number" label="Quantity" variant="filled" onChange={(e) => quantitySet( product, parseInt(e.target.value))} InputProps={{ inputProps: { min: 1 } }}/>
            </CardContent>
            <CardActions>
                <Button size="small" variant="outlined"color="secondary" onClick={() => {removeFromCart(product)}}>Remove</Button>
            </CardActions>
            </Card>
            </div>
        ))}
        </div>
      
        {findCost()}
         
                        
            <Dialog open={open} onClose={handleClose} aria-labelledby="form-dialog-title">
               <DialogTitle   id="form-dialog-title">Shipping Address</DialogTitle>
               <DialogContent>
                 <TextField
                   margin="dense"
                   id="address"
                   name="address"
                   label="Home no./Street"
                   type="text"
                   value={address}
                   className = {classes.dialog}
                   onChange={e => setAddress(e.target.value)}
                  
                 />
                 <TextField
                   margin="dense"
                   id="district"
                   name="district"
                   label="District"
                   type="text"
                   className = {classes.dialog}
                   value={district}
                   onChange={e => setDistrict(e.target.value)}
                 />
                 <TextField
                   margin="dense"
                   id="state"
                   name="state"
                   label="State"
                   type="text"
                   value={state}
                   className = {classes.dialog}
                   onChange={e => setState(e.target.value)}
                 />
                 <TextField
                   margin="dense"
                   id="country"
                   name="country"
                   label="Country"
                   type="text"
                   value={country}
                   className = {classes.dialog}
                   onChange={e => setCountry(e.target.value)}
                 />
                 <TextField
                   margin="dense"
                   id="pincode"
                   name="pincode"
                   label="Pincode"
                   type="number"
                   value={pincode}
                   className = {classes.dialog}
                   onChange={e => setPincode(e.target.value)}
                 />
                 <TextField
                   margin="dense"
                   id="phoneNo"
                   name="phoneNo"
                   label="Phone Number"
                   type="number"
                   className = {classes.dialog}
                   value={phoneNo}
                   onChange={e => setPhoneNo(e.target.value)}
                 />
                 <TextField
                   margin="dense"
                   id="email"
                   name="email"
                   label="Email"
                   type="email"
                   value={email}
                   className = {classes.dialog}
                   onChange={e => setEmail(e.target.value)}
                 />
               </DialogContent>
               <p className={classes.colour}>{errorMsg !== "" ? errorMsg : null}</p>
 
               <DialogActions>
                 
                   <Button onClick={handleClose} color="primary">
                     Cancel
                   </Button>            
                   <Button variant = "contained" onClick={() => handleSubmit()} color="primary">
                     Place Order
                   </Button>
               </DialogActions>
             </Dialog>   

            {/* {!checkIfEmpty() && (
 <footer className={classes.divHeight}>
 <Footer/>
 </footer> 
            )} */}
                    
    </div>
  );
}