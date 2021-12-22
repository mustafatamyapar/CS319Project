import React from "react";
import {BrowserRouter as Router/*, Routes, Route*/} from "react-router-dom";

import {GlobalStyle} from "./GlobalStyle";

import Header from "./components/Header";

// Styles

const App = () => (
    <Router>
		<Header/>
		<GlobalStyle/>
	</Router>
);

export default App;
