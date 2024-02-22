import {Button, TextField} from "@mui/material";

export default function RegKluba () {
    return (
        <div>

            <h1>Register your Club</h1>

            <TextField id="outlined-basic" label="Klub name" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Adress" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Phone Number" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="PIB" variant="outlined"/>
            <br/>
            <br/>

            <Button variant="outlined">Register your club</Button>


        </div>
    )
}