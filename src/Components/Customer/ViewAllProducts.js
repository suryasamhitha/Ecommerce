import React,{ useEffect, useState } from 'react'
import getAllProducts from '../../Service/AdminService';
import { UncontrolledCarousel, Row, Col } from "reactstrap";
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import ButtonBase from '@material-ui/core/ButtonBase';
// import './CSS/cards.css'
import InputBase from '@material-ui/core/InputBase'
import { fade } from '@material-ui/core/styles'
import SearchIcon from '@material-ui/icons/Search'; 
import AdminService from '../../Service/AdminService';
import CustomerNavbar from "../Navbar"
// import Footer from '../Footer/Footer';

const ALL = '';
const SOFA_AND_DINING = 'Sofa and Dining';
const BEDS_AND_WARDROBES = 'Beds and Wardrobes';
const HOME_DECOR = 'Home Decor';
const KIDS_FURNITURE = 'Kids Furniture';
const STORAGE_SOLUTIONS = 'Storage Solutions';
const OUTDOOR = 'Outdoor Furniture';

  const images = [
    {
      url: 'https://w0.peakpx.com/wallpaper/59/435/HD-wallpaper-modern-interior-design-stylish-apartments-living-room-kitchen-dining-room-black-furniture-in-the-kitchen-large-round-mirror-gray-sofa-in-the-living-room.jpg',
      title: 'Sofa and Dining',
      width: '33%',
      height:'15%',
      value: SOFA_AND_DINING
    },
    {
      url: 'https://i.pinimg.com/originals/5b/81/cc/5b81cc91d349113a0390652146b38e75.jpg',
      title: 'Beds and Wardrobes',
      width: '33%',
      value: BEDS_AND_WARDROBES
    },
    {
      url:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDM5FJSGxd0dhb3Op_0DJNylFCd4wyakJNfA&usqp=CAU',
      title: 'Home Decor',
      width: '33%',
      value:  HOME_DECOR
    },
    
    {
      url: 'https://thumbs.dreamstime.com/b/patterned-teepee-standing-bright-kids-room-interior-white-bed-mountain-wallpaper-powder-pink-carpet-teepee-kids-115039149.jpg',
      title: 'Kids Furniture',
      width: '33%',
      value: KIDS_FURNITURE
    },
    {
      url: 'https://i.pinimg.com/736x/bd/20/4c/bd204cf36564633b2f2e819d932559d4--desk-storage-bedroom-storage.jpg',
      title: 'Storage Solutions',
      width: '33%',
      value: STORAGE_SOLUTIONS
    },
    {
      url: 'https://images.unsplash.com/photo-1613685302957-3a6fc45346ef?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8b3V0ZG9vciUyMGZ1cm5pdHVyZXxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80',
      title: 'Outdoor Furniture',
      width: '33%',
      value: OUTDOOR
    },
  ];
  
  const useStyles = makeStyles((theme) => ({
    root: {
        position:'center',
      display: 'center',
      flexWrap: 'wrap',
      minWidth: 300,
      width: '100%',
      
    },
    image: {
      position: 'relative',
      height: 400,
      [theme.breakpoints.down('xs')]: {
        width: '100% !important', 
        height: 100,
      },
      '&:hover, &$focusVisible': {
        zIndex: 1,
        '& $imageBackdrop': {
          opacity: 0.15,
        },
        '& $imageMarked': {
          opacity: 0,
        },
        '& $imageTitle': {
          border: '4px solid currentColor',
        },
      },
    },
    focusVisible: {},
    imageButton: {
      position: 'absolute',
      left:0,
      right:0,
      top: 0,
      bottom: 0,
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
      color: theme.palette.common.white,
    },
    imageSrc: {
      position: 'absolute',
      left: 20,
      right: 20,
      top: 20,
      bottom: 20,
      backgroundSize: 'cover',
      backgroundPosition: 'center 40%',
    },
    imageBackdrop: {
      position: 'absolute',
      left: 20,
      right: 20,
      top: 20,
      bottom: 20,
      backgroundColor: theme.palette.common.black,
      opacity: 0.4,
      transition: theme.transitions.create('opacity'),
    },
    imageTitle: {
      position: 'relative',
      padding: `${theme.spacing(2)}px ${theme.spacing(4)}px ${theme.spacing(1) + 6}px`,
    },
    imageMarked: {
      height: 3,
      width: 18,
      
      backgroundColor: theme.palette.common.white,
      position: 'absolute',
      bottom: -2,
      left: 'calc(50% - 9px)',
      transition: theme.transitions.create('opacity'),
    },
    divHeight: {
      position: 'relative',
      bottom: '2px',
      marginTop: '30px'
    },
    search: { 
   
      position: 'relative',
      //borderRadius: theme.shape.borderRadius,
      border: '1px',
      borderStyle:'solid',
      borderColor: 'grey',
      borderRadius: '5px',
      backgroundColor: fade(theme.palette.common.white, 0.85),
      '&:hover': {
        backgroundColor: fade(theme.palette.common.white, 0.25),
      },
      marginRight: theme.spacing(2),
      marginLeft:  theme.spacing(2),
      width: '450%',
      height:'40px',
      [theme.breakpoints.up('sm')]: {
        marginLeft: theme.spacing(3),
        width: '500px',
      },
      marginTop:'20px',
      marginBottom:'15px',
      left: '28%',
      elevation:'5',
      shadowColor: '#000',
      shadowOffset: {width: 0, height: 2},
            shadowOpacity: 0.5,
            shadowRadius: 5,
      
    },
    searchIcon: {                                                     //search
      
      padding: theme.spacing(0, 2),
      height: '100%',
      position: 'absolute',
      pointerEvents: 'none',
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'center',
    },
  
    inputRoot: {                                                      //search
      color: 'inherit',
      
    },
    inputInput: {                                                    //search
      padding: theme.spacing(1, 1, 1, 0),
      // vertical padding + font size from searchIcon
      paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
      transition: theme.transitions.create('width'),
      width: '100%',
      [theme.breakpoints.up('md')]: {
        width: '50ch',
      },
    },
  
  }));
