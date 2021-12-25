import {FormControl, FormControlLabel, FormLabel, Grid, RadioGroup, Radio, Box} from "@mui/material";
import DormData from "../../DormData.json"
import {useState} from "react";

// Type:
// 1: Dorm    column
// 2: Floor   column
// 3: Student column

// dormCount and floorCount's are not used and can be removed from JSON
const RadioButtonList = ({type, callback, dorm, floor, callback2 = null}) => {

    const [selection, setSelection] = useState(null)

    const handleSelection = async (sel) => {
        if (sel !== null) {
            await setSelection(sel);
            callback(sel);
            console.log(selection);
        }
        if (callback2 !== null) {
            callback2(dorm);
        }
    }

    return (
        <Grid padding={5}>
            <Grid border="solid" color="#723456" padding={4}
                  paddingRight={10} borderRadius={5}>
                <FormControl component="fieldset">
                    <FormLabel style={{fontWeight: 600, fontSize: 20, fontFamily:"Poppins"}} component="legend">
                        {(type === 1 ? "Dorms" : ((type === 2) ? "Floors" : "Students"))}
                    </FormLabel>
                    <Box margin={1}/>
                    <RadioGroup aria-label="state">
                        {Array.from({
                                length:
                                    ((type === 1)
                                        ? Object.keys(DormData).length
                                        : (((type === 2)
                                                ? Object.keys(DormData[dorm]).length
                                                : Object.keys(DormData[dorm][floor]).length
                                        ))
                                    )
                            },
                            (_, i) =>
                                ((type === 1)
                                        ? (<FormControlLabel value={i} control={<Radio onClick={async () => {
                                            await handleSelection(Object.keys(DormData)[i])
                                        }} key={i} defaultValue={0}/>} label={Object.keys(DormData)[i]} />)

                                        : ((type === 2) ? (<FormControlLabel value={i} control={<Radio onClick={async () => {
                                                await handleSelection(Object.keys(DormData[dorm])[i])
                                            }} key={i} defaultValue={0}/>} label={Object.keys(DormData[dorm])[i]}/>)

                                            : <FormControlLabel value={i} control={<Radio onClick={async () => {
                                                await handleSelection(DormData[dorm][floor][Object.keys(DormData[dorm][floor])[i]])
                                            }} key={i} defaultValue={0}/>} label={DormData[dorm][floor][Object.keys(DormData[dorm][floor])[i]]}/>)
                                )
                        )
                        }
                    </RadioGroup>
                </FormControl>
            </Grid>
        </Grid>
    )
}
export default RadioButtonList