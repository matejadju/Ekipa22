import React from "react";
import { AppBar, Toolbar, Typography, Button, Box, IconButton, Menu, MenuItem } from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import { Link, useNavigate } from "react-router-dom";

export default function Navbar() {
  const navigate = useNavigate();
  const userData = localStorage.getItem("u");
  const user = userData ? JSON.parse(userData) : null;
  const userType = user?.vrsta;

  const [anchorEl, setAnchorEl] = React.useState(null);
  const handleMenu = (event) => setAnchorEl(event.currentTarget);
  const handleClose = () => setAnchorEl(null);

  const handleLogout = () => {
    localStorage.removeItem("u");
    navigate("/login");
  };

  const linkStyle = {
    textDecoration: "none",
    color: "white",
    marginRight: "1rem",
    fontWeight: 500,
  };

  return (
    <AppBar position="static" color="primary">
      <Toolbar sx={{ display: "flex", justifyContent: "space-between" }}>
        {/* LOGO / NASLOV */}
        <Typography
          variant="h6"
          component={Link}
          to="/"
          sx={{ textDecoration: "none", color: "white", fontWeight: "bold" }}
        >
          MariborPonoči
        </Typography>

        {/* DESKTOP NAV LINKS */}
        <Box sx={{ display: { xs: "none", md: "flex" }, alignItems: "center" }}>
          <Link to="/" style={linkStyle}>Home</Link>
          <Link to="/aboutus" style={linkStyle}>About Us</Link>
          <Link to="/dogodki" style={linkStyle}>Events</Link>

          {/* NIJE ULOGOVAN */}
          {!user && (
            <>
              <Link to="/login" style={linkStyle}>Login</Link>
              <Link to="/register" style={linkStyle}>Register</Link>
            </>
          )}

          {/* ULOGOVAN */}
          {user && (
            <>
              <Link to="/profil" style={linkStyle}>Profile</Link>
              <Link to="/rmiza" style={linkStyle}>Table Reservation</Link>

              {userType === "lastnik" && (
                <>
                  <Link to="/rklub" style={linkStyle}>Club Registration</Link>
                  <Link to="/addogodekvklub" style={linkStyle}>Add Party</Link>
                  <Link to="/myparty" style={linkStyle}>My Party</Link>
                </>
              )}

              {userType === "organizator" && (
                <>
                  <Link to="/adogodek" style={linkStyle}>Add Event</Link>
                  <Link to="/myevent" style={linkStyle}>My Events</Link>
                </>
              )}

              {userType === "admin" && (
                <Link to="/klubreq" style={linkStyle}>Club Requests</Link>
              )}

              <Button color="inherit" onClick={handleLogout}>
                Logout
              </Button>
            </>
          )}
        </Box>

        {/* MOBILE MENU */}
        <Box sx={{ display: { xs: "flex", md: "none" } }}>
          <IconButton color="inherit" onClick={handleMenu}>
            <MenuIcon />
          </IconButton>
          <Menu
            anchorEl={anchorEl}
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem component={Link} to="/" onClick={handleClose}>Home</MenuItem>
            <MenuItem component={Link} to="/aboutus" onClick={handleClose}>About Us</MenuItem>
            <MenuItem component={Link} to="/dogodki" onClick={handleClose}>Events</MenuItem>

            {!user && (
              <>
                <MenuItem component={Link} to="/login" onClick={handleClose}>Login</MenuItem>
                <MenuItem component={Link} to="/register" onClick={handleClose}>Register</MenuItem>
              </>
            )}

            {user && (
              <>
                <MenuItem component={Link} to="/profil" onClick={handleClose}>Profile</MenuItem>
                <MenuItem component={Link} to="/rmiza" onClick={handleClose}>Table Reservation</MenuItem>

                {userType === "lastnik" && (
                  <>
                    <MenuItem component={Link} to="/rklub" onClick={handleClose}>Club Registration</MenuItem>
                    <MenuItem component={Link} to="/addogodekvklub" onClick={handleClose}>Add Party</MenuItem>
                    <MenuItem component={Link} to="/myparty" onClick={handleClose}>My Party</MenuItem>
                  </>
                )}

                {userType === "organizator" && (
                  <>
                    <MenuItem component={Link} to="/adogodek" onClick={handleClose}>Add Event</MenuItem>
                    <MenuItem component={Link} to="/myevent" onClick={handleClose}>My Events</MenuItem>
                  </>
                )}

                {userType === "admin" && (
                  <MenuItem component={Link} to="/klubreq" onClick={handleClose}>Club Requests</MenuItem>
                )}

                <MenuItem onClick={() => { handleClose(); handleLogout(); }}>Logout</MenuItem>
              </>
            )}
          </Menu>
        </Box>
      </Toolbar>
    </AppBar>
  );
}
