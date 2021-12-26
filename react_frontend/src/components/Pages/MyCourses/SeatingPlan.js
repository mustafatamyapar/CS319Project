import {Grid, Paper, Typography} from "@mui/material";
import course from "../../../courses.json"
import React, {useState} from "react";
import line from "../../../images/line.png"
import ChairAltIcon from '@mui/icons-material/ChairAlt';

const SeatingPlan = ({studentId, id, callback}) => {
    const [selectedSeat, setSelectedSeat] = useState(0);

    const updateSelectedSeat = (i) => {
        setSelectedSeat(i);
        callback(i, id);
    };

    return (
        <Paper
            elevation = {12}
            style={{
                width: 800,
                height: 444,
                padding: 15,
                backgroundColor: "white",
                border: "1px solid black",
                borderRadius: 10
            }}>
            <Grid container direction="column" justifyContent="space-between">
                <Grid item>
                    <Grid container direction="row" paddingBottom={2}>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 15, fontWeight: 600}}>
                                {course[studentId]["courses"][id.toString()]["id"]}
                            </Typography>
                        </Grid>
                        <Grid item>
                            <img src={line} alt="line" height={22}/>
                        </Grid>
                        <Grid item>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                Seating Plan
                            </Typography>
                        </Grid>
                    </Grid>
                </Grid>
                <Grid item paddingBottom={3}>
                    <Grid container direction="row" justifyContent="center" paddingBottom={2}>
                        <Grid item width={400}>
                            <Typography borderBottom={1} sx={{fontFamily: "Poppins", fontSize: 15, textAlign: "center" }}>
                                Instructor
                            </Typography>
                        </Grid>
                    </Grid>
                </Grid>
                <Grid item>
                    <Grid container direction="column" justifyContent="center" alignItems="center">
                        <Grid item>
                            <Grid container direction="row">
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(0)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(1)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(2)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(3)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(4)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(5)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(6)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(7)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(8)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(9)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(10)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(11)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(12)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(13)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(14)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                            </Grid>
                        </Grid>
                        <Grid item>
                            <Grid container direction="row">
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(15)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(16)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(17)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(18)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(19)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(20)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(21)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(22)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(23)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(24)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(25)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(26)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(27)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(28)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(29)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                            </Grid>
                        </Grid>
                        <Grid item>
                            <Grid container direction="row">
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(30)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(31)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(32)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(33)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(34)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(35)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(36)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(37)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(38)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(39)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(40)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(41)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(42)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(43)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(44)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                            </Grid>
                        </Grid>
                        <Grid item>
                            <Grid container direction="row">
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(45)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(46)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(47)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(48)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(49)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(50)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(51)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(52)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(53)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(54)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(55)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(56)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(57)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(58)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(59)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                            </Grid>
                        </Grid>
                        <Grid item>
                            <Grid container direction="row">
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(60)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(61)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(62)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(63)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(64)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(65)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(66)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(67)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(68)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(69)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(70)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(71)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(72)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(73)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                                <Grid item><ChairAltIcon onClick={() => {updateSelectedSeat(74)}} sx={{borderRadius: 2, height: 45, width: 45, '&:hover': {cursor: 'pointer', backgroundColor: "gray"}}} /></Grid>
                            </Grid>
                        </Grid>

                    </Grid>
                </Grid>
                <Grid item paddingTop={7}>
                    <Grid container direction="row" alignItems="flex-end" justifyContent="space-around">
                        <Grid item borderRadius={3} padding={0.5} onClick={() => {

                        }}
                              sx={{
                                  backgroundColor: "white",
                                  '&:hover': {
                                      cursor: 'pointer',
                                      backgroundColor: "gray"
                                  }
                              }}
                        >
                            <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                Swap Seats
                            </Typography>
                        </Grid>
                        <Grid item borderRadius={3} padding={0.5}
                              sx={{
                                  backgroundColor: "white",
                                  '&:hover': {
                                      cursor: 'pointer',
                                      backgroundColor: "gray"
                                  }
                              }}
                        >
                            <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                Select Seat
                            </Typography>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </Paper>
    );
};

export default SeatingPlan;
