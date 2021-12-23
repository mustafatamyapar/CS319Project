import React from "react";
import {Radio, FormControl, FormLabel, FormControlLabel, RadioGroup,Avatar, Button, Grid, Box, Typography} from '@mui/material';
import Header from "../Header/Header.js";
import YesNoButton from "../MUIComponents/YesNoButtons.js"

const DailyForm = () => {
    return (
        <>
            <Header/>

            <Box
                sx={{
                    marginTop: 10,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}>
            </Box> 
            
            <Grid container
                spacing = {3}
                direction="column"
                justifyContent="center"
                alignItems="center">
                
                <Typography size = '12' font align="center" component="h1" variant="h6">
                    Daily Health Check Form
                </Typography>
                
                <Box sx={{ justifyContent: 'center' }}>
                    <Grid item xs={12}>
                        <Typography>Fever?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Cough?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Difficulty breathing or respiratory distress?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Throat ache?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Headache?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Muscle pain?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Chest/Back/Lower Back Pain?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Loss of taste and smell?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Diarrhea?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Has anyone been diagnosed with Covid-19 in your home?</Typography>
                        <YesNoButton/> 
                    </Grid>
                    <Grid item xs={12}>
                        <Typography>Has anyone been diagnosed with Covid-19 in your neighour? (apartment, site, etc.)</Typography>
                        <YesNoButton/> 
                    </Grid>
                </Box>
                
                <Box
                    sx={{
                        marginTop: 5,
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                    }}>
                </Box> 

                <Button
                    href={1 ? "/" : "/*"}
                    type="submit"
                    color="secondary"
                    style = {{width:350}}
                    variant="contained">
                    Submit Form
                </Button>
            </Grid>

            <Box
                sx={{
                    marginTop: 5,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}>
            </Box> 
        </>
    )
}

export default DailyForm;