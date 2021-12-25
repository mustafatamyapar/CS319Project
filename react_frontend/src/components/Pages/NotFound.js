import React from "react";
import {Box, Typography} from '@mui/material';
import Header from "../Header/Header.js";
import Shark from "../../images/very_dangerous_shark.jpg";
import EmptyBox from "../MUIComponents/EmptyBox.js";

const NotFound = () => {
    return (
        <>
            <Header/>
            <EmptyBox value={10}/>
            <Typography size = '20' font align="center" component="h1"
                        variant="h4" sx={{fontFamily: "Poppins"}}>
                404 Not Found
            </Typography>
            <Box sx={{ marginTop: 5,
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    justifyContent: 'center' }}>
                
                <Typography size = '12' font align="center" component="h1"
                            variant="h6">
                    <img src={Shark} alt="logo"/>
                </Typography>
                <Typography size = '12' font align="center" component="h1"
                            variant="h6" sx={{fontFamily: "Ravie"}}>
                    Please return back before you get attacked by this very dangerous shark.
                </Typography>
            </Box>
            <EmptyBox value={20}/>
        </>
    )

}

export default NotFound;