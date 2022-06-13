import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';


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
  });

function RenderAllProducts (props) {
    const classes = useStyles();  

    return (
        <Card className={classes.root} variant="outlined" key={props.index}>
            <img src={props.product.imgUrl} height="200px" width="400px" alt={props.product.name}/>
            <CardContent>
                <Typography className={classes.title} variant="h5"  gutterBottom>{props.product.name}</Typography>
                <Typography  component="h2">{props.product.description}</Typography>
                <Typography className={classes.pos} color="textSecondary">{props.product.price}</Typography>
                <Typography variant="body2" component="p">{props.product.quantity}<br/></Typography>
            </CardContent>
            <CardActions>
                <Button size="small" variant="outlined" color="primary">Add to cart</Button>
            </CardActions>
        </Card>
    )
}

export default RenderAllProducts