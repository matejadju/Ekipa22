import './App.css';
import {Routes, Route, Link, BrowserRouter as Router, useLocation, Navigate, Outlet} from "react-router-dom";
import KlubReq from "./pages/KlubReq";
import Login from "./pages/Login"
import Register from "./pages/Register"
import Dogotki from "./pages/Dogotki"
import AboutUs from "./pages/AboutUs"
import Profil from "./pages/Profil";
import RezMize from "./pages/RezMize";
import RegKluba from "./pages/RegKluba";
import AddDogodek from "./pages/AddDogodek";
import AddDogodekVKlub from "./pages/AddDogodekVKlub"
import MyClubs from "./pages/MyClubs";
import MyEvents from "./pages/MyEvents"

function isLogged() {
    return localStorage.getItem("u") !== null
    // const loggedInCookie = document.cookie.split(';').find(cookie => cookie.trim().startsWith('uporabnik='));
    // return !!loggedInCookie;
}

function isVlasnik() {
    return localStorage.getItem("u") === "lasnik"

}

function isOrganizator() {
    return localStorage.getItem("u") === "organizator"

}

function isAdministrator() {
    return localStorage.getItem("u") === "administrator"
}
const ProtectedRoutes = () => {
    const location = useLocation();

    return isLogged() ? (
        <Outlet/>
    ) : (
        <Navigate to="/login" state={{from: location}} replace/>
    );
};
const LastnikRoutes = () => {
    const location = useLocation();

    return isVlasnik() ? (
        <Outlet/>
    ) : (
        <Navigate to="/" state={{from: location}} replace/>
    );
}
const OrganizatorRoutes = () => {
    const location = useLocation();

    return isOrganizator() ? (
        <Outlet/>
    ) : (
        <Navigate to="/home" state={{from: location}} replace/>
    );
}

const AdministratorRoutes = () => {
    const location = useLocation()
    return isAdministrator() ? (
        <Outlet/>
    ) : (
        <Navigate to="/home" state={{from: location}} replace/>
    );

}


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

                        <Route path="/"/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/register" element={<Register/>}/>
                        <Route path="/dogotki" element={<Dogotki/>}/>
                        <Route path="/aboutus" element={<AboutUs/>}/>
                        <Route element={<ProtectedRoutes/>}>
                            <Route path="/profil" element={<Profil/>}/>
                            <Route path="/rmiza" element={<RezMize/>}/>
                            <Route element={<LastnikRoutes/>}>
                                <Route path="/rklub" element={<RegKluba/>}/>
                                <Route path="/adogodekvklub" element={<AddDogodekVKlub/>}/>
                                <Route path="/myclubs" element={<MyClubs/>}/>
                            </Route>
                            <Route element={<OrganizatorRoutes/>}>
                                <Route path="/adogodek" element={<AddDogodek/>}/>
                                <Route path="/myevents" element={<MyEvents/>}/>
                            </Route>
                            <Route element={<AdministratorRoutes/>}>
                                <Route path="klubreq" element={<KlubReq/>}/>
                            </Route>
                        </Route>


                </Routes>

        </div>
</Router>
)
    ;
}

export default App;
