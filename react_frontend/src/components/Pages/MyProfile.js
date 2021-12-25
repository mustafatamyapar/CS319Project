import React, {useState} from "react";
import Header from "../Header/Header";
import {onAuthStateChanged} from "firebase/auth";
import {auth} from "../../firebase-config";


const MyProfile = () => {
    const[user, setUser] = useState({})

    onAuthStateChanged(auth, (currentUser) => {
        setUser(currentUser)
    })

    return (
        <>
            <Header/>
            <>Test</>
        </>
    )

}

export default MyProfile