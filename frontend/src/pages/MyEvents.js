import React, {useState, useEffect} from "react";
import Dogodek from "../APIs/Dogodek";

import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import Button from "@mui/material/Button";

export default function MyEvents () {

    const [dogodekPodatkibyid, setDogodekPodatkibyid] = useState([]);
    const odata = localStorage.getItem("u");
    const uporabnik = JSON.parse(odata);
    const uporabnik_iduporabnik = uporabnik.idUporabnik;
    console.log(uporabnik_iduporabnik)

    const handleDelete = async () => {
        try {
            await new Dogodek().delDogodek(uporabnik_iduporabnik);
            console.log('Dogodek deleted successfully');
        } catch (error) {
            console.error('Error deleting Dogodek:', error);
        }
    };

    useEffect( () => {
        const fetchDogodekPodatkibyid = async () => {
            try {
                console.log(uporabnik_iduporabnik)
                const dogodekResponsebyid = await new Dogodek().getDogodekByOdobrenbyid(uporabnik_iduporabnik);
                console.log(dogodekResponsebyid);
                setDogodekPodatkibyid(dogodekResponsebyid.data);
            } catch (error){
                console.error("Napaka pri prevzemanju podatkov:", error);
            }
        };

        fetchDogodekPodatkibyid();
    }, []);

    const bull  =  (
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



    const DogodekbyidCard =({ dogodek }) => (
        <Card>
            <CardContent>
                <Typography variant="h5" component="div" >
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

            {dogodekPodatkibyid.map((dogodek) =>(
                <DogodekbyidCard key={dogodek.id} dogodek={dogodek} />
            ))}
        </div>

    );
}