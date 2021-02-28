import React from 'react';
import Input from "../commons/Input";
import styled from "@emotion/styled";
import palette from "../../style/js/palette";
import Button from "../commons/Button";
import TimeFormat from "../commons/TimeFormat";

const InputBoxStyle = styled.form`   
    display: flex;
    flex-direction: column;
    
    gap: 1rem;
  
    font-size: 1.5rem;
    font-weight: 700;
    color: ${palette.gray7};
`

const TimeBox = styled.div`
  display: flex;
  align-items: baseline;
  font-size: 1rem;
  
`

const TextBox = styled.div`
  display: flex;
  gap: 0.5rem
`

function TodoInputBox({todo, onChangeTime, onChangeText, onSubmitTodo}) {

    return (
        <InputBoxStyle onSubmit={onSubmitTodo}>
            <TimeBox>
                <Input
                    placeholder="11"
                    value={todo.time.start.hour}
                    onChange={onChangeTime}
                    prefix="start"
                    name="hour"
                />
                <TimeFormat>:</TimeFormat>
                <Input
                    placeholder="30"
                    value={todo.time.start.minute}
                    onChange={onChangeTime}
                    prefix="start"
                    name="minute"
                />
                <TimeFormat>~</TimeFormat>
                <Input
                    placeholder="12"
                    value={todo.time.end.hour}
                    onChange={onChangeTime}
                    prefix="end"
                    name="hour"
                />
                <TimeFormat>:</TimeFormat>
                <Input
                    placeholder="50"
                    value={todo.time.end.minute}
                    onChange={onChangeTime}
                    prefix="end"
                    name="minute"
                />
            </TimeBox>
            <TextBox>
                <Input
                    size="wide"
                    placeholder="열정, 열정, 열정!"
                    onChange={onChangeText}
                    value={todo.text}
                />
                <Button>저장하기</Button>
            </TextBox>
        </InputBoxStyle>
    );
}

export default TodoInputBox;