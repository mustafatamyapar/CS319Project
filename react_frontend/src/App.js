import React from "react";
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

import Login from "./components/Pages/Login";
import SignUp from "./components/Pages/SignUp"
import ForgotPassword from "./components/Pages/ForgotPassword";
import DailyForm from "./components/Pages/DailyForm";
import DailyFormDone from "./components/Pages/DailyFormDone";

import Home from "./components/Home";
import NotFound from "./components/Pages/NotFound";
import RoomHistory from "./components/Pages/RoomHistory";
import DormInfo from "./components/Pages/DormInfo";
import GymInfo from "./components/Pages/GymInfo/GymInfo.js";
import MainDormSports from "./components/Pages/GymInfo/MainDormSports";
import MainSports from "./components/Pages/GymInfo/MainSports";
import MainOpenAirSports from "./components/Pages/GymInfo/MainOpenAirSports";
import EastSports from "./components/Pages/GymInfo/EastSports";
import EastOpenAirSports from "./components/Pages/GymInfo/EastOpenAirSports";
import MyProfile from "./components/Pages/MyProfile";
import HealthStatus from "./components/Pages/HealthStatus";
import MyCourses from "./components/Pages/MyCourses/MyCourses";


// Styles

const App = () => {
	return (
		<Router>
			<Routes>
				<Route path="/home" element={<Home/>}/>

				<Route path="/" element={<Login/>}/>
				<Route path="/signup" element={<SignUp/>}/>
				<Route path="/forgotpassword" element={<ForgotPassword/>}/>

				<Route path="/healthstatus" element={<HealthStatus/>}/>
				<Route path="/dailyform" element={<DailyForm/>}/>
				<Route path="/dailyformdone" element={<DailyFormDone/>}/>

				<Route path="/roomhistory" element={<RoomHistory userId={123}/>}/>
				<Route path="/dorminfo" element={<DormInfo userType={"admin"}/>}/>

				<Route path="/gyminfo" element={<GymInfo/>}/>
				<Route path="/maindormsports" element={<MainDormSports/>}/>
				<Route path="/mainsports" element={<MainSports/>}/>
				<Route path="/mainopenairsports" element={<MainOpenAirSports/>}/>
				<Route path="/eastsports" element={<EastSports/>}/>
				<Route path="/eastopenairsports" element={<EastOpenAirSports/>}/>

				<Route path="/myprofile" element={<MyProfile/>}/>
				<Route path="/mycourses" element={<MyCourses/>}/>

				<Route path="/*" element={<NotFound/>}/>
			</Routes>
		</Router>
	);
};

export default App;
