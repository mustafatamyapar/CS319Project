import React from "react";
import {Avatar, Button, Grid, Box} from '@mui/material';
import MyCourses from '../images/pageIcons/myCoursesIcon.png'
import HealthStatus from '../images/pageIcons/healthStatusIcon.png'
import DailyCheckForm from '../images/pageIcons/formIcon.png'
import DormInfo from '../images/pageIcons/dormIcon.png'
import RoomHistory from '../images/pageIcons/roomHistoryIcon.png'
import MyProfile from '../images/pageIcons/profileIcon.png'
import GymInfo from '../images/pageIcons/gymIcon.png'

// Components
import Header from "./Header/Header.js";

// Hooks
// Images


const Home = () => {
    return (
        <>
            <Header/>
            
			<Box
                sx={{
                    marginTop: 10,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}>
            </Box> 
			
			<Grid
                container
                spacing = {12}
                direction="row"
                justifyContent="space-evenly"
                alignItems="flex-end"
                style={{minHeight:'35vh'}}>
                
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={MyCourses} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    My Courses
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={HealthStatus} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    Health Status
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        href={1 ? "/dailyform" : "/*"}
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={DailyCheckForm} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    Daily Check Form
                    </Button>
                </Grid>                
            </Grid>
				
			<Box
                sx={{
                    marginTop: 20,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                }}>
            </Box> 	
			
            <Grid
                container
                spacing = {12}
                direction="row"
                justifyContent="space-evenly"
                alignItems="flex-end"
                style={{minHeight:'30vh'}}>
                
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={DormInfo} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    Dorm Info
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={RoomHistory} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    Room History
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={MyProfile} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    My Profile
                    </Button>
                </Grid>
                <Grid item>
                    <Button
                        variant="outlined"
                        color = "secondary"
                        style={{ background: '#EFE9F4' }}
                        sx={{color: 'black'}}
                        size = "large"
                        startIcon={<Avatar src={GymInfo} sx={{ width: 100, height: 100 }} variant="square"/>}>
                    Gym Info
                    </Button>
                </Grid>                
            </Grid>  
        </>
    );
}

export default Home;