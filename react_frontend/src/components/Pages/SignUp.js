import * as React from 'react';
import {Box, Button, Container, Grid, Link, TextField, Typography} from '@mui/material';
import Image from '../../images/logo.png'

const SignUp = () => {
  return (
    <Container component="main" maxWidth="xs" >
      <Box
        sx={{
          marginTop: 10,
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
        }}>
        <img src={Image} alt="image"/>
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
            Create a New Account
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <TextField required style = {{width:350}} id="outlined-basic" label="Name Surname" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <TextField required style = {{width:350}} id="outlined-basic" label="E-Mail" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <TextField required style = {{width:350}} id="outlined-basic" label="Bilkent ID" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <TextField required style = {{width:350}} id="outlined-basic" label="Phone Number" variant="outlined" />
        </Grid>
        <Grid item xs={12} >
          <TextField required style = {{width:350}} id="outlined-basic" label="Password" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <Button
            type="submit"
            color="secondary"
            style = {{width:350}}
            variant="contained">
              Create Account
          </Button>
        </Grid>
        <Grid item>
          <Link href="/login" variant="body2">
            Already have an account? Log In.
          </Link>
        </Grid>
      </Grid>

    </Container>
  );
}
export default SignUp;