import React from "react";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

import Login from "./components/Pages/Login";
import SignUp from "./components/Pages/SignUp"
import ForgotPassword from "./components/Pages/ForgotPassword";
import DailyForm from "./components/Pages/DailyForm";

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
				<Route path="/dailyform" element={<DailyForm/>}/>
			</Routes>
		</Router>
	);
};

export default App;
