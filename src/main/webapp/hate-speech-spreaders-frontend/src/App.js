import React from 'react'
import {
    BrowserRouter as Router,
    Route,
    Switch,
    Redirect
} from "react-router-dom";

import Homepage from "./ui/Homepage";

function App() {
  return (
      <Router>
          <Switch>
              <Route path = "/" exact>
                  <Homepage/>
              </Route>
              <Redirect to="/" />
          </Switch>
      </Router>
  );
}

export default App;
