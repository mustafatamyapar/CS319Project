import React, {useState} from "react";
import {Grid, Typography} from '@mui/material';
import Header from "../../Header/Header.js";
import StudentCourses from "../../../courses.json"
import CourseBox from "./CourseBox";
import SeatingPlan from "./SeatingPlan";

const MyCourses = () => {
    const [clickedSP, setClickedSP] = useState(Array.from({length: Object.keys(StudentCourses["21901841"]["courses"]).length}, (_, i) => false));
    const [requests, setRequests] = useState(Array.from({length: Object.keys(StudentCourses["21901841"]["courses"]).length}, (_, i) => false))
    const [selectedSeats, setSelectedSeats] = useState(Array.from({length: Object.keys(StudentCourses["21901841"]["courses"]).length}, (_, i) => 0));

    const [dummy, setDummy] = useState(false);

    const getSelectedSeat = (i, id) => {
        let temp = selectedSeats;
        temp[id] = i
        setDummy(i);
    };

    return (
        <>
            <Header/>
            {/* Columns */}
            <Grid container direction="row">
                <Grid item>
                    <Grid container direction="column" paddingTop={3} paddingLeft={3}>
                        <Grid item borderBottom={1}>
                            <Typography sx={{fontFamily: "Poppins", fontSize: 24}} paddingLeft={3}>
                                My Courses
                            </Typography>
                        </Grid>
                        <Grid item>
                            {Array.from({length: Object.keys(StudentCourses["21901841"]["courses"]).length}, (_, i) =>
                                (<CourseBox id={i}
                                            course={StudentCourses["21901841"]["courses"][i.toString()]}
                                            callback={(id) => {
                                                let temp = clickedSP;
                                                temp[id] = !clickedSP[i];
                                                setClickedSP(temp);
                                                setDummy(!dummy);
                                            }}
                                            isRequest={requests[i]}
                                            selectedSeat={selectedSeats[i]}/>)
                            )}
                        </Grid>
                    </Grid>
                </Grid>
                <Grid item>
                    <Grid container direction="column">
                        {Array.from({length: Object.keys(StudentCourses["21901841"]["courses"]).length}, (_, i) => (
                            clickedSP[i]
                                ? <Grid item padding={3} paddingTop={10.5}>
                                    <SeatingPlan studentId={"21901841"} id={i} callback={getSelectedSeat}/>
                                </Grid>
                                : null
                        ))}
                    </Grid>
                </Grid>

            </Grid>

        </>
    )
}

export default MyCourses;