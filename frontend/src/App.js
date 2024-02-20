import logo from './logo.svg';
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
import BasicBreadcrumbs from "./components/BasicBreadcrumbs";
import React from "react";
// import { useState, useEffect } from 'react';
async function api() {
  let api = new Uporabnik()
  return api.getUsers()
}







// function isLogged() {
//     const loggedInCookie = Cookies.get('uporabnik');
//     return !!loggedInCookie;
// }










function App() {
  // const [data, setData] = React.useState([{ime: 'test'}])
  // React.useEffect( () => {
  //   api().then((data) => {
  //     console.log(data)
  //     setData(data.data)
  //   })
  //
  // }, [])

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
