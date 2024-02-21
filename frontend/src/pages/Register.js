import {Box, Button, FormControl, InputLabel, MenuItem, Select, TextField} from "@mui/material";

import {Link} from "react-router-dom";

export default function Register () {
    return (
        <div>
                <h1>Register</h1>

                <TextField id="outlined-basic" label="Name" variant="outlined"/>
                <br/>
                <br/>
                <TextField id="outlined-basic" label="Surname" variant="outlined"/>
                <br/>
                <br/>
                <TextField id="outlined-basic" label="E-mail" variant="outlined"/>
                <br/>
                <br/>
                <TextField id="outlined-basic" label="Password" variant="outlined"/>
                <br/>
                <br/>
                <TextField id="outlined-basic" label="Phone number" variant="outlined"/>
                <br/>
                <br/>
                <TextField id="outlined-basic" label="Tax Number" variant="outlined"/>
                <br/>
                <br/>

                        <FormControl>
                                <InputLabel id="demo-simple-select-label">Vrsta</InputLabel>
                                <Select
                                    labelId="demo-simple-select-label"
                                    id="demo-simple-select"
                                    label="Vrsta"
                                >
                                        <MenuItem value={"uporabnik"}>Uporabnik</MenuItem>
                                        <MenuItem value={"lasnik"}>Lasnik</MenuItem>
                                        <MenuItem value={"organizator"}>Organizator</MenuItem>
                                </Select>
                        </FormControl>
                        <br/>
                        <br/>

                <Button variant="outlined">Register</Button>
                <p>You have an account? Login <Link to="/login">here</Link>!</p>


        </div>
    )
}