import React, {useEffect, useState} from "react";
import Box from "@mui/material/Box";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Klub from "../APIs/Klub";
import CardActions from "@mui/material/CardActions";
import {Button} from "@mui/material";

export default function KlubReq () {
    const [klubData, setKlubData] = useState([]);

    useEffect(() => {
        const fetchKlubData = async () => {
            try {
                const klubResponse = await new Klub().getKlubByStatus();
                console.log(klubResponse)
                setKlubData(klubResponse.data)
            }catch (error) {
                console.error("Napaka pri prevzemanju podatkov", error)
            }
        };
        fetchKlubData();
    }, []);

    const bull = (
        <Box
            component="span"
            sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
        >
            •
        </Box>
    );

    const KlubCard =({ klub }) => (
        <Card>
            <CardContent>
                <Typography variant="h5" component="div" >
                    {klub.naziv}
                </Typography>
                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                    {klub.adresa}
                </Typography>
                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                    {klub.telefon}
                </Typography>
                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                    {klub.pib}
                </Typography>
                <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
                    {klub.idKlub}
                </Typography>
            </CardContent>
            <CardActions>
                <Button size="small">Accept</Button>
            </CardActions>
        </Card>
    )

    return (
        <div>
            {klubData.map((klub) =>(
                <KlubCard key={klub.id} klub={klub} />
            ))}
        </div>
    )
}