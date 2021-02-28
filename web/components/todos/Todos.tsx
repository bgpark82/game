import React from 'react';
import styled from "@emotion/styled";
import Todo from "./Todo";

const TodosStyle = styled.div`
  display: flex;
  flex-direction: column;
  gap: 1rem;
  margin: 1rem 0 0 0;
`



function Todos({todos, onToggleDone}) {
    return (
        <TodosStyle>
            {todos.map(todo => (
                <Todo todo={todo} onToggleDone={onToggleDone}/>
            ))}
        </TodosStyle>
    );
}

export default Todos;