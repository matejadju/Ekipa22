import './App.css';
import {Routes, Route, Link, BrowserRouter as Router, useLocation, Navigate, Outlet} from "react-router-dom";
import Homepage from "./pages/Homepage";
import Login from "./pages/Login"
import Register from "./pages/Register"
import Dogodki from "./pages/Dogodki"
import AboutUs from "./pages/AboutUs"
import Profil from "./pages/Profil";
import RezMize from "./pages/RezMize";
import RegKluba from "./pages/RegKluba";
import AddDogodek from "./pages/AddDogodek";
import Navbar from "./components/Navbar";
import AddDogodekVKlub from "./pages/AddDogodekVKlub";
import MyClubs from "./pages/MyParty";
import MyParty from "./pages/MyParty";
import KlubReq from "./pages/KlubReq";
import axios from "axios";
import MyEvents from "./pages/MyEvents";




// axios.interceptors.request.use(
//     (config) => {
//         const token = localStorage.getItem('token') ;
//         console.log(token)
//         console.log(axios.defaults.headers.common['Authorization']);
//         return config;
//     },
//     (error) => {
//         return Promise.reject(error);
//     }
// );

function isLogged() {
    return localStorage.getItem("u") !== null
}

function isLastnik() {
    let userData = localStorage.getItem('u');

    if (userData){
        userData = JSON.parse(userData);

        return userData.vrsta === "lastnik";
    }
    return false;
}

function isOrganizator() {
    let userData = localStorage.getItem('u');

    if (userData){
        userData = JSON.parse(userData);

        return userData.vrsta === "organizator";
    }
    return false;}

function isAdministrator() {
    let userData = localStorage.getItem('u');

    if (userData) {
        userData = JSON.parse(userData);

        return userData.vrsta === "admin";
    }
    return false;
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

    return isLastnik() ? (
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
        <Navigate to="/" state={{from: location}} replace/>
    );
}

function App() {
    return (
        <Router>
            <div className="App">
                <Navbar/>

                <Routes>
                    <Route path="/" />
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/register" element={<Register/>}/>
                    <Route path="/dogodki" element={<Dogodki/>}/>
                    <Route path="/aboutus" element={<AboutUs/>}/>
                    <Route element={<ProtectedRoutes/>}>
                        <Route path="/profil" element={<Profil/>}/>
                        <Route path="/rmiza" element={<RezMize/>}/>
                        <Route element={<OrganizatorRoutes/>}>
                            <Route path="/adogodek" element={<AddDogodek/>}/>
                        </Route>
                        <Route element={<LastnikRoutes/>}>
                            <Route path="/rklub" element={<RegKluba/>}/>
                            <Route path="/addogodekvklub" element={<AddDogodekVKlub/>}/>
                            <Route path="/myparty" element={<MyParty/>}/>
                        </Route>
                        <Route element={<OrganizatorRoutes/>}>
                            <Route path="/adogodek" element={<AddDogodek/>}/>
                            <Route path="/myevent" element={<MyEvents/>}/>
                        </Route>
                        <Route element={<AdministratorRoutes/>}>
                            <Route path="klubreq" element={<KlubReq/>}/>
                        </Route>
                    </Route>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
