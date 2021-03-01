import React, {useEffect} from 'react';
import moment from "moment";
import {toast} from "react-toastify";

function useNotification({todo}) {
    useEffect(() => {
        if (!("Notification" in window)) {
            console.log("지원하지 않는 브라우저입니다");
        } else {
            Notification.requestPermission().then((permission) => {
                console.log(permission)
            });
        }
    },[])

    const setNotification = () => {
        const text = todo.text;
        const {hour, minute} = todo.time.end;
        const now = moment();
        const end = moment().set({
            hour: parseInt(hour,10),
            minute: parseInt(minute,10),
            second: 0,
        })
        const diff = end.diff(now)

        setTimeout(() => {
            new Notification("times up!", {
                body: "😩 아니, " + text + " 아직 안했단 말이야??",
                icon: "🚀",
                data: "이건 뭐야??",
                silent: false,
                dir: "ltr",
                tag: "group1"
            });
            alarm( text);
        },diff)
    }

    const alarm = ( text) => toast("😩 아니, " + text + " 아직 안했단 말이야??",{
        autoClose: false,
        type:toast.TYPE.DARK
    });

    return [setNotification, ]
}

export default useNotification;