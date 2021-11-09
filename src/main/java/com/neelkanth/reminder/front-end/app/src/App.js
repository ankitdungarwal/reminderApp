import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ReactList from './ReactList';


class App extends Component{
  render(){
    return(
      <Router>
        <Switch>
        <Route path='/' exact={true} component={Home}/>
        <Route path='/groups' exact={true} component={ReactList}/>
        </Switch>
      </Router>
    )
  }

}

export default App;
