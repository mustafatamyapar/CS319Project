import * as React from 'react';
import {useState} from 'react';
import {Box, Button, Container, Grid, Link, TextField, Typography} from '@mui/material';
import Image from '../../images/logo.png'
import {signInWithEmailAndPassword} from 'firebase/auth';
import {auth} from '../../firebase-config.js'

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
    const [loginEmail, setLoginEmail] = useState("");
    const [loginPassword, setLoginPassword] = useState("");
    const [loginSuccess, setLoginSuccess] = useState(false);

    const login = async () => {
        try {
            const user = await signInWithEmailAndPassword(
                auth, 
                loginEmail,
                loginPassword
            );
            setLoginSuccess(true);
            console.log(user, loginSuccess);
        }
        catch(error) {
            console.log(error.message);
            setLoginSuccess(false);
        }
    };


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
                    <Typography font align="center" component="h1" variant="h5">
                        Log In
                    </Typography>
                </Grid>
                <Grid item xs={12}>
                    <TextField onChange={(event) =>{setLoginEmail(event.target.value)}} style = {{width:350}} id="outlined-basic" label="E-Mail/Bilkent ID" variant="outlined" />
                </Grid>
                <Grid item xs={12} >
                    <TextField onChange={(event) =>{setLoginPassword(event.target.value)}} style = {{width:350}} id="outlined-basic" label="Password" type="password" variant="outlined" />
                </Grid>
                <Grid item xs={12}>
                    <Button
                        href={loginSuccess ? "/home" : ""}
                        onClick={login}
                        type="submit"
                        color="secondary"
                        style = {{width:350}}
                        variant="contained">
                        Log In
                    </Button>
                </Grid>
            </Grid>

            <Grid container
                  spacing = {10}
                  direction="row"
                  justifyContent="center"
                  alignItems="flex-start">

                <Grid item>
                    <Link href="/forgotpassword" variant="body2">
                        Forgot password?
                    </Link>
                </Grid>
                <Grid item>
                    <Link href="/signup" variant="body2">
                        Create an account!
                    </Link>
                </Grid>
            </Grid>
            <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
    );
}