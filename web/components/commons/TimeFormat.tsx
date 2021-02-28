import React from 'react';
import styled from "@emotion/styled";
import palette from "../../style/js/palette";

const TimeFormatStyle = styled.div`
  margin: 2px;
  color: ${palette.gray5}
`

function TimeFormat({children}) {
    return (
        <TimeFormatStyle>
            {children}
        </TimeFormatStyle>
    );
}

export default TimeFormat;