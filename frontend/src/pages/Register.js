

import { Button, FormControl, InputLabel, MenuItem, Select, TextField } from "@mui/material";
import { useState } from "react";
import { Link } from "react-router-dom";
import Uporabnik from "../APIs/Uporabnik";
export default function Register() {
    const uporabnikApi = new Uporabnik();

    const [ime, setName] = useState('');
    const [priimek, setSurname] = useState('');
    const [email, setEmail] = useState('');
    const [geslo, setPassword] = useState('');
    const [telefon, setPhoneNumber] = useState('');
    const [davcnaStevilka, setTaxNumber] = useState('');
    const [vrsta, setType] = useState('');
    const [emso,setEmso] = useState('');

    const handleRegister = async () => {
        const userData = {
            ime: ime,
            priimek: priimek,
            email: email,
            geslo: geslo,
            telefon: telefon,
            davcnaStevilka: davcnaStevilka,
            vrsta: vrsta,
            emso : emso

        };
        console.log(userData);

        try {
            const response = await uporabnikApi.addUser(userData);
            console.log('Response from server:', response);

            window.location.href = "/login";
        } catch (error) {
            console.error('Error registering user:', error);

        }
    };

    return (
        <div>
            <h1>Register</h1>
            <TextField id="name" label="Name" variant="outlined" value={ime} onChange={(e) => setName(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="surname" label="Surname" variant="outlined" value={priimek}
                       onChange={(e) => setSurname(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="email" label="E-mail" variant="outlined" value={email}
                       onChange={(e) => setEmail(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="password" label="Password" variant="outlined" type="password" value={geslo}
                       onChange={(e) => setPassword(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="phoneNumber" label="Phone number" variant="outlined" value={telefon}
                       onChange={(e) => setPhoneNumber(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="taxNumber" label="Tax Number" variant="outlined" value={davcnaStevilka}
                       onChange={(e) => setTaxNumber(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="emso" label="EMSO" variant="outlined" value={emso}
                       onChange={(e) => setEmso(e.target.value)}/>
            <br/>
            <br/>
            <FormControl>
                <InputLabel id="type-label">Type</InputLabel>
                <Select
                    labelId="type-label"
                    id="type"
                    label="Type"
                    value={vrsta}
                    onChange={(e) => setType(e.target.value)}
                >
                    <MenuItem value={"uporabnik"}>User</MenuItem>
                    <MenuItem value={"lastnik"}>Owner</MenuItem>
                    <MenuItem value={"organizator"}>Organizer</MenuItem>
                </Select>
            </FormControl>
            <br/>
            <br/>
            <Button variant="outlined" onClick={handleRegister}>Register</Button>
            <p>You have an account? Login <Link to="/login">here</Link>!</p>
        </div>
    );


}