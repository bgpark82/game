import React from 'react';
import Input from "../commons/Input";
import styled from "@emotion/styled";
import palette from "../../style/js/palette";
import Button from "../commons/Button";
import TimeFormat from "../commons/TimeFormat";
import {IoAlertCircleOutline} from "react-icons/io5";

const InputBoxStyle = styled.form`   
    display: flex;
    flex-direction: column;
    
    gap: 1rem;
  
    font-size: 1.5rem;
    font-weight: 700;
    color: ${palette.gray7};
`

const TimeContainer = styled.div`
  display: flex;
  align-items: baseline;
  font-size: 1rem;
`

const TimeBox = styled.div`
  display: flex;
  align-items: baseline;
  position:relative;
  
`

const TextBox = styled.div`
  display: flex;
  gap: 0.5rem
`

const ErrorBox = styled.div`
  display: flex;
  gap: 0.25rem;
  flex-direction: column;

`

const Error = styled.div`
  font-size: 0.9rem;
  font-weight: 400;
  color: ${palette.gray7};
  display: flex;
  align-items: center;
  & span {
    font-size: 1.1rem;
    margin: 0 0.25rem 0 0;
  }
`

const AmPm = styled.div`
  position: absolute;
  top: -.7rem;
  font-size: 0.5rem;
  color: ${palette.blue7};
`

function TodoInputBox({todo, errors, onChangeTime, onChangeText, onSubmitTodo}) {

    return (
        <InputBoxStyle onSubmit={onSubmitTodo}>
            <TimeContainer>
                <TimeBox>
                    <AmPm>{todo.time.start.ampm}</AmPm>
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
                </TimeBox>
                <TimeFormat>~</TimeFormat>
                <TimeBox>
                    <AmPm>{todo.time.end.ampm}</AmPm>
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
            </TimeContainer>
            <TextBox>
                <Input
                    size="wide"
                    placeholder="열정, 열정, 열정!"
                    onChange={onChangeText}
                    value={todo.text}
                />
                <Button>저장하기</Button>
            </TextBox>
            <ErrorBox>
            {errors.length > 0 && errors.map(error => (
                <Error>
                    <span><IoAlertCircleOutline /></span>{error.message}
                </Error>
            ))}
            </ErrorBox>

        </InputBoxStyle>
    );
}

export default TodoInputBox;