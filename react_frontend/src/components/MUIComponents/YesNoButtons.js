import React from "react";
import {Radio, FormControl, FormLabel, FormControlLabel, RadioGroup} from '@mui/material';

class YesNoButton extends React.Component {
    render() {
        return(
            <FormControl component="fieldset">
                <FormLabel component="legend"></FormLabel>
                <RadioGroup row aria-label="yes-no" name="row-radio-buttons-group">
                        <FormControlLabel value="Yes" control={<Radio />} label="Yes" />
                        <FormControlLabel value="No" control={<Radio />} label="No" />
                </RadioGroup>
            </FormControl>
        );
    }
}

export default YesNoButton;