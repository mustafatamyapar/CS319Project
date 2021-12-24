import React, {useState} from "react";
import Header from "../Header/Header";
import {Button, Grid, Stack, Typography} from "@mui/material";
import RadioButtonList from "../MUIComponents/RadioButtonList"
import {canSeeDormStudents} from "../../helpers";

const DormInfo = ({userType}) => {

    const [dorm, setDorm] = useState("50");
    const [floor, setFloor] = useState("1");
    const [student, setStudent] = useState("");

    return (
        <>
            <Header/>
            <Stack direction="column">
                <Typography padding={5} paddingBottom={0} style={{fontSize: 30, fontFamily: "Poppins"}}>Dorm Information</Typography>
                {["Debug: ",dorm, " - ", floor, " - ", student]}
                <Grid container alignItems="top" direction="row">
                    <Grid item alignItems="stretch" direction="column">
                        <RadioButtonList type={1} callback={setDorm}/>
                    </Grid>
                    <Grid item alignItems="stretch" direction="column">
                        <RadioButtonList type={2} callback={setFloor} dorm={dorm}/>
                    </Grid>

                    {canSeeDormStudents(userType)
                        ? <Grid item alignItems="stretch" direction="column">
                            <RadioButtonList type={3} callback={setStudent} dorm={dorm} floor={floor}/>
                        </Grid>
                        : null}
                </Grid>
                <Button
                    type="submit"
                    color="secondary"
                    style = {{width:350, fontFamily: "Poppins"}}
                    variant="contained">
                    Submit
                </Button>
            </Stack>
        </>
    );
}

export default DormInfo;