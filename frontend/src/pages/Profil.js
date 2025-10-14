import * as React from "react";
import { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import Uporabnik from "../APIs/Uporabnik";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import { TextField } from "@mui/material";

export default function Profil() {
  const [data, setData] = useState(null);
  const uData = localStorage.getItem("u");
  const uporabnik = JSON.parse(uData);
  const email = uporabnik?.email;
  const id = uporabnik?.idUporabnik;
  const [telefon, setTelefon] = useState(uporabnik?.telefon || "");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const uporabnikResponse = await new Uporabnik().getUserByEmail(email);
        console.log("Uporabnik response:", uporabnikResponse);
        const uporabnikData = uporabnikResponse.data || uporabnikResponse;
        setData(Array.isArray(uporabnikData) ? uporabnikData[0] : uporabnikData);
      } catch (e) {
        console.error("Napaka pri prevzemanju podatkov:", e);
      }
    };
    if (email) fetchData();
  }, [email]);

  useEffect(() => {
    if (data?.telefon) {
      setTelefon(data.telefon);
    }
  }, [data]);

  const clearStorage = () => {
    localStorage.removeItem("u");
    window.location.href = "/";
  };

  const updateProfil = async () => {
    try {
      await new Uporabnik().updateProfil(telefon, id);
      alert("Profil uspešno posodobljen!");
    } catch (e) {
      console.error("Napaka pri posodobitvi:", e);
    }
  };

  const handleTelefonChange = (event) => {
    setTelefon(event.target.value);
  };

  if (!data)
    return (
      <Typography sx={{ m: 4, textAlign: "center" }}>
        Nalaganje profila...
      </Typography>
    );

  return (
    <Box
      sx={{
        minHeight: "100vh",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        backgroundColor: "#f5f5f5",
        p: 3,
      }}
    >
      <Card
        sx={{
          width: "100%",
          maxWidth: 400,
          mb: 4,
          boxShadow: 4,
          borderRadius: 3,
          textAlign: "center",
        }}
      >
        <CardContent>
          <Typography variant="h5" sx={{ fontWeight: "bold", mb: 1 }}>
            {data.ime} {data.priimek}
          </Typography>
          <Typography color="text.secondary" sx={{ mb: 2 }}>
            {data.email}
          </Typography>
          <Typography variant="body2" sx={{ mb: 1 }}>
            <strong>Telefon:</strong> {data.telefon || "—"}
          </Typography>
          <Typography variant="body2">
            <strong>Vrsta:</strong> {data.vrsta}
          </Typography>
        </CardContent>
      </Card>

      <Box
        sx={{
          display: "flex",
          gap: 2,
          flexWrap: "wrap",
          justifyContent: "center",
        }}
      >
        <TextField
          label="Telefon"
          variant="outlined"
          onChange={handleTelefonChange}
          sx={{ width: 200 }}
        />
        <Button
          variant="contained"
          onClick={updateProfil}
          sx={{ minWidth: 120, fontWeight: "bold" }}
        >
          POSODOBI
        </Button>
        <Button
          variant="outlined"
          color="error"
          onClick={clearStorage}
          sx={{ minWidth: 120, fontWeight: "bold" }}
        >
          ODJAVA
        </Button>
      </Box>
    </Box>
  );
}
