import styled from "styled-components";

export const Wrapper = styled.div`
  background: var(--darkGrey);
  padding: 0 20px;
`;

export const Content = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  max-width: var(--maxWidth);
  padding: 10px 0;
  margin: 0 auto;
  
  h3 {
    padding-left: 16px;
    padding-right: 20px;
    min-width: fit-content;
  }
`;

export const LogoImg = styled.img`
  width: 150px;
  padding-right: 16px;
  
  @media screen and (max-width: 500px) {
    width: 150px;
  }
`;

export const Bar = styled.div`
  border: thin solid #707070;
  height: 40px;
`;

export const Buttons = styled.div`
  background: var(darkGrey);
  display: flex;
  justify-content: space-between;
  min-width: 750px;
  padding-left: 150px;
  margin: 0 auto;
`;

export const NavbarButton = styled.button`
  display: block;
  background: var(darkGrey);
  font-size: var(--fontSmall);
  width: auto;
  height: 40px;
  border-radius: 20px;
  border: none;
  transition: all 0.3s;
  outline: none;
  cursor: pointer;
  padding: 0 10px 1px 10px;
  
  :hover {
    opacity: 0.8;
  }
`;