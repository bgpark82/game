import React from 'react';
import styled from "@emotion/styled";
import {css} from "@emotion/react";
import palette from "../../style/js/palette";

type ThemeType = 'blue' | 'lightBlue' | 'gray' | 'lightGray';
type SizeType = 'large' | 'medium' | 'small' | 'wide' ;
interface ButtonProps {
    theme?: ThemeType;
    size?: SizeType;
}

const ButtonStyle = styled.button<ButtonProps>`
  
  font-size: 0.9rem;
  font-weight: 600;
  border: none;
  border-radius: 5px;
  
  &:hover {
    cursor: pointer;
  }
  
  ${props => 
    props.theme === 'blue' && css`
      color: white;
      background: ${palette.blue5};
      &:hover {
        background: ${palette.blue6};
      }
      &:focus {
        outline: 0;
      }
  `}

  ${props =>
   props.size === 'medium' && css`
    padding: 0.5rem 0.75rem;
  `} 
  
`

function Button({
    children,
    theme = 'blue',
    size = 'medium',
    ...rest
}) {
    const htmlProp = rest as any;
    return (
        <ButtonStyle
            theme={theme}
            size={size}
            {...htmlProp}
        >
            {children}
        </ButtonStyle>
    );
}

export default Button;