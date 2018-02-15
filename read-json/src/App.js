import React, { Component } from 'react';
import logo from './logo.svg';
import data from './CallingPhoneCost.json';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <ul>
        {
          data.map(function(phone){
            return <li>{phone.mobileNo} - {phone.cost}</li>;
          })
        }
        </ul>
      </div>
    );
  }
}

export default App;
