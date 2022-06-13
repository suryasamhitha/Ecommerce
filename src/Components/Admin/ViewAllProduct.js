import React,{ Component } from 'react'
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';
import Product from '../../Models/Product'
import { withStyles } from "@material-ui/core/styles";
import AdminService from '../../Service/AdminService'
import { Grid } from '@material-ui/core';
import Container from "@material-ui/core/Container";
// import './CSS/cards.css'
import AdminNavbar from '../Navbar';

const styles = (theme) => ({
  icon: {
    marginRight: theme.spacing(2),
  },
  heroContent: {
    backgroundColor: theme.palette.background.paper,
    // padding: theme.spacing(8, 0, 6),
  },
  heroButtons: {
    marginTop: theme.spacing(),
    marginLeft: theme.spacing(0),
    marginBottom: theme.spacing(0),
  },
  cardGrid: {
    marginTop: theme.spacing(-7),
    paddingTop: theme.spacing(2),
    paddingBottom: theme.spacing(2),
  },
  card: {
    height: "350px",
    display: "flex",
    flexDirection: "row",
    // paddingBottom:"5px",
    width:"100vw",
    paddingTop:0,
    backgroundColor:"white",
  },
  cardMedia: {
    paddingTop: "56.25%", // 16:9
  },
  cardContent: {
    flexGrow: 1,
    flexDirection: "row",
    fontSize:"80px",
  },
});

class ViewAllProduct extends Component {
//  classes = useStyles();
service = new AdminService();
    constructor() {
        super()
        this.state = {
            productId:0,
            name:'',
            color: '',
            price:0,
            description:'',
            quantity:0,
            category:'',
            open: undefined,
            prod:[],
            products:[],
            imgUrl: "",
            errorMsg: '',
        }
    }

    componentDidMount() {
       
      this.service.getAllProducts().then((res) => {
            this.setState ({products: res})
        })
       
    }

    handleChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    };
    
    handleClose = () => {
        this.setState( {
          open: false,
          errorMsg:'',
        })
    };
    
    handleSubmit = (e) => {
        e.preventDefault();
    
       const product = new Product(
           this.state.productId,
           this.state.name,
           this.state.color,
           this.state.price,
           this.state.description,
           this.state.quantity,
           this.state.category,
           this.state.imgUrl
       )

       let prod = {
        productId: this.state.productId,
        name: this.state.name,
        color: this.state.color,
        price: this.state.price,
        description: this.state.description,
        quantity: this.state.quantity,
        category: this.state.category,
        imgUrl: this.state.imgUrl
       }
    
       this.service.updateProduct(product)
        .then((res) =>{
            this.setState({products: this.state.products, res});
            console.log(res)
            const index = this.state.products.findIndex(emp => emp.productId === prod.productId),
        copyProducts = [...this.state.products] 
        copyProducts[index] = prod;

        this.setState({products: copyProducts});
        this.setState({open: false})
        })
        .catch((err) => {
            const error= err.message.substring(
            err.message.indexOf("=") + 1,
            err.message.indexOf("]"));
            this.setState({errorMsg: error})
          }
      )
        
    };

    handleDeleteUser = (productId) => {

        this.service.deleteProduct(productId);
    
        let tempProducts = [];
        tempProducts = this.state.products;

        tempProducts = tempProducts.filter((product) => {
            return product.productId !== productId
        })

        this.setState({
            products: tempProducts
        })             
    }

    handleUpdateUser = (p) => {

        this.setState({
            open: true,
            productId:p.productId,
            name:p.name,
            color: p.color,
            price:p.price,
            description:p.description,
            quantity:p.quantity,
            category:p.category,
            imgUrl:p.imgUrl,
        })         
    }

    buttonStyle={
        height: 150 
    }
    render()
    {
      const classes  = this.props.classes;
        return(
            <div 
             style = {{
                backgroundImage:
                    "url(https://www.sheknows.com/wp-content/uploads/2020/06/online-interior-design-classes.jpeg?w=1440)",
                    backgroundRepeat: "no-repeat",
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    height: "100%",
                    opacity: 0.9, 
              }}>
                <div style={this.buttonStyle}>
                <AdminNavbar/>
                </div>
                {this.state.products.map((product, index) => {
                    return (
                        <div>
                       <Container className={classes.cardGrid} maxWidth="large">
                       <Grid item xs={6} container spacing={8}>
                    <Card  className={classes.card} variant="outlined" key ={index}>
                    <img src={product.imgUrl} height="300px" width="350px" alt={product.name}/>
                    <CardContent  className={classes.cardContent}>
                        <Typography  variant="h3"  gutterBottom>  {product.name}</Typography>
                        <Typography  variant="h5">  {product.color}</Typography>
                        <Typography  variant="h4">{product.description}</Typography>
                        <Typography   variant="h5" color="black">Rs.{product.price}</Typography>
                        <Typography variant="h6" component="p">Stock: {product.quantity}<br/></Typography>
                    </CardContent>
                    <CardActions>
                        <Button  className={classes.heroButtons} size="medium" variant="contained" color="secondary" onClick={() => {this.handleDeleteUser(product.productId)}}>Delete</Button>
                        <Button  className={classes.heroButtons} size="medium" variant="contained" color="primary" onClick={() => {this.handleUpdateUser(product)}}>Update</Button>      
                         <Dialog open={this.state.open} onClose={this.handleClose} aria-labelledby="form-dialog-title">
                <DialogTitle id="form-dialog-title">Update Product</DialogTitle>
                <DialogContent>
                  <TextField
                    margin="dense"
                   // id="productId"
                    name="productId"
                    label="Product Id"
                    type="number"
                    value={this.state.productId}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <Grid container>
                  <Grid item md={12}>
                  <TextField
                    margin="dense"
                    id="name"
                    name="name"
                    label="Product name"
                    type="text"
                    value={this.state.name}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <TextField
                    margin="dense"
                    id="color"
                    name="color"
                    label="Product color"
                    type="text"
                    value={this.state.color}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <TextField
                    margin="dense"
                    id="price"
                    name="price"
                    label="Product price"
                    type="number"
                    value={this.state.price}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <TextField
                    margin="dense"
                    id="description"
                    name="description"
                    label="Product description"
                    type="text"
                    value={this.state.description}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <TextField
                    margin="dense"
                    id="quantity"
                    name="quantity"
                    label="Product quantity"
                    type="number"
                    value={this.state.quantity}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  <TextField
                    margin="dense"
                    id="category"
                    name="category"
                    label="Product category"
                    type="text"
                    value={this.state.category}
                    onChange={this.handleChange}
                    //fullWidth
                  />

                  <TextField
                    margin="dense"
                    id="imgUrl"
                    name="imgUrl"
                    label="Image URL"
                    type="text"
                    value={this.state.imgUrl}
                    onChange={this.handleChange}
                    //fullWidth
                  />
                  </Grid>
                  </Grid>
                </DialogContent>
                <p  style = {{color:'red'}}>{this.state.errorMsg !== "" ? this.state.errorMsg : null}</p>

                <DialogActions>
                    <Button onClick={this.handleClose} color="primary" variant= "contained">
                      Cancel
                    </Button>            
                    <Button onClick={this.handleSubmit} color="primary" variant= "contained">
                      Update
                    </Button>
                </DialogActions>
              </Dialog>            
                    </CardActions>
                    
                    </Card>
                    </Grid>
                  </Container>
                    </div>
                )})}
            </div>
        )
    }
}

export default (withStyles(styles)(ViewAllProduct));