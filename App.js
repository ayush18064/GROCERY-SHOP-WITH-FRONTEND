import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Catalog from './components/Catalog';

import { BrowserRouter,Route,Router,Routes,useNavigate } from 'react-router-dom'
import Login from './components/Login';
function App() {
  return (
    <>
    <BrowserRouter>
    <Routes>
      <Route path='/login' element={<Login/>}></Route>
      <Route path='/catalog' element={<Catalog/>}></Route>
    </Routes>
    </BrowserRouter>

    </>
  );
}

export default App;
