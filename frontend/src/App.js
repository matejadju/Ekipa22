
import './App.css';
import { Routes, Route, Link, BrowserRouter as Router} from "react-router-dom";
import Homepage from "./pages/Homepage";
import Login from "./pages/Login"
import Register from "./pages/Register"
import Dogotki from "./pages/Dogotki"
import AboutUs from "./pages/AboutUs"
import Profil from "./pages/Profil";
import RezMize from "./pages/RezMize";
import RegKluba from "./pages/RegKluba";
import AddDogodek from "./pages/AddDogodek";
import * as PropTypes from "prop-types";

function isLogged() {
    const loggedInCookie = document.cookie.split(';').find(cookie => cookie.trim().startsWith('uporabnik='));
    return !!loggedInCookie;
}

function Redirect(props) {
    return null;
}

Redirect.propTypes = {to: PropTypes.string};

function App() {
    return (
        <Router>
            <div className="App">
                <ul>
                    <li>
                        <Link to="/home">Home</Link>
                    </li>
                    <li>
                        <Link to="/login">Log in</Link>
                    </li>
                    <li>
                        <Link to="/register">Profile</Link>
                    </li>
                    <li>
                        <Link to="/dogotki">Settings</Link>
                    </li>
                    <li>
                        <Link to="/aboutus">About Us</Link>
                    </li>
                </ul>
                <Routes>
                    <Route path="/home" element={isLogged() ? <Homepage /> : <Redirect to="/login" />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/dogotki" element={<Dogotki />} />
                    <Route path="/aboutus" element={<AboutUs />} />
                    {isLogged() && (
                        <>
                            <Route path="/profil" element={<Profil />} />
                            <Route path="/rmiza" element={<RezMize />} />
                        </>
                    )}
                    {/* TODO: Organizator */}
                    {isLogged() && (
                        <Route path="/adogodek" element={<AddDogodek />} />
                    )}
                    {/* TODO: VlasnikK */}
                    {isLogged() && (
                        <>
                            <Route path="/rklub" element={<RegKluba />} />
                            <Route path="/adogodek" element={<AddDogodek />} />
                        </>
                    )}
                </Routes>
            </div>
        </Router>
    );
}

export default App;
