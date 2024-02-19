
import './App.css';
import {
    Routes,
    Route,
    Location,
    Navigator,
    Link, BrowserRouter as Router
} from "react-router-dom";
// import Cookies from 'js-cookie';
import Homepage from "./pages/Homepage";
import Login from "./pages/Login"
import Register from "./pages/Register"
import Dogotki from "./pages/Dogotki"
import AboutUs from "./pages/AboutUs"
import Profil from "./pages/Profil";
import RezMize from "./pages/RezMize";
import RegKluba from "./pages/RegKluba";
import AddDogodek from "./pages/AddDogodek";






// function isLogged() {
//     const loggedInCookie = Cookies.get('uporabnik');
//     return !!loggedInCookie;
// }










function App() {
  return (
         <Router >
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

              // TODO: Bez Auntentifikacije
              <Routes>
                  <Route path="/login" component={Login}/>
                  <Route path="/aboutus" component={AboutUs} />
                  <Route path="/register" component={Register} />
                  <Route path="/home" component={Homepage} />
                  <Route path="/dogotki" component={Dogotki} />
              </Routes>
              // TODO: Sa Auntetifikacijom
              <Routes>
                  <Route path="/profil" component={Profil}/>
                  <Route path="/rmiza" component={RezMize}/>
              </Routes>
              // TODO: Organizator
              <Routes>
                  <Route path="/adogodek" component={AddDogodek}/>
              </Routes>
              // TODO: VlasnikK
              <Routes>
                  <Route path="/rklub" component={RegKluba} />
                  <Route path="/adogodek" component={AddDogodek}/>
              </Routes>



          </div>
</Router>
  );
}

export default App;
