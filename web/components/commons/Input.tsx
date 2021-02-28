import React from 'react';
import palette from "../../style/js/palette";
import theme from "../../style/js/theme";
import styled from "@emotion/styled";
import {css} from "@emotion/react";

type ThemeType = 'blue' | 'lightBlue' | 'gray' | 'lightGray';
type SizeType = 'large' | 'medium' | 'small' | 'wide' ;
interface InputProps {
    theme?: ThemeType;
    size?: SizeType;
}

const InputStyle = styled.input<InputProps>`
  width: 2.2rem;
  height: 2.2rem;

  font-size: 1.1rem;
  color: ${palette.gray7};
  font-weight: 500;
  text-align: center;
  
  background: ${palette.gray0};
  border-radius: 5px;
  border: none;

  &::placeholder {
    color: ${palette.gray3};
    font-weight: 400;
  }
  
  &:focus {
    outline: 0;
    outline-offset: -1px;
  }
  
  ${props =>
    props.theme === 'blue' &&
    css`
      
      &:focus {
        outline-color: ${palette.blue0};
        color: ${theme.main};
      }
      &::selection {
        background: ${palette.blue0};
      }
    `
  }
  
  ${props =>
    props.size === 'medium' &&
    css`
      width: 2.6rem;
      height: 2.6rem;
      font-size: 1.3rem;
    `
}

  ${props =>
      props.size === 'wide' &&
      css`
          width: 18rem;
          background: none ;
          border-bottom: 2px solid ${palette.gray3};
          border-radius: 0;
          padding: 0;
          margin:0;

        &:focus {
          outline: 0;
          border-bottom: 2px solid ${palette.blue5};
          color: ${palette.gray7};
        }
    `
  }
`


function Input ({
   theme = 'blue',
   size = 'medium',
   ...rest
}) {
    const htmlProps = rest as any;
    return (
        <InputStyle
            theme={theme}
            size={size}
            {...htmlProps}
        />
    );
};

export default Input;