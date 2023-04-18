import Login from './pages/login/Login';
import RegistrationComponent from './pages/registration/RegistrationComponent';
import Rooms from './pages/rooms/Rooms';
import Prove from './pages/prove';
import { BrowserRouter, Routes, Switch, Route, Link } from 'react-router-dom';
import './App.css';
import { useState } from 'react';

function App() {
  const [isPremium, setIsPremium] = useState();

  return (
    <div className='App'>
      <BrowserRouter>
        <Routes>
          <Route
            exact
            path='/'
            element={
              <Login premium={(value) => setIsPremium(value)} />
            }></Route>
          <Route
            exact
            path='/registration'
            element={<RegistrationComponent />}></Route>
          <Route
            exact
            path='/rooms'
            element={<Rooms premium={isPremium} />}></Route>
          <Route exact path='/prove' element={<Prove />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}
export default App;
