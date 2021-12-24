import React, {useState} from "react";
import {
    Accordion,
    AccordionDetails,
    AccordionSummary,
    Box, Checkbox,
    FormControlLabel,
    FormGroup, Grid,
    Typography
} from "@mui/material";

import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

import Buildings from "../../BuildingData.json"

const AccordionGroup = () => {
    const [checked, setChecked] = useState(Array.from({length: Buildings["buildingCount"]}, (_, j1) => (
        Array.from({length: Buildings[j1.toString()]["roomCount"]}, (_, __) => false)
    )));

    console.table(checked)

    const handleCheck = (j1, j2) => {
        let temp = checked
        temp[j1][j2] = !temp[j1][j2]
        setChecked(temp)
    }

    return (
        <Grid container direction="column" width="20%" minWidth={350}>
            {Array.from({ length: Buildings["buildingCount"] }, (_, i) => (
                <>
                    <Accordion >
                        <AccordionSummary
                            expandIcon={<ExpandMoreIcon/>}
                            aria-controls="panel1a-content"
                            id="panel1a-header">
                            <Typography>{Buildings[i.toString()]["building"]}</Typography>
                        </AccordionSummary>
                        <AccordionDetails>
                            <Typography>Rooms</Typography>
                            <FormGroup>
                                {
                                    Array.from({length: Buildings[i.toString()]["roomCount"]},
                                        (_, i2) => (
                                            <FormControlLabel control={
                                                <Checkbox id={i.toString()+","+i2.toString()}
                                                          onChange={() => {
                                                              handleCheck(i, i2)
                                                          }}
                                                />
                                            } label={Buildings[i.toString()]["rooms"][i2.toString()]}
                                            />
                                        ))}
                            </FormGroup>
                        </AccordionDetails>
                    </Accordion>
                    <Box margin={1}/>
                </>
            ))}
        </Grid>
    )
}

export default AccordionGroup;