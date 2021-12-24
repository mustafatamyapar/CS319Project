import * as React from 'react';
import {Grid,Paper, Typography} from '@mui/material';
import CustomCircularProgress from './CustomCircularProgress.js';

function GymRoom(props) {
    return (
        <Paper sx={{ width: 470, p: 2, margin: 'auto', maxWidth: 500, flexGrow: 1 }}>
            <Grid container spacing={2}>
                <Grid item xs={12} sm container>
                    <Grid item xs container direction="column" spacing={2}>
                        <Grid item xs>
                            <Typography gutterBottom variant="subtitle1" component="div">
                                {props.room}
                            </Typography>
                            <Typography variant="body2" gutterBottom>
                                {props.people}
                            </Typography>
                        </Grid>
                    </Grid>
                    <Grid item>
                        <Typography variant="subtitle1" component="div">
                            <CustomCircularProgress value={props.percentage}/>
                        </Typography>
                    </Grid>
                </Grid>
            </Grid>
        </Paper>
    )
}

export default GymRoom;
