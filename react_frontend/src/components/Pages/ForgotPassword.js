import * as React from 'react';
import {Box, Button, Container, Grid, Link, TextField, Typography} from '@mui/material';
import Image from '../../images/logo.png'

const ForgotPassword = () => {
  return (
    <Container component="main" maxWidth="xs" >
      <Box
        sx={{
          marginTop: 20,
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
          <Typography size = '12' font align="center" component="h1" variant="h6">
            Enter your email or Bilkent ID. You will receive a recovery email if the details are matched in the system.
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <TextField required style = {{width:350}} id="outlined-basic" label="E-Mail/Bilkent ID" variant="outlined" />
        </Grid>
        <Grid item xs={12}>
          <Button
            type="submit"
            color="secondary"
            style = {{width:350}}
            variant="contained">
              Send Recovery Email
          </Button>
        </Grid>
        <Grid item>
          <Link href="/" variant="body1">
            Back to Login Page
          </Link>
        </Grid>
      </Grid>
    </Container>
  );
}

export default ForgotPassword;