export default function ViewAllProducts() {
    const classes = useStyles()
    const [category, setCategory] = useState(ALL);
    const [products, setProducts] = useState([])
    const [selectedProduct, setSelectedProduct] = useState([])
    const service = new AdminService();

    
    useEffect(() => {
        async function fetchData() {
        service.getAllProducts().then((res)=>{
                setProducts(res)
            })
             
        }
        
        fetchData()
    }, []);
    
    const updateSearch = (event) => {
    
        setCategory(ALL)
        const productList = [...products]
        let updatedList;
        console.log(event.target.value,"value")
        updatedList = productList.filter(product => {
            if(product.name.toLowerCase().includes(event.target.value.toLowerCase())){
                
                return product;
            }
            else{
                return null
            }
        })
        setSelectedProduct(updatedList)
    }


    const addToCart = (product) => {
      
        let initialCart = JSON.parse(localStorage.getItem("cart") || "[]")
         console.log(initialCart)
          let itemInCart = initialCart.find(
            (item) => product.name === item.name
          );
          if (itemInCart) {
            itemInCart.quantity++;
          } else {
            itemInCart = {
              ...product,
              quantity: 1,
            };
            initialCart.push(itemInCart);
          }
          localStorage.setItem("cart",JSON.stringify(initialCart))
      };

      
    const getProductsInCategory = () => {
        console.log(category)
        return products.filter(
          (product) => product.category === category
        );
    };
    let renderProduct
    if(selectedProduct.length>0)
    {
        renderProduct = 
        <div>
            {selectedProduct.map((product, index) => {
            return (
            <div className="cardStyle">
                    <Card  variant="outlined" key={index}>
                        <img src={product.imgUrl} height="200px" width="350px" alt={product.name}/>
                    <CardContent>
                        <Typography  variant="h5"  gutterBottom>{product.name}</Typography>
                        <Typography  component="h2">{product.description}</Typography>
                        <Typography  color="textSecondary">Rs.{product.price}</Typography>
                        <Typography variant="body2" component="p">Only {product.quantity} left<br/></Typography>
                    </CardContent>
                    <CardActions>
                        <Button size="small" variant="outlined" color="primary" onClick={() => addToCart(product)}>Add to cart</Button>
                    </CardActions>
                    </Card>
            </div>)
            })}
        </div>
    }
    else
    {
    renderProduct = 
    <div>
        {products.map((product, index) => {
            return (
                <div className = "cardStyle">
                    <Card  variant="outlined" key={index}>
                        <img src={product.imgUrl} height="200px" width="350px" alt={product.name}/>
                    <CardContent>
                        <Typography  variant="h5"  gutterBottom>{product.name}</Typography>
                        <Typography  component="h2">{product.description}</Typography>
                        <Typography  color="textSecondary">Rs.{product.price}</Typography>
                        <Typography variant="body2" component="p">Only {product.quantity} left<br/></Typography>
                    </CardContent>
                    <CardActions>
                        <Button size="small" variant="outlined" color="primary" onClick={() => addToCart(product)}>Add to cart</Button>
                    </CardActions>
                    </Card>
                </div>
        )})}
    </div>
    }
    let renderProductCategory=[]
    if(category !== ALL)
    {
        renderProductCategory = 
        <div>
        {getProductsInCategory().map((product, index) => {
        return (
        <div className = "cardStyle"
        style = {{
          backgroundImage:
              "url(https://images.unsplash.com/photo-1458682625221-3a45f8a844c7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1074&q=80)",
              backgroundRepeat: "no-repeat",
              backgroundSize: "cover",
              backgroundPosition: "center",
              height: "100%",
              opacity: 0.9, 
        }}>
           
                <Card  variant="outlined" key={index} style={{ width: '30rem' }}>
                    <img src={product.imgUrl} height="200px" width="350px" alt={product.name}/>
                <CardContent>
                    <Typography  variant="h5"  gutterBottom>{product.name}</Typography>
                    <Typography  component="h2">{product.description}</Typography>
                    <Typography  color="textSecondary">Rs.{product.price}</Typography>
                    <Typography variant="body2" component="p">Only {product.quantity} left<br/></Typography>
                </CardContent>
                <CardActions>
                    <Button size="medium" variant="contained" color="#65ADA3" onClick={() => addToCart(product)} href="/customer/cart">Add to cart</Button>
                </CardActions>
                </Card>
            </div>
        
        )})}
    </div>
    }

    return(
        <div  style = {{
      backgroundImage:
          "url(https://images.unsplash.com/photo-1458682625221-3a45f8a844c7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1074&q=80)",
          backgroundRepeat: "no-repeat",
          backgroundSize: "cover",
          backgroundPosition: "center",
          height: "100%",
          opacity: 0.9, 
    }}>
          <CustomerNavbar/>
          <header>

      
      <div display="inline-block">
      {images.map((image) => (
          <ButtonBase focusRipple key={image.title} className={classes.image} onClick={() => setCategory(image.value)} focusVisibleClassName={classes.focusVisible} style={{width: image.width,}}>
          <span className={classes.imageSrc} style={{ backgroundImage: `url(${image.url})`,}}/>
          <span className={classes.imageBackdrop} />
          <span className={classes.imageButton}>
              <Typography component="span" variant="subtitle1" color="initial" className={classes.imageTitle}>
              {image.title}
              <span className={classes.imageMarked} />
              </Typography>
          </span>
          </ButtonBase>
      ))}
      </div>
      </header>
      <div className={classes.search} >                               
        <div className={classes.searchIcon}>
        <SearchIcon  position="absolute" />
         </div>
         <InputBase
                placeholder="Search…your Product"
                classes={{
                  root: classes.inputRoot,
                  input: classes.inputInput,  
                }}
                inputProps={{ 'aria-label': 'search' }}
                onChange={updateSearch}
              />
         </div>
              <div>
                {category === ALL ? renderProduct : renderProductCategory}                 
      </div> 
        </div>
    )
    
}