import React, { Component } from 'react';
import logo from './logo.svg';
import data from './PhoneCallingCost.json';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <ul>
        {
          data.map(function(phone){
            return <li>Mobile No.: {phone.mobileNo} - {phone.cost.toFixed(2)} Baht</li>;
          })
        }
        </ul>
        </div>
    );
  }
}

export default App;
