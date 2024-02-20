import './App.css';
import {
    Routes,
    Route,
    Location,
    Navigator,
    Link,
     BrowserRouter as Router
} from "react-router-dom";
// import Cookies from 'js-cookie';
import Homepage from "./pages/Homepage";
import Uporabnik from "./APIs/Uporabnik";
import Login from "./pages/Login"
import Register from "./pages/Register"
import Dogotki from "./pages/Dogotki"
import AboutUs from "./pages/AboutUs"
import Profil from "./pages/Profil";
import RezMize from "./pages/RezMize";
import RegKluba from "./pages/RegKluba";
import AddDogodek from "./pages/AddDogodek";

function isLogged() {
    return localStorage.getItem("u") !== null
    // const loggedInCookie = document.cookie.split(';').find(cookie => cookie.trim().startsWith('uporabnik='));
    // return !!loggedInCookie;
}

function isVlasnik() {
    return localStorage.getItem("u") !== "lastnik"

}

function isOrganizator() {
    return localStorage.getItem("u") !== "organizator"

}

function isAdministrator() {
    return localStorage.getItem("u") !== "administrator"
}

const LastnikRoutes = () => {
    const location = useLocation();

    return isVlasnik() ? (
        <Outlet/>
    ) : (
        <Navigate to="/home" state={{from: location}} replace/>
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
const ProtectedRoutes = () => {
    const location = useLocation();


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
                    <Route element={<AdministratorRoutes/>}>
                        <Route path="/home" element={<Homepage/>}/>
                        <Route path="/login" element={<Login/>}/>
                        <Route path="/register" element={<Register/>}/>
                        <Route path="/dogotki" element={<Dogotki/>}/>
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
                    </Route>
                </Routes>
  {/*// const [data, setData] = React.useState([{ime: 'test'}])*/}
  {/*// React.useEffect( () => {*/}
  {/*//   api().then((data) => {*/}
  {/*//     console.log(data)*/}
  {/*//     setData(data.data)*/}
  {/*//   })*/}
  {/*//*/}
  {/*// }, [])*/}

  return (
         <Router >

          <div className="App">
              <div role="presentation">
              <BasicBreadcrumbs/>
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

              </div>
              <Routes>
                  <Route path="/login" element={<Login/>}/>
                  <Route path="/aboutus" element={<AboutUs/>} />
                  <Route path="/register" element={Register} />
                  <Route path="/home" element={Homepage} />
                  <Route path="/dogotki" element={Dogotki} />
              </Routes>
              <Routes>
                  <Route path="/profil" element={Profil}/>
                  <Route path="/rmiza" element={RezMize}/>
              </Routes>
              <Routes>
                  <Route path="/adogodek" element={AddDogodek}/>
              </Routes>
              <Routes>
                  <Route path="/rklub" element={RegKluba} />
                  <Route path="/adogodek" element={AddDogodek}/>
              </Routes>

        </div>
</Router>
);
}

export default App;
