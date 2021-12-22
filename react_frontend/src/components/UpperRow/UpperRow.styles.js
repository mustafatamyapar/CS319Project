import styled from "styled-components";

export const Wrapper = styled.div`
  background: var(--lightGrey);
  display: block;
  

`;

export const Content = styled.div`
  align-items: center;
  display: flex;
  max-height: 500px;
  min-height: 425px;
  
`;

export const PageButton = styled.div`
  padding-left: 25px;
  padding-right: 15px;
  display: block;
  background: var(--darkGrey);
  font-size: var(--fontMed);
  min-width: 200px;
  height: 200px;
  border: 2px solid;
  border-radius: 30px;
  margin: 20px auto;
  outline: none;
`;

export const Icon = styled.img`
  height: 150px;

  cursor: pointer;
  transition: all 0.3s;

  :hover {
    color: var(--lightGrey);
  }
`;