import React, {useState} from "react";
import Header from "../Header/Header";
import {Button, Grid, Stack, Typography} from "@mui/material";
import RadioButtonList from "../MUIComponents/RadioButtonList"
import {canSeeDormStudents, getBreakouts} from "../../helpers";

const DormInfo = ({userType}) => {

    const [dorm, setDorm] = useState("50");
    const [floor, setFloor] = useState("1");
    const [student, setStudent] = useState("");

    const [breakout, setBreakout] = useState({bOuts: 0, newBOuts: 0});

    const handleBreakouts = async (dorm) => {
        await setBreakout(getBreakouts(dorm));
    }

    return (
        <>
            <Header/>
            <Stack direction="column">
                <Typography padding={5} paddingBottom={0} style={{fontSize: 30, fontFamily: "Poppins"}}>Dorm Information</Typography>
                <Grid container alignItems="top" direction="row">
                    <Grid item alignItems="stretch" direction="column">
                        <RadioButtonList type={1} callback={setDorm} callback2={handleBreakouts}/>
                    </Grid>
                    <Grid item alignItems="stretch" direction="column">
                        <RadioButtonList type={2} callback={setFloor} dorm={dorm}/>
                    </Grid>

                    {canSeeDormStudents(userType)
                        ? <Grid item alignItems="stretch" direction="column">
                            <RadioButtonList type={3} callback={setStudent} dorm={dorm} floor={floor}/>
                        </Grid>
                        : null}
                    <Stack direction="column">
                        <Typography paddingTop={5} paddingBottom={0} style={{fontSize: 25, fontFamily: "Poppins"}}>Outbreak Information</Typography>
                        <Typography paddingTop={5} paddingBottom={0} style={{fontSize: 16, fontFamily: "Poppins"}}>
                            Dormitory {dorm} has {breakout["bOuts"]} breakout(s) since the start of the pandemic.
                        </Typography>
                        <Typography paddingTop={5} paddingBottom={5} style={{fontSize: 16, fontFamily: "Poppins"}}>
                            Last month there were {breakout["newBOuts"]} new positive test(s)
                        </Typography>
                        <Button
                            type="submit"
                            color="secondary"
                            style = {{width:350, fontFamily: "Poppins"}}
                            variant="contained">
                            Submit
                        </Button>
                    </Stack>
                </Grid>
            </Stack>
        </>
    );
}

export default DormInfo;