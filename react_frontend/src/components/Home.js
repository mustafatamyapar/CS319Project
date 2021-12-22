import React from "react";
import {Avatar,Box, Button, Container, Grid, Link, TextField, Typography} from '@mui/material';
import MyCourses from '../images/pageIcons/my_courses_icon.png'
import HealthStatus from '../images/pageIcons/health_status_logo.png'
import DailyCheckForm from '../images/pageIcons/form_icon.png'
import DormInfo from '../images/pageIcons/dorm.png'
import RoomHistory from '../images/pageIcons/room_history_icon.png'
import MyProfile from '../images/pageIcons/my_profile_icon.png'
import GymInfo from '../images/pageIcons/gym.png'

// Components
import Header from "./Header/Header.js";

// Hooks
// Images


const Home = () => {
    return (
        <>
            <Header/>
            <Grid
                container
                spacing = {12}
                direction="row"
                justifyContent="space-evenly"
                alignItems="flex-end"
                style={{minHeight:'50vh'}}>
                
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

            <Grid
                container
                spacing = {12}
                direction="row"
                justifyContent="space-evenly"
                alignItems="flex-end"
                style={{minHeight:'40vh'}}>
                
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