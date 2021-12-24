import * as React from 'react';
import {Grid, Paper, Box,Typography} from '@mui/material';
import Header from '../../Header/Header.js'
import EmptyBox from '../../MUIComponents/EmptyBox.js';
import CustomCircularProgress from '../../MUIComponents/CustomCircularProgress.js';
import GymRoom from '../../MUIComponents/GymRoom.js';


export default function GymInfo() {
    return (
        <>
            <Header/>

            <EmptyBox value={15}/>
            <Typography size = '12' font align="center" component="h1" variant="h6">
                    Main Campus: Dormitories Sports Hall
            </Typography>

            <Box sx={{ marginTop: 10, 
                display: 'flex', 
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center' }}>
                
                <GymRoom room="Archery Polygon (Indoor)" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Basketball, Volleyball Courts" people="People: 15/20" percentage={75}/>
                <GymRoom room="Fitness/Conditioning Room" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Group Exercises Studio" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Martial Arts Studio" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Swimming Pool (semi-olympic)" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Table Tennis" people="People: 15/20" percentage={75}/>  
                <GymRoom room="Walking/Running Track" people="People: 15/20" percentage={75}/>  
            </Box>

            <EmptyBox value={15}/>
        </>

    )

}