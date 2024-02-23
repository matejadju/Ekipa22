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
                <Link underline="hover" color="inherit" to="/">
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
                <Link
                    underline="hover"
                    color="inherit"
                    to="/dogodki"
                >
                    Events
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/rmiza"
                >
                    Table reservation
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/adogodek"
                >
                    Add events
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/rklub"
                >
                    Club Registration
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/klubreq"
                >
                    Club Requests
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/addogodekvklub"
                >
                    Add party
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/myevent"
                >
                    My events
                </Link>
                <Link
                    underline="hover"
                    color="inherit"
                    to="/myparty"
                >
                    My party
                </Link>
            </Breadcrumbs>
        </div>
    );
}