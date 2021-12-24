import React from "react";
import {Box} from '@mui/material';

function EmptyBox({value}) {
    return (
        <Box sx={{ marginTop: (value), 
            display: 'flex', 
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center' }}>
        </Box>
    )
}

export default EmptyBox;