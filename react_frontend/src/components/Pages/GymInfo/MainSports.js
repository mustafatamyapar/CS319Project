import * as React from 'react';
import {Box,Typography} from '@mui/material';
import Header from '../../Header/Header.js'
import EmptyBox from '../../MUIComponents/EmptyBox.js';
import GymRoom from '../../MUIComponents/GymRoom.js';


export default function MainSports() {
    return (
        <>
            <Header/>

            <EmptyBox value={15}/>
            <Typography size = '12' font align="center" component="h1" variant="h6">
                    Main Campus: Main Sports Hall
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
                <GymRoom room="Multi-Purpose Program Studio" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Table Tennis" people="People: 15/20" percentage={75}/>  
            </Box>

            <EmptyBox value={15}/>
        </>

    )

}