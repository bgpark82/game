import React from 'react';
import {RiCheckboxCircleFill} from "react-icons/ri";
import styled from "@emotion/styled";
import palette from "../../style/js/palette";
import {css} from "@emotion/react";
import { TiDeleteOutline } from 'react-icons/ti';


const TodoStyle = styled.div<{done: boolean}>`
    display: flex;
    align-items: center;
  color: ${palette.gray8};
    ${props =>
    props.done && css`
        color: ${palette.gray3};
        text-decoration: line-through;
    `
}
`

const TodoDateBox = styled.div`
  display: flex;
  align-items: center;
  flex: 1.5;
`

const TodoDate = styled.div`
  font-weight: 500;
  font-size: 1.17rem;
`

const TodoText = styled.div`
  font-weight: 400;
  
  display: flex;
  align-items: center;
  flex: 2;
`

const TodoToggleIcon = styled.div<{done: boolean}>`
  display: flex;
  align-items: center;
  font-size: 1.6rem;
  margin: 0 0.5rem 0 0;
  cursor: pointer;
  color: ${palette.gray2};
  &:hover {
    color: ${palette.gray3};  
  }
  
  ${props =>
    props.done && css`
            color: ${palette.blue5};
            &:hover {
              color: ${palette.blue6};
            }
      `
};
`

const TodoDelete = styled.div`
  color: ${palette.gray3};
  font-size: 1.5rem;
  cursor: pointer;
`

function Todo({todo, onToggleDone, onRemoveTodo}) {
    return (
        <TodoStyle key={todo.id} done={todo.done}>
            <TodoDateBox>
                <TodoToggleIcon
                    done={todo.done}
                    onClick={() => onToggleDone(todo.id)}
                >
                    <RiCheckboxCircleFill/>
                </TodoToggleIcon>
                <TodoDate>
                    {todo.time.start.hour}:{todo.time.start.minute} ~ {todo.time.end.hour}:{todo.time.end.minute}
                </TodoDate>
            </TodoDateBox>
            <TodoText>
                {todo.text}
            </TodoText>
            <TodoDelete onClick={() => onRemoveTodo(todo.id)}>
                <TiDeleteOutline/>
            </TodoDelete>
        </TodoStyle>
    );
}

export default Todo;