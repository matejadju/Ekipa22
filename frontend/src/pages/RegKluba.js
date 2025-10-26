import {Button, TextField} from "@mui/material";
import {useState} from "react";
import Klub from "../APIs/Klub";

export default function RegKluba () {

    const klubApi = new Klub();

    const [naziv, setNaziv] = useState('');
    const [adresa, setAdresa] = useState('');
    const [telefon, setTelefon] = useState('');
    const [pib, setPib] = useState('');

    const handleSubmit = async () => {
        const data = {
            naziv: naziv,
            adresa: adresa,
            telefon: telefon,
            pib: pib
        };

        console.log(data);

        try {
            const response = await klubApi.addKlub(data);
            console.log("Response:", response);
            window.location.href = "/";
        } catch (error) {
            console.error("Error adding club:", error);
            window.alert("Error adding club");
        }
    };

    return (
        <div>
            <h1>Register your Club</h1>

            <TextField label="Club name"
                       variant="outlined"
                       value={naziv}
                       onChange={(e) => setNaziv(e.target.value)}/>
            <br/><br/>

            <TextField label="Address"
                       variant="outlined"
                       value={adresa}
                       onChange={(e) => setAdresa(e.target.value)}/>
            <br/><br/>

            <TextField label="Phone Number"
                       variant="outlined"
                       value={telefon}
                       onChange={(e) => setTelefon(e.target.value)}/>
            <br/><br/>

            <TextField label="PIB"
                       variant="outlined"
                       value={pib}
                       onChange={(e) => setPib(e.target.value)}/>
            <br/><br/>

            <Button variant="outlined" onClick={handleSubmit}>
                Register your club
            </Button>
        </div>
    )
}
