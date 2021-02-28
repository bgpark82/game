import React from 'react';
import styled from "@emotion/styled";
import palette from "../../style/js/palette";
import Todos from "./Todos";

const TodosStyle = styled.div`
  
`
const Head = styled.div`
  color: ${palette.gray6};
  font-size: 0.75rem;
`


function TodosBox({todos, onToggleDone}) {
    return (
        <TodosStyle>
            <Head>
                2021년 02월 28일
            </Head>
            <Todos todos={todos} onToggleDone={onToggleDone}/>
        </TodosStyle>
    );
}

export default TodosBox;