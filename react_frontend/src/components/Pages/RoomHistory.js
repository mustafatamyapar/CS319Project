import React, {useState} from "react";
import {Box, Button, Grid, Link, Stack, TextField, Typography} from '@mui/material';
import {DataGrid} from '@mui/x-data-grid';
import Header from "../Header/Header.js";
import {fetchUser} from "../../helpers";
import Map from "../../images/map.png"
import AccordionGroup from "../MUIComponents/AccordionGroup";

const RoomHistory = ({userId}) => {
    const [date, setDate] = useState(Date())
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(false);
    const [selectRooms, setSelectRooms] = useState(false);

    const handleDate = (event) => {
        setDate(event.target.value)
    }

    // ! will be removed later
    if (!(user === null)) {
        setLoading(true);
        setUser(fetchUser(userId))
        setLoading(false);
    }

    const columns = [
        { field: 'building', headerName: 'Building', width: 120 },
        { field: 'room', headerName: 'Room', width: 120 },
    ];

    const userRows = [/*...user.rooms*/
        {id: 1, building: "A Building", room: "A-101"},
        {id: 2, building: "B Building", room: "B-101"},
        {id: 3, building: "Cafeterias", room: "Mozart"},
        {id: 4, building: "EA Building", room: "EA-101"},
        {id: 5, building: "G Building", room: "G-101"},
        {id: 6, building: "SA Building", room: "SA-201"},

    ];
    return (
        <>
            <Header/>
            <Grid display="flex">
                <Stack container xs={2} minWidth={320}
                       paddingTop={4} paddingLeft={4}
                       alignItems="center" direction="column">
                    <Stack alignItems="center" direction="row">
                        <Grid paddingRight={2}>
                            <Typography fontFamily="Poppins" fontSize={24}>
                                Room History
                            </Typography>
                        </Grid>
                        <Grid>
                            <Link onClick={() => {setSelectRooms(!selectRooms)}}
                                  variant="body2">
                                <Button>Select rooms</Button>
                            </Link>
                        </Grid>
                    </Stack>
                    <Grid container spacing={1} paddingTop={4} paddingLeft={1}
                          paddingBottom={2} display="flex"
                          justifyItems="center" alignItems="center" direction="row">
                        {/*<LocalizationProvider dateAdapter={DateAdapter}>
                        <DesktopDatePicker
                            label="Select a date"
                            inputFormat="dd/mm/yyyy"
                            value={date}
                            onChange={handleDate}
                            renderInput={(params) => <TextField>Hello</TextField>}
                        />
                    </LocalizationProvider>*/}
                        <TextField
                            id="outlined-basic"
                            label="Enter date"
                            variant="outlined"
                            value={date}
                            onInput={handleDate}
                        />
                    </Grid>
                    <div style={{ height: 640, width: '100%' }}>
                        <DataGrid
                            rows={userRows}
                            columns={columns}
                            pageSize={10}
                            rowsPerPageOptions={[10]}
                        />
                    </div>
                </Stack>
                {
                    selectRooms
                        ? <Grid paddingTop={9} paddingLeft={5}
                                paddingBottom={9} paddingRight={5}
                                width="100%">
                            <AccordionGroup/>
                            <Button
                                onClick={"do things"}
                                type="submit"
                                color="secondary"
                                style = {{width:100}}
                                variant="contained">
                                Submit
                            </Button>
                        </Grid>
                        : <Grid xs={9}>
                            <Box height={10}/>
                            <img src={Map} alt="bilkent-map" height={1000}/>
                        </Grid>
                }

            </Grid>
        </>
    )
}

export default RoomHistory;