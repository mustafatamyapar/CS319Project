import React from "react";
import {Box, Button, Grid, Typography,CircularProgress} from '@mui/material';
import Header from "../Header/Header.js";
import data from '../data.json'
import EmptyBox from "../MUIComponents/EmptyBox.js";
import CustomCircularProgress from "../MUIComponents/CustomCircularProgress.js";

const DailyFormDone = () => {
    return (
        <>
            <Header/>
            <Box sx={{ marginTop: 25, 
                    display: 'flex', 
                    flexDirection: 'column',
                    alignItems: 'center',
                    justifyContent: 'center' }}>  
                <Typography size = '12' font align="center" component="h1" variant="h6">
                    You have completed your Daily Check for today. 
                </Typography>
                <Typography size = '12' font align="center" component="h1" variant="h6">
                    Come back to this page when you visit campus again.
                </Typography>

                
                <EmptyBox value={5}/>
                <Typography size = '12' font align="center" component="h1" variant="h6">
                    Total points: {data.point}
                </Typography>
                <CustomCircularProgress value={data.point} />
            </Box>

        </>
    )
}

export default DailyFormDone