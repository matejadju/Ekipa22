import {Button, TextField} from "@mui/material";

export default function AddDogodek() {
    return (
        <div>

            <h1>Add Dogodek</h1>

            <TextField id="outlined-basic" label="Date" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Party Name" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Description" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Ticket price" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tickets" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tables" variant="outlined"/>
            <br/>
            <br/>
                <Button variant="outlined">Add Dogodek</Button>
        </div>
    )
}