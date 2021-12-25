import Header from "../Header/Header";
import {Box, FormControl, FormControlLabel, FormLabel, Grid, Radio, RadioGroup, Typography} from "@mui/material";
import React, {useState} from "react";
import {onAuthStateChanged} from "firebase/auth";
import {auth} from "../../firebase-config";

const HealthStatus = () => {
    const [user, setUser] = useState({});
    const [selection, setSelection] = useState(-1);

    onAuthStateChanged(auth, (currentUser) => {
        setUser(currentUser)
    })

    const handleSelection = (i) => {
        setSelection(i);
    };

    // will be asked from user
    const array = [
        {name: "Rachel Avery", course: "CS453", section: "02"},
        {name: "Andrea Hemmings", course: "CS453", section: "01"},
        {name: "Bernadette Howard", course: "CS319", section: "02"},
        {name: "Thomas MacLeod", course: "CS315", section: "03"},
        {name: "Isaac Hemmings", course: "CS315", section: "02"},
        {name: "Kylie Macleod", course: "CS202", section: "03"},
        {name: "Michael Peters", course: "CS201", section: "03"},
        {name: "Fiona Roberts", course: "CS201", section: "05"},
        {name: "Megan Davies", course: "CS319", section: "02"}
    ];

    return (
        <>
            <Header/>
            <Grid container direction="row" padding={5} justifyContent="space-around">
                <Grid item>
                    <Grid container direction="column">
                        <Grid item borderBottom={1} >
                            <Typography sx={{fontFamily: "Poppins", fontSize: 24}}>
                                Health Status
                            </Typography>
                        </Grid>

                        <Grid item paddingTop={3} paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Covid State
                                    </Typography>
                                </Grid>
                                <Grid item >
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        Safe
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Has been sick or carrier before
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        No
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Quarantine Period
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        Not in quarantine
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Vaccination
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        Fully vaccinated
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Covid Test
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        No
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Valid Until
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        -
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item paddingBottom={5}>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Click
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 18}}>
                                        to upload test result
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                        <Grid item>
                            <Grid container direction="row" alignItems="baseline">
                                <Grid item paddingRight={1}>
                                    <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                        Permission to enter campus
                                    </Typography>
                                </Grid>
                                <Grid item>
                                    <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                        Yes
                                    </Typography>
                                </Grid>
                            </Grid>
                        </Grid>

                    </Grid>
                </Grid>
                {(1 || (user.type === "healthstuff"))
                    ? <Grid item>
                        <Grid container direction="column" paddingLeft={5}>
                            <Grid item borderBottom={1}>
                                <Typography sx={{fontFamily: "Poppins", fontSize: 24}}>
                                    Select a user
                                </Typography>
                            </Grid>
                            <Box margin={1}/>
                            <Grid item padding={3} border={2} borderRadius={3}>
                                <FormControl component="fieldset">
                                    <FormLabel style={{fontWeight: 600, fontSize: 20, fontFamily:"Poppins"}} component="legend">
                                        Full Name | Course | Section
                                    </FormLabel>
                                    <Box margin={1}/>
                                    <RadioGroup aria-label="state">
                                        {Array.from({length: array.length}, (_, i) =>
                                            (<Grid item paddingTop={1}> <FormControlLabel control={<Radio onClick={() => {
                                                handleSelection(i)
                                            }} defaultValue={0}/>}
                                                                                          label={array[i]["name"] + " | " + array[i]["course"] + " | " + array[i]["section"]}
                                                                                          value={i}/> </Grid>)
                                        )}
                                    </RadioGroup>
                                </FormControl>
                                {/*sx={{
                                    '&:hover': {
                                    margin: 0.6,
                                },
                                }}*/}
                            </Grid>
                        </Grid>
                    </Grid>
                    : null}
                {(1 || (user.type === "healthstuff")) && (selection >= 0) ? (<Grid item>
                        <Grid container direction="column" paddingLeft={5}>
                            <Grid item borderBottom={1}>
                                <Typography sx={{fontFamily: "Poppins", fontSize: 24}}>
                                    {(selection >= 0) ? array[selection]["name"] + "'s Health Status" : "Select a student"}
                                </Typography>
                            </Grid>

                            <Grid item paddingTop={3} paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Covid State
                                        </Typography>
                                    </Grid>
                                    <Grid item >
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            Safe
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Has been sick or carrier before
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            No
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Quarantine Period
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            Not in quarantine
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Vaccination
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            Fully vaccinated
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Covid Test
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            No
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Valid Until
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            -
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item paddingBottom={5}>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Click
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 18}}>
                                            to upload test result
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                            <Grid item>
                                <Grid container direction="row" alignItems="baseline">
                                    <Grid item paddingRight={1}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                            Permission to enter campus
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{color: "#ab47bc", fontFamily: "Poppins", fontSize: 18}}>
                                            Yes
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>

                        </Grid>
                    </Grid>)
                    : null}
            </Grid>
        </>
    );
}

export default HealthStatus



