import React from "react";
import {BrowserRouter as Router/*, Routes, Route*/} from "react-router-dom";

import {GlobalStyle} from "./GlobalStyle";

import Home from "./components/Home";

// Styles

const App = () => (
    <Router>
		<Home/>
		<GlobalStyle/>
	</Router>
);

export default App;
