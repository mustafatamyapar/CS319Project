import * as React from 'react';
import {Box,Typography} from '@mui/material';
import Header from '../../Header/Header.js'
import EmptyBox from '../../MUIComponents/EmptyBox.js';
import GymRoom from '../../MUIComponents/GymRoom.js';


export default function MainOpenAirSports() {
    return (
        <>
            <Header/>

            <EmptyBox value={15}/>
            <Typography size = '12' font align="center" component="h1" variant="h6">
                    Main Campus: Open-Air Sports Activities
            </Typography>

            <Box sx={{ marginTop: 10, 
                display: 'flex', 
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center' }}>
                
                <GymRoom room="Indoor Tennis Courts" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Mini Football Fields" people="People: 15/20" percentage={75}/>
                <GymRoom room="Open-Air Basketball/Voleyball Fields" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Outdoor Tennis Courts" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Regulation (olympic) size Grass Football Field" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Scate Park" people="People: 15/20" percentage={75}/>  
            </Box>

            <EmptyBox value={15}/>
        </>

    )
}