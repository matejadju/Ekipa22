import {Button, TextField} from "@mui/material";
import {Link} from "react-router-dom";
import {useState} from "react";
import Uporabnik from "../APIs/Uporabnik";
import axios from "axios";
export default function Login () {
    const [email, setEmail] = useState("");
    const [geslo, setGeslo] = useState("");
    const uporabnikApi = new Uporabnik();

   const handleLogin = async () => {
    try {
        const response = await uporabnikApi.getUserByLogin(email, geslo);
        console.log(response);

        if (!response.data || !response.data.id) {
            alert("Invalid credentials");
            return;
        }

        localStorage.setItem('u', JSON.stringify({
            idUporabnik: response.data.id,
            email: response.data.email,
            vrsta: response.data.vrsta
        }));

        window.location.href = "/";

    } catch (error) {
        alert("Invalid credentials");
    }
};

    return (
        <div>
            <h1>Login</h1>

            <TextField id="outlined-basic" label="E-mail" variant="outlined" value={email} onChange={(e) =>
            setEmail(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Password" variant="outlined" value={geslo} onChange={(e) =>
            setGeslo(e.target.value)}/>
            <br/>
            <br/>

            <Button variant="outlined" onClick={handleLogin}>Login</Button>
            <p>You dont have account?Register <Link to="/register">here</Link>!</p>
        </div>
    )
}