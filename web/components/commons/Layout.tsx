import React from 'react';
import styled from "@emotion/styled";

const LayoutStyle = styled.div`
    width: 400px;
    margin: 2rem auto;
    display: flex;
  flex-direction: column;
  gap: 4rem;
`

function Layout({children}) {
    return (
        <LayoutStyle>
            {children}
        </LayoutStyle>
    );
}

export default Layout;