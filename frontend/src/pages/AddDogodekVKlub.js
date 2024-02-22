
import { Button, TextField } from "@mui/material";
import {useState} from "react";
import  Dogodek  from "../APIs/Dogodek"


export default function AddDogodekVKlub() {

    const dogodekApi = new Dogodek();
    const [selectedDate, setSelectedDate] = useState('');
    const [partyName, setPartyName] = useState('');
    const [description, setDescription] = useState('');
    const [ticketPrice, setTicketPrice] = useState('');
    const [numberOfTickets, setNumberOfTickets] = useState('');
    const [numberOfTables, setNumberOfTables] = useState('');

    const handleDateChange = (event) => {
        setSelectedDate(event.target.value);
    };

    const handlePartyNameChange = (event) => {
        setPartyName(event.target.value);
    };

    const handleDescriptionChange = (event) => {
        setDescription(event.target.value);
    };

    const handleTicketPriceChange = (event) => {
        setTicketPrice(event.target.value);
    };

    const handleNumberOfTicketsChange = (event) => {
        setNumberOfTickets(event.target.value);
    };

    const handleNumberOfTablesChange = (event) => {
        setNumberOfTables(event.target.value);
    };

    const handleSubmit = async () => {
        const data = {
            date: selectedDate,
            partyName: partyName,
            description: description,
            ticketPrice: ticketPrice,
            numberOfTickets: numberOfTickets,
            numberOfTables: numberOfTables
        };

        try {
            const response = await dogodekApi.postDogodek(data);
            console.log('Response from server:', response);

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
                onChange={handleDateChange}
            />
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Party Name" variant="outlined" value={partyName} onChange={handlePartyNameChange}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Description" variant="outlined" value={description} onChange={handleDescriptionChange}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Ticket price" variant="outlined" value={ticketPrice} onChange={handleTicketPriceChange}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tickets" variant="outlined" value={numberOfTickets} onChange={handleNumberOfTicketsChange}/>
            <br/>
            <br/>
            <TextField id="outlined-basic" label="Number of tables" variant="outlined" value={numberOfTables} onChange={handleNumberOfTablesChange}/>
            <br/>
            <br/>
            <Button variant="outlined" onClick={handleSubmit}>Add Party</Button>
        </div>
    )
}
