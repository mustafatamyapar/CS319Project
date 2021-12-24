import React, {useState} from "react";
import {Box, Button, Grid, Link, Stack, TextField, Typography} from '@mui/material';
import {DataGrid} from '@mui/x-data-grid';
import Header from "../Header/Header.js";
import {fetchUser} from "../../helpers";
import Map from "../../images/map.png"

const RoomHistory = ({userId}) => {
    const [date, setDate] = useState(Date())
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(false);
    const [selectRooms, setSelectRooms] = useState(false);

    const [building, setBuilding] = useState(null);

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
        {id: 1, building: "EA Building", room: "EA-401"},
        {id: 2, building: "B Building", room: "Mozart Café"},
        {id: 3, building: "SA Building", room: "SA-201"},
        {id: 4, building: "G Building", room: "G-202"},
    ];

    const bColumn = [
        { field: 'building', headerName: 'Building', width: 120 },
    ]

    const bRows = [
        {id: 1, building: "A Building", rooms: ["A-101","A-102","A-103"]},
        {id: 2, building: "B Building", rooms: ["B-101","B-102","B-103"]},
        {id: 3, building: "Cafeterias", rooms: ["Mozart", "Coffee Break", "Bilka"]},
        {id: 4, building: "EA Building",  rooms: ["EA-101","EA-102","EA-103"]},
        {id: 5, building: "G Building", rooms: ["G-101","G-102","G-103"]},
        {id: 6, building: "SA Building",  rooms: ["SA-201", "SA-202", "SA-203"]},

    ];

    const rColumn = [
        { field: 'room', headerName: 'Room', width: 120 },
    ]

    let i = 100

    function roomMapper(roomName) {
        i++
        return {id: i, room: roomName}
    }

    let rRows = extractRooms();
    function extractRooms() {
        return (
            (bRows && building)
                ? [bRows[building[0]-1].rooms.map(roomMapper)]
                : null);
    }

    let buildingModel;
    return (
        <>
            <Header/>
            <Grid display="flex">
                <Stack container xs={2} minWidth={274}
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
                        ? <>
                            <Grid container xs={8} display="flex"
                                  paddingTop={4} paddingLeft={4}
                                  justifyItems="center" direction="column">
                                <Grid paddingRight={2}>
                                    <Typography variant="h6">
                                        Select rooms you have been today
                                    </Typography>
                                </Grid>
                                <Stack direction="row" display="flex"
                                justifyItems="end">
                                    <div style={{ height: 640, width: '30%' }}>
                                        <DataGrid
                                            rows={bRows}
                                            columns={bColumn}
                                            pageSize={10}
                                            rowsPerPageOptions={[10]}
                                            checkboxSelection
                                            selectionModel={buildingModel}
                                            onSelectionModelChange={(buildingModel) => {
                                                setBuilding(buildingModel);
                                            }
                                            }
                                        />
                                    </div>
                                    <div style={{ height: 640, width: '30%' }}>
                                        <DataGrid
                                            rows={rRows}
                                            columns={rColumn}
                                            pageSize={10}
                                            rowsPerPageOptions={[10]}
                                            checkboxSelection
                                            onSelectionModelChange={() => {

                                            }
                                            }
                                            onCellClick={() => {
                                                console.log("hi")
                                            }
                                            }
                                        />
                                    </div>
                                    <div style={{ height: 640, width: '30%' }}>
                                        <DataGrid
                                            rows={bRows}
                                            columns={bColumn}
                                            pageSize={10}
                                            rowsPerPageOptions={[10]}
                                            checkboxSelection
                                            onSelectionModelChange={() => {

                                            }
                                            }
                                        />
                                    </div>
                                </Stack>
                            </Grid>

                        </>
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