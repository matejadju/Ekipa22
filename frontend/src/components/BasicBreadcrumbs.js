import * as React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Breadcrumbs, Typography, Button, Box } from '@mui/material';

export default function BasicBreadcrumbs() {
  const navigate = useNavigate();
  const userData = localStorage.getItem('u');
  const user = userData ? JSON.parse(userData) : null;
  const userType = user?.vrsta;

  const handleLogout = () => {
    localStorage.removeItem('u');
    navigate('/login');
  };

  return (
    <Box
      sx={{
        p: 2,
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: '#f5f5f5',
        boxShadow: 1,
      }}
    >
      <Breadcrumbs aria-label="breadcrumb">
        <Link to="/">Home</Link>
        <Link to="/aboutus">About Us</Link>
        <Link to="/dogodki">Events</Link>

        {/* 👇 Ako korisnik NIJE prijavljen */}
        {!user && (
          <>
            <Link to="/login">Login</Link>
            <Link to="/register">Register</Link>
          </>
        )}

        {/* 👇 Ako JE prijavljen */}
        {user && (
          <>
            <Link to="/profil">Profile</Link>
            <Link to="/rmiza">Table reservation</Link>

            {/* 🔸 Samo za LASTNIK */}
            {userType === 'lastnik' && (
              <>
                <Link to="/rklub">Club Registration</Link>
                <Link to="/addogodekvklub">Add Party</Link>
                <Link to="/myparty">My Party</Link>
              </>
            )}

            {/* 🔸 Samo za ORGANIZATOR */}
            {userType === 'organizator' && (
              <>
                <Link to="/adogodek">Add Event</Link>
                <Link to="/myevent">My Events</Link>
              </>
            )}

            {/* 🔸 Samo za ADMIN */}
            {userType === 'admin' && (
              <>
                <Link to="/klubreq">Club Requests</Link>
              </>
            )}

            <Button color="error" size="small" onClick={handleLogout}>
              Logout
            </Button>
          </>
        )}
      </Breadcrumbs>

      {/* 👇 Opcionalno — tekst sa info o korisniku */}
      {user && (
        <Typography variant="body2" color="text.secondary">
          {user.ime} {user.priimek} ({user.vrsta})
        </Typography>
      )}
    </Box>
  );
}
