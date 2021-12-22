import React from "react";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

import Login from "./components/Pages/LogIn/Login";
import SignUp from "./components/Pages/SignUp/SignUp"
import ForgotPassword from "./components/Pages/ForgotPassword/ForgotPassword";

import Home from "./components/Home";


// Styles

const App = () => {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<Home/>}/>
				<Route path="/login" element={<Login/>}/>
				<Route path="/signup" element={<SignUp/>}/>
				<Route path="/forgotpassword" element={<ForgotPassword/>}/>
			</Routes>
		</Router>
	);
};

export default App;
