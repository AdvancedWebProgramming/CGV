import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState, useEffect} from 'react';
import Navigation from './components/Navigation';
import Login from './components/Login';
import SignUp from './components/SignUp';
import { BrowserRouter, Route, Switch, Routes } from 'react-router-dom';
function App() {

  return (
    <div className="App">
          <BrowserRouter>
                <Navigation />
                <br/>
                <Routes>
                    <Route path="/login" element={<Login/>} />
                    <Route path="/signup" element={<SignUp/>} />
                </Routes>
            </BrowserRouter>
    </div>
  );
}

export default App;
