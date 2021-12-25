import React from "react";
import {Paper} from '@mui/material';
import Header from "../../Header/Header.js";
import EmptyBox from "../../MUIComponents/EmptyBox"
import { borderRadius } from "@mui/system";

const CourseBox = () => {
    return (
        <>
            <Header/>

            <EmptyBox value={20}/>

            <Paper
                elevation = {12}
                style={{
                    padding: 100,
                    backgroundColor: "white",
                    border: "1px solid black",
                    borderRadius: 10
                }}
            >  
            Selam

            </Paper>
        </>
    )
}

export default CourseBox;