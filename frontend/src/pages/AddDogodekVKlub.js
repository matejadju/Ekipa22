
import { Button, TextField } from "@mui/material";
import {useState} from "react";
import  Dogodek  from "../APIs/Dogodek"


export default function AddDogodekVKlub() {

    const dogodekApi = new Dogodek();
    const [selectedDate, setDatum] = useState('');
    const [partyName, setNaziv] = useState('');
    const [description, setOpis] = useState('');
    const [ticketPrice, setCenaVstopnice] = useState('');
    const [numberOfTickets, setSteviloVstopnica] = useState('');
    const [numberOfTables, setSteviloMiz] = useState('');
    const uporabnikData = localStorage.getItem("u");
    const uporabnik = JSON.parse(uporabnikData);
    const id = uporabnik.idUporabnik;



    const handleSubmit = async () => {
        const data = {
            datum: selectedDate,
            naziv: partyName,
            opis: description,
            cenaVstopnice: ticketPrice,
            steviloVstopnic: numberOfTickets,
            steviloMiz: numberOfTables,
            uporabnik: id
        };

        try {
            const response = await dogodekApi.postDogodek(data);
            console.log('Response from server:', response);
            window.location.href = "/"

        } catch (error) {
            console.error('Error sending data:', error);

        }
    };

    return (
        <div>
            <h1>Add Party</h1>

            <input
                type="datetime-local"
                value={selectedDate}
                onChange={(e) => setDatum(e.target.value)}
            />
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Party Name" variant="outlined" value={partyName} onChange={(e) => setNaziv(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Description" variant="outlined" value={description} onChange={(e) => setOpis(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Ticket price" variant="outlined" value={ticketPrice} onChange={(e) => setCenaVstopnice(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tickets" variant="outlined" value={numberOfTickets} onChange={(e) => setSteviloVstopnica(e.target.value)}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tables" variant="outlined" value={numberOfTables} onChange={(e) => setSteviloMiz(e.target.value)}/>
            <br/>
            <br/>
            <Button variant="outlined" onClick={handleSubmit}>Add Party</Button>
        </div>
    )
}
