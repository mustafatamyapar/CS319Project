import React from "react";
import {Link} from "react-router-dom";

import Logo from "../../images/logo.jpg";

import {Wrapper, Content, LogoImg, Bar, NavbarButton, Buttons} from "./Header.styles";

const Header = () => (
    <Wrapper>
        <Content>
            <LogoImg src={Logo} alt="logo"/>
            <Bar/>
            <h3>John Smith</h3>
            <Buttons>
                <Link to="/"><NavbarButton>Home</NavbarButton></Link>
                <NavbarButton>Notifications</NavbarButton>
                <NavbarButton>Language</NavbarButton>
                <NavbarButton>Points</NavbarButton>
                <NavbarButton>About</NavbarButton>
                <NavbarButton>Logout</NavbarButton>

            </Buttons>
        </Content>
    </Wrapper>
);

export default Header;