import React from 'react';
import {
    Routes,
    Route,
    Link,
    BrowserRouter as Router,
    useLocation,
    Navigate,
    Outlet,
} from 'react-router-dom';
import BasicBreadcrumbs from "./components/BasicBreadcrumbs";
import Homepage from './pages/Homepage';
import Login from './pages/Login';
import Register from './pages/Register';
import Dogodki from './pages/Dogodki';
import AboutUs from './pages/AboutUs';
import Profil from './pages/Profil';
import RezMize from './pages/RezMize';
import RegKluba from './pages/RegKluba';
import AddDogodek from './pages/AddDogodek';

function isLogged() {
    return localStorage.getItem('u') !== null;
}

function isVlasnik() {
    return localStorage.getItem('u') !== 'lastnik';
}

function isOrganizator() {
    return localStorage.getItem('u') !== 'organizator';
}

function isAdministrator() {
    return localStorage.getItem('u') !== 'administrator';
}

const LastnikRoutes = () => {
    const location = useLocation();
    return isVlasnik() ? <Outlet /> : <Navigate to="/home" state={{ from: location }} replace />;
};

const OrganizatorRoutes = () => {
    const location = useLocation();
    return isOrganizator() ? <Outlet /> : <Navigate to="/home" state={{ from: location }} replace />;
};
const ProtectedRoutes = () => {
    const location = useLocation();

    return isLogged() ? (
        <Outlet/>
    ) : (
        <Navigate to="/login" state={{from: location}} replace/>
    );
};

const AdministratorRoutes = () => {
    const location = useLocation();
    return isAdministrator() ? <Outlet /> : <Navigate to="/home" state={{ from: location }} replace />;
};

function App() {
    return (
        <Router>
            <div className="App">
                <BasicBreadcrumbs/>

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
                                <Route path="/adogodek" element={<AddDogodek/>}/>
                            </Route>
                        </Route>
                </Routes>
            </div>
        </Router>
    );
}

export default App;
