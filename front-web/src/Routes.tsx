import React from 'react';
//import { BrowserRouter, Routes as Rt, Route } from 'react-router-dom';

import Home from './Home';
import Navbar from './Navbar';
import Orders from "./Orders";

function Routes(){
   return(
     /*<BrowserRouter>
        <Navbar />
        <Rt>
            <Route path="/orders">
                <Orders />
            </Route>
            <Route path="/">
                <Home />
            </Route>
        </Rt>
     </BrowserRouter>*/
     <></>
   );
}

export default Routes;