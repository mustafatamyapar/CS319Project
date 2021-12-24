import * as React from 'react';
import {Box,Accordion,AccordionSummary,AccordionDetails,Link,Typography} from '@mui/material';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import Header from '../../Header/Header.js'
import EmptyBox from '../../MUIComponents/EmptyBox.js';

export default function GymInfo() {
    return (
        <>
            <Header/>

            <EmptyBox value={15}/>
            <Typography size = '12' font align="center" component="h1" variant="h6">
                Gym Info
            </Typography>
        
        
            <Box sx={{ marginTop: 10, 
                display: 'flex', 
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center' }}>
                
                <Accordion>
                    <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    sx={{ width: 500 }}
                    >
                    <Typography>MAIN CAMPUS SPORTS FACILITIES</Typography>
                    </AccordionSummary>
                    <AccordionDetails>
                    <Box sx={{ display: 'flex', 
                            flexDirection: 'column'}}>
                        <Link href={1 ? "/maindormsports" : "/*"} underline="hover">
                            {"Dormitories Sports Hall"}
                        </Link>
                        <Link href={1 ? "/mainsports" : "/*"} underline="hover">
                            {"Main Sports Hall"}
                        </Link>
                        <Link href={1 ? "/mainopenairsports" : "/*"} underline="hover">
                            {"Open-Air Sports Facilities"}
                        </Link>
                    </Box>
                    </AccordionDetails>
                </Accordion>

                <Accordion>
                    <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel2a-content"
                    id="panel2a-header"
                    sx={{ width: 500 }}
                    >
                    <Typography>EAST CAMPUS SPORTS FACILITIES</Typography>
                    </AccordionSummary>
                    <AccordionDetails>
                    <Box sx={{ display: 'flex', 
                            flexDirection: 'column'}}>
                    
                        <Link href={1 ? "/eastsports" : "/*"} underline="hover">
                            {"East Sports Hall"}
                        </Link>
                        <Link href={1 ? "/eastopenairsports" : "/*"} underline="hover">
                            {"Open-Air Sports Facilities"}
                        </Link>
                    </Box>
                    </AccordionDetails>
                </Accordion>

            </Box>

        </>
    )
}