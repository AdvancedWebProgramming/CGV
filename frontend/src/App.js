import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React, {useState, useEffect} from 'react';
import Navigation from './components/Navigation';
import Login from './components/Login';
import SignUp from './components/SignUp';
import Ratingboard from './components/Ratingboard'
import Movie from './components/Ratingboard'
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
                    <Route path="/movie/ratingboard" element={<Ratingboard/>} />//상세페이지에서 리뷰로 가도록
                    <Route path="/movie" element={<Movie/>} />//상세페이지에서
                </Routes>
            </BrowserRouter>
    </div>
  );
}

export default App;
