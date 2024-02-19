import logo from './logo.svg';
import './App.css';
import Homepage from "./pages/Homepage";
import Uporabnik from "./APIs/Uporabnik";
import React from "react";
// import { useState, useEffect } from 'react';
async function api() {
  let api = new Uporabnik()
  return api.getUsers()
}
function App() {
  const [data, setData] = React.useState([{ime: 'test'}])
  React.useEffect( () => {
    api().then((data) => {
      console.log(data)
      setData(data.data)
    })

  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>

        <div>
          {data.map((item) => {
            return (<li key={item.ime}>{item.ime}</li>)
          })}
        </div>

        {/*<Homepage dataPrikaz={data}/>*/}
      </header>
    </div>
  );
}
// <div>
//   {data.map((item) => (<span>{item.ime}</span>))}
// </div>

export default App;
