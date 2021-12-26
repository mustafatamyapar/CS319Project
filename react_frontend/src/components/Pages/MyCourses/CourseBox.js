import React, {useState} from "react";
import {Grid, Paper, Typography} from '@mui/material';
import Header from "../../Header/Header.js";
import Line from "../../../images/line.png"
import HourglassEmptyIcon from '@mui/icons-material/HourglassEmpty';

const CourseBox = ({id, callback, course, isRequest, selectedSeat}) => {
    const [request, setRequest] = useState(false);

    const handleClick = () => {
        callback(id);
    }

    return (
        <>
            <Grid container direction="row" padding={3}>
                <Grid item>
                    <Paper
                        elevation = {12}
                        style={{
                            width: 400,
                            height: 220,
                            padding: 15,
                            backgroundColor: "white",
                            border: "1px solid black",
                            borderRadius: 10
                        }}>
                        <Grid container direction="column" justifyContent="space-between"
                              width={400} height={220}>
                            <Grid item>
                                <Grid container direction="row" borderBottom={1} justifyContent="space-between">
                                    <Grid item>
                                        <Grid container direction="column">
                                            <Grid item>
                                                <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                                    {course["id"]}
                                                </Typography>
                                            </Grid>
                                            <Grid item>
                                                <Typography sx={{fontFamily: "Poppins", fontSize: 15, fontWeight: 600}}>
                                                    {course["title"]}
                                                </Typography>
                                            </Grid>
                                        </Grid>
                                    </Grid>
                                    {isRequest ? (<Grid item>
                                        <HourglassEmptyIcon/>
                                    </Grid>) : null}
                                </Grid>
                            </Grid>
                            <Grid item>
                                <Grid container direction="column" alignItems="center" justifyContent="space-evenly">
                                    <Grid item paddingBottom={3}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                            Section No: {course["section"]}
                                        </Typography>
                                    </Grid>
                                    <Grid item>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                            Instruction: {course["instructor"]}
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>
                            <Grid item>
                                <Grid container direction="row" alignItems="flex-end" justifyContent="space-between">
                                    <Grid item borderRadius={3} padding={0.5} onClick={() => {
                                        handleClick();
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
                                            Seating Plan
                                        </Typography>
                                    </Grid>
                                    <Grid item borderRadius={3} padding={0.5}>
                                        <Typography sx={{fontFamily: "Poppins", fontSize: 15}}>
                                            Selected seat: {selectedSeat}
                                        </Typography>
                                    </Grid>
                                </Grid>
                            </Grid>
                        </Grid>
                    </Paper>
                </Grid>
            </Grid>

        </>
    )
}

export default CourseBox;