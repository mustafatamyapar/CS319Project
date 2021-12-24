import * as React from 'react';
import {Box,Typography} from '@mui/material';
import Header from '../../Header/Header.js'
import EmptyBox from '../../MUIComponents/EmptyBox.js';
import GymRoom from '../../MUIComponents/GymRoom.js';


export default function EastOpenAirSports() {
    return (
        <>
            <Header/>

            <EmptyBox value={15}/>
            <Typography size = '12' font align="center" component="h1" variant="h6">
                    East Campus: Open-Air Sports Facilities
            </Typography>

            <Box sx={{ marginTop: 10, 
                display: 'flex', 
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center' }}>
                
                <GymRoom room="Open-Air Basketball-Volleyball-Tennis Courts" people="People: 15/20" percentage={75}/> 
                <GymRoom room="Mini Football Fields" people="People: 15/20" percentage={75}/>
            </Box>

            <EmptyBox value={15}/>
        </>

    )

}