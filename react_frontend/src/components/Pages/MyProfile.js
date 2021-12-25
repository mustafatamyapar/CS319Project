import React, {useEffect, useState} from "react";
import Header from "../Header/Header";
import {onAuthStateChanged} from "firebase/auth";
import {auth} from "../../firebase-config";
import {
    Accordion,
    AccordionDetails,
    AccordionSummary, Checkbox, FormControlLabel,
    FormGroup,
    Grid,
    Typography
} from "@mui/material";

import placeholderImage from "../../images/pageIcons/profileIcon.png"
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import {getStudents} from "../../helpers";
import Buildings from "../../BuildingData.json";

const MyProfile = () => {
    const [user, setUser] = useState({});
    const [selected, setSelected] = useState(null);
    const [students, setStudents] = useState({});

    useEffect(() => {
        if (1 || user !== null && user.type === "admin" && user.type === "healthstuff" && user.type === "schooladministrator") {
            setStudents(getStudents(user));
        }
    }, [user]);

    onAuthStateChanged(auth, (currentUser) => {
        setUser(currentUser)
    })
    console.log(students)

    return (
        <>
            <Header/>
            <Grid container direction="row" padding={3} justifyContent="space-evenly">
                <Grid item>
                    <Grid container direction="column"
                          width={300} alignItems="center" paddingRight={10}>
                        <Grid item>
                            <img src={/*url will get here*/placeholderImage}
                                 alt="placeholder" width={200}/>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 14}}
                            >Profile photo</Typography>
                        </Grid>
                        {(1 || user.type === "teacher")
                            ? <Grid item paddingTop={10} width={250}>
                                <Accordion >
                                    <AccordionSummary
                                        expandIcon={<ExpandMoreIcon/>}
                                        aria-controls="panel1a-content"
                                        id="panel1a-header">
                                        <Typography>{"See other profiles"}</Typography>
                                    </AccordionSummary>
                                    <AccordionDetails>
                                        <FormGroup>
                                            {
                                                Array.from({length: ((students === null) ? 0 : students.length)},
                                                    (_, i) => (
                                                        <FormControlLabel control={
                                                            <Typography paddingLeft={2}
                                                                onClick={() => {
                                                                    console.log(students[i])
                                                                }}
                                                                sx={{fontFamily: "Poppins"}}
                                                            >{students[i]}</Typography>
                                                        }
                                                                          label=""
                                                                          sx={{fontFamily: "Poppins"}}
                                                        />
                                                    ))}
                                        </FormGroup>
                                    </AccordionDetails>
                                </Accordion>
                            </Grid>
                        : null}
                    </Grid>
                </Grid>
                <Grid item paddingRight={5} paddingBottom={10}>
                    <Grid container direction="column">
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Full Name
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Burak Öztürk
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Bilkent ID
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                21901841
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Bilkent Mail
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={7}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                burak.ozturk@ug.bilkent.edu.tr
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Department
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Computer Science
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Semester
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                5th
                            </Typography>
                        </Grid>
                    </Grid>
                </Grid>
                <Grid item paddingRight={5} paddingBottom={10}>
                    <Grid container direction="column">
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Covid Status
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Safe
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Vaccination Status
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Fully vaccinated
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Covid Test Status
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={7}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Not tested recently
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                Allowed on Campus
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Yes
                            </Typography>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 20, fontWeight: 600}}>
                                User Type
                            </Typography>
                        </Grid>
                        <Grid item paddingBottom={5}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 16}}>
                                Student
                            </Typography>
                        </Grid>
                    </Grid>
                </Grid>
                <Grid item maxWidth={300}>
                    <Typography variant="h6" gutterBottom sx={{fontFamily: "Poppins", fontWeight: 600}}>
                        Description
                    </Typography>
                    <Typography variant="body1" gutterBottom sx={{fontFamily: "Poppins"}}>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos
                        blanditiis tenetur unde suscipit, quam beatae rerum inventore consectetur,
                        neque doloribus, cupiditate numquam dignissimos laborum fugiat deleniti? Eum
                        quasi quidem quibusdam.
                    </Typography>
                </Grid>
            </Grid>
        </>
    )

}

export default MyProfile