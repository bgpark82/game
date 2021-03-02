import React, {useEffect, useRef} from 'react';
import moment from "moment";
import {toast} from "react-toastify";

interface ITimeout {
    id: number,
    timeout: NodeJS.Timeout
}

function useNotification() {
    const timeoutRef = useRef<ITimeout[]>([])

    useEffect(() => {
        if (!("Notification" in window)) {
            console.log("지원하지 않는 브라우저입니다");
        } else {
            Notification.requestPermission().then((permission) => {
                console.log(permission)
            });
        }
    },[])

    const setNotification = (todo) => {
        const text = todo.text;
        const {hour, minute} = todo.time.end;
        const now = moment();
        const end = moment().set({
            hour: parseInt(hour,10),
            minute: parseInt(minute,10),
            second: 0,
        })
        const diff = end.diff(now)
        console.log(now)
        console.log(end)
        console.log(diff)

        const timeout = setTimeout(() => {
            new Notification("times up!", {
                body: "😩 아니, " + text + " 아직 안했단 말이야??",
                silent: false,
                dir: "ltr",
            });
            alarm(text);
            removeNotification(todo.id);
        },diff)

        timeoutRef.current.push({
            id: todo.id,
            timeout: timeout
        })
    }

    const removeNotification = (id) => {
        timeoutRef.current = timeoutRef.current.filter(timeout => timeout.id != id);
        const over = timeoutRef.current.find(timeout => timeout.id == id);
        if(over) {
            clearTimeout(over.timeout);
        }
    }

    const alarm = ( text) => toast("😩 아니, " + text + " 아직 안했단 말이야??",{
        autoClose: false,
        type:toast.TYPE.DARK
    });

    return [setNotification, removeNotification]
}

export default useNotification;