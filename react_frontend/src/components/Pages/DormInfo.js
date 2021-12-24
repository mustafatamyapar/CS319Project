import React from "react";
import Header from "../Header/Header";

const DormInfo = ({userType}) => {

    return (
        <>
            <Header/>
            User type: {userType}
        </>
    );
}

export default DormInfo;