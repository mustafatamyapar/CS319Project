import {createGlobalStyle} from "styled-components";

export const GlobalStyle = createGlobalStyle`
    :root {
        --maxWidth: 1280px;
        --white: #fff;
        --lightGrey: #f2f2f2;
        --darkGrey: #dfdfdf;
        --blue: #007af3;
        --fontSuperBig: 2.5rem;
        --fontBig: 1.5rem;
        --fontMed: 1.2rem;
        --fontSmall: 1rem;
    }
    * {
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
    }
    
    body {
        margin: 0;
        padding: 0;
        
        h1 {
            font-size: 2rem;
            font-weight: 600;
            color: #000;
        }
        
        h3 {
            font-size: 1.1rem;
            font-weight: 600;
            color: #000;
        }

        p {
            font-size: 1rem;
            color: #000;
        }
    }
`;