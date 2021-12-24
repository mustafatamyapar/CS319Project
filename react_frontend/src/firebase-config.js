import { initializeApp } from "firebase/app";
import {getAuth} from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyB9x7kDwhR466gCoClUllTNef6mHBSeZwQ",
  authDomain: "covidshark-3b292.firebaseapp.com",
  projectId: "covidshark-3b292",
  storageBucket: "covidshark-3b292.appspot.com",
  messagingSenderId: "646140014768",
  appId: "1:646140014768:web:3d5e45ba27239a7db14b75",
  measurementId: "G-X5N3TJC2EL"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export const auth = getAuth(app);