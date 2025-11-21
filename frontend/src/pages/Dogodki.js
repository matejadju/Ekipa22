import React, {useState, useEffect} from "react";
import Dogodek from "../APIs/Dogodek";

import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

export default function Dogodki () {
    const [dogodekPodatki, setDogodekPodatki] = useState([]);

    useEffect( () => {
        const fetchDogodekPodatki = async () => {
            try {
                const dogodekResponse = await new Dogodek().getDogodekByOdobren();
                console.log(dogodekResponse)
                setDogodekPodatki(dogodekResponse.data)
            }catch (error){
                console.error("Napaka pri prevzemanju podatkov:", error);
            }
        };

        fetchDogodekPodatki();
    }, []);

    const bull = (
        <Box
            component="span"
            sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
        >
            •
        </Box>
    );

    const formatDate = (dateArray) => {
        const options = { year: 'numeric', month: 'long', day: 'numeric' };
        const dateObject = new Date(...dateArray);
        return dateObject.toLocaleDateString(undefined, options);
    };

   const DogodekCard = ({ dogodek }) => (

    <Card className="event-card">
        <CardContent>
            <Typography variant="h5" component="div">
                {dogodek.naziv}
            </Typography>
            <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                {dogodek.opis}
            </Typography>
            <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                {dogodek.cenaVstopnice}
            </Typography>
            <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                {formatDate(dogodek.datum)}
            </Typography>
        </CardContent>
    </Card>
)

    return (
        <div>
            {dogodekPodatki.map((dogodek) =>(
                <DogodekCard key={dogodek.id} dogodek={dogodek} />
            ))}
        </div>

    );
}

