import { Button, TextField } from "@mui/material";
import {useState} from "react";
import  Dogodek  from "../APIs/Dogodek"
import {id} from "date-fns/locale";





export default function AddDogodek() {



        const eventApi = new Dogodek();
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

            if (!selectedDate || !partyName || !description || !ticketPrice || !numberOfTickets || !numberOfTables) {
                window.alert("All fields are required!");
                return;
            }

                const data = {
                        datum: selectedDate,
                        naziv: partyName,
                        opis: description,
                        cenaVstopnice: parseInt(ticketPrice),
                        steviloVstopnic: parseInt(numberOfTickets),
                        steviloMiz: parseInt(numberOfTables),
                    uporabnik: id


                };
                console.log(data)

                try {
                        const response = await eventApi.postDogodek(data);
                        console.log('Response from server:', response);
                    window.location.href = "/"

                } catch (error) {
                        console.error('Error sending data:', error);

                }
        };
        return (
            <div>
                    <h1>Add Event</h1>

                   <input
                        id="eventDate"
                        type="datetime-local"
                        value={selectedDate}
                        onChange={(e) => setDatum(e.target.value)}
                    />
                    <br/><br/>

                    <TextField id="eventName" label="Event Name" variant="outlined" value={partyName}
                        onChange={(e) => setNaziv(e.target.value)}/>
                    <br/><br/>

                    <TextField id="eventDescription" label="Description" variant="outlined" value={description}
                        onChange={(e) => setOpis(e.target.value)}/>
                    <br/><br/>

                    <TextField id="ticketPrice" label="Ticket price" variant="outlined" value={ticketPrice}
                        onChange={(e) => setCenaVstopnice(e.target.value)}/>
                    <br/><br/>

                    <TextField id="ticketCount" label="Number of tickets" variant="outlined" value={numberOfTickets}
                        onChange={(e) => setSteviloVstopnica(e.target.value)}/>
                    <br/><br/>

                    <TextField id="tableCount" label="Number of tables" variant="outlined" value={numberOfTables}
                        onChange={(e) => setSteviloMiz(e.target.value)}/>
                    <br/><br/>
                    <Button variant="outlined" onClick={handleSubmit}>Add Event</Button>
            </div>
        )
}