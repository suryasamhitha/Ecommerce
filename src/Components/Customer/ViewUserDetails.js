import { Paper, Typography } from '@material-ui/core'
import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import CustomerNavbar from '../Navbar';

const useStyles = makeStyles((theme) => ({
    root: {
      display: 'flex',
      // flexWrap: 'wrap',
      '& > *': {
        margin: theme.spacing(2),
        width: theme.spacing(16),
        height: theme.spacing(16),
        flexGrow: 1,
        marginTop: 50,
      },
    },
  }));

function ViewUserDetails() {

    const classes = useStyles();

        return(

            <Paper elevation={7}>
               <CustomerNavbar />
                <Typography variant="h2" >Name: {localStorage.getItem("firstName")} {localStorage.getItem("lastName")}</Typography>
                <Typography color="textSecondary">Login ID: {localStorage.getItem("loginId")}</Typography>
                <Typography color="textSecondary">Mobile number: {localStorage.getItem("phoneNo")}</Typography>
                <Typography color="textSecondary">Email: {localStorage.getItem("email")}</Typography>
            </Paper>
        )   
    
}

export default ViewUserDetails