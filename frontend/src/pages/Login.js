
import {Button, TextField} from "@mui/material";
import {Link} from "react-router-dom";
export default function Login () {
    return (
        <div>
            <h1>Login</h1>

            <TextField id="outlined-basic" label="E-mail" variant="outlined"/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Password" variant="outlined"/>
            <br/>
            <br/>

            <Button variant="outlined">Login</Button>
            <p>You dont have account?Register <Link to="/register">here</Link>!</p>
        </div>
    )
}