import * as React from 'react';
import {Box,Paper,Grid,TextField,Typography,Button,Link,Avatar,Container} from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Image from './logo.png'

function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="https://github.com/mustafatamyapar/CS319Project">
        Lovelace
      </Link>{' '}
    </Typography>
  );
}

export default function Login() {
  return (
    <Container component="main" maxWidth="xs" >
      <Box
        sx={{
          marginTop: 20,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}>
        <img src={Image} /> 
      </Box>
      
      <Grid
        container
        spacing = {2}
        direction = "column"
        justifyContent= "center"
        alignItems= "center"
        style={{minHeight:'40vh'}}>
          
        <Grid item xs={12}>
          <Typography font align="center" component="h1" variant="h5">
            Sign In
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <TextField style = {{width:350}} id="outlined-basic" label="E-Mail/ID" variant="outlined" />
        </Grid>
        <Grid item xs={12} >
          <TextField style = {{width:350}} id="outlined-basic" label="Password" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <Button
            type="submit"
            style = {{width:350}}
            variant="contained">
              Sign In
          </Button>
        </Grid>
      </Grid>
        
      <Grid container
        spacing = {10} 
        direction="row"
        justifyContent="center"
        alignItems="flex-start">

        <Grid item>
          <Link href="#" variant="body2">
             Forgot password?
          </Link>
        </Grid>
        <Grid item>
          <Link href="#" variant="body2">
            Create an account!
          </Link>
        </Grid>
      </Grid>
      <Copyright sx={{ mt: 8, mb: 4 }} />
    </Container>
  );
}