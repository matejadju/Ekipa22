import * as React from 'react';
import Typography from '@mui/material/Typography';
import Breadcrumbs from '@mui/material/Breadcrumbs';
import { Link } from 'react-router-dom';

function handleClick(event) {
    event.preventDefault();
    console.info('You clicked a breadcrumb.');
}

export default function BasicBreadcrumbs() {
    return (
        <div role="presentation" onClick={handleClick}>
            <Breadcrumbs aria-label="breadcrumb">
                <Link underline="hover" color="inherit" to="/home">
                    Home
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/aboutus"
                >
                    About us
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/login"
                >
                    Login
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/register"
                >
                    Register
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/profil"
                >
                    Profile
                </Link>
                <Typography color="text.primary">Breadcrumbs</Typography>
            </Breadcrumbs>
        </div>
    );
}