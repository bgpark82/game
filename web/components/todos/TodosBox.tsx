import React from 'react';
import styled from "@emotion/styled";
import palette from "../../style/js/palette";
import Todos from "./Todos";
import moment from "moment";

const TodosStyle = styled.div`
  
`
const Head = styled.div`
  color: ${palette.gray6};
  font-size: 0.8rem;
`


function TodosBox({todos, onToggleDone, onRemoveTodo}) {
    return (
        <TodosStyle>
            <Head>{moment().format('YYYY년 MM월 DD일')} </Head>
            <Todos
                todos={todos}
                onToggleDone={onToggleDone}
                onRemoveTodo={onRemoveTodo}
            />
        </TodosStyle>
    );
}

export default TodosBox;