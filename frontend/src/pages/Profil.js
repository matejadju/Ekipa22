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
import {TextField} from "@mui/material";


const bull = (
    <Box component="span" sx={{display: 'inline-block', mx: '2px', transform: 'scale(0.8)'}}>
        •
    </Box>
);


export default function Profil() {
    const [data, setData] = useState([]);
    const uData = localStorage.getItem('u');
    const uporabnik = JSON.parse(uData);
    const email = uporabnik.email;
    const id = uporabnik.idUporabnik;
    console.log(id);
    const [telefon, setTelefon] = useState(uporabnik.telefon);

      


    useEffect(() => {
        const fetchData = async () => {
            try {
                const uporabnikResponse = await new Uporabnik().getUserByEmail(email);
                console.log('uporabnikRespnose:', uporabnikResponse);
                setData(uporabnikResponse.data);
            } catch (e) {
                console.error("Napaka pri prevzemanju podatkov:", e);
            }
        };
        fetchData();
    }, []);
    //
    // const bull  =  (
    //     <Box
    //         component="span"
    //         sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
    //     >
    //         •
    //     </Box>
    // );
    //
    //
    // const ProfilCard =({ uporabnik }) => (
    //     <Card>
    //         <CardContent>
    //             <Typography variant="h5" component="div" >
    //                 {uporabnik.ime}, {uporabnik.priimek}
    //             </Typography>
    //             <Typography sx={{ fontSize: 14 }} color="text.secondary" gutterBottom>
    //                 {uporabnik.telefon}
    //             </Typography>
    //         </CardContent>
    //     </Card>
    // )

    const cleareStorage = () =>{
        localStorage.removeItem('u');
        window.location.href = "/"
    }
    
    const updateProfil =  async () => {
      const response = await new Uporabnik().updateProfil(telefon, id)
    }

    const handleTelefonChange = (event) => {
        setTelefon(event.target.value);
    }

    return (
        <div>
            {/*{data.map((uporabnik) => (*/}
            {/*    <ProfilCard key={uporabnik.id} uporabnik={uporabnik} />*/}
            {/*))}*/}
            <Button variant="outlined" onClick={cleareStorage}>Log out</Button>
            <TextField id="outlined-basic" label="telefon" variant="outlined" value={telefon} onChange={handleTelefonChange}/>
            <Button variant="outlined" onClick={updateProfil}>Update</Button>
        </div>
    );
}