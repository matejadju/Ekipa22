import * as React from 'react';
import {useState, useEffect} from 'react';
import Box from '@mui/material/Box';
import Uporabnik from "../APIs/Uporabnik";
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import axios, {formToJSON} from 'axios';


const bull = (
    <Box component="span" sx={{display: 'inline-block', mx: '2px', transform: 'scale(0.8)'}}>
        •
    </Box>
);


export default function Profil() {
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const u = localStorage.getItem('u');
                const uData = JSON.parse(u);
                const id = uData.idUporabnik;
                console.log(id);
                const token = localStorage.getItem('token');
                const uporabnikResponse = await new Uporabnik().getUserById(id, token);
                console.log(uporabnikResponse);
                setData(uporabnikResponse.data);
            } catch (e) {
                console.error("Napaka pri prevzemanju podatkov:", e);
            }
        };
        fetchData();
    }, []);

    const ProfilCard = ({uporabnik}) => (
        <Box sx={{minWidth: 275}}>
            <Card variant="outlined">
                <CardContent>
                    <Typography variant="h5" component="div">
                        {uporabnik.ime}, {uporabnik.priimek}
                    </Typography>
                    <Typography sx={{fontSize: 14}} color="text.secondary" gutterBottom>
                        {uporabnik.email}
                    </Typography>
                    <Typography sx={{mb: 1.5}} color="text.secondary">
                        {uporabnik.telefon}
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="small">Learn More</Button>
                </CardActions>
            </Card>
        </Box>
)
    const cleareStorage = () =>{
        localStorage.removeItem('u');
        localStorage.removeItem('token');
        window.location.href = "/"
    }

    return (
       <div>
           {data.map((uporabnik)=>(
               <ProfilCard key={uporabnik.idUporabnik} uporabnik={uporabnik} />

           ))}
           <Button variant="outlined" onClick={cleareStorage}>Log out</Button>
       </div>
    );
}