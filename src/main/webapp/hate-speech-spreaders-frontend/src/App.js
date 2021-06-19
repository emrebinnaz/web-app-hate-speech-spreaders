import React from 'react'
import {
    BrowserRouter as Router,
    Route,
    Switch,
    Redirect
} from "react-router-dom";

import Homepage from "./ui/homepage/Homepage";
import Navigation from "./ui/navigation/Navigation";
import {HOMEPAGE_URL} from "./constants/Urls";

function App() {
  return (
      <Router>
          <Navigation/>
          <Switch>
              <Route path = {HOMEPAGE_URL} exact>
                  <Homepage/>
              </Route>
              <Redirect to= {HOMEPAGE_URL} />
          </Switch>
      </Router>
  );
}

export default App;
