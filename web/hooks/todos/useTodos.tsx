import {useCallback, useState} from "react";
import useNotification from "./useNotification";
import useTodo from "./useTodo";

export interface Time {
    hour:  string,
    minute:  string,
    ampm: 'am'|'pm'|''
}
export interface Todo {
    id: number,
    time: {
        start: Time,
        end: Time,
    }
    text: string,
    done: boolean
}

function useTodos() {
    const [errors, setErrors] = useState([])
    const [todo, setTodo] = useState<Todo>({
        id: -1,
        time: {
            start: {
                hour: "",
                minute: "",
                ampm: "",
            },
            end: {
                hour: "",
                minute: "",
                ampm: "",
            },
        },
        text:'',
        done:false,
    });
    const [todos, setTodos] = useState<Todo[]>([]);
    const [setNotification] = useNotification({todo});

    const onToggleDone = useCallback((id) => {
        setTodos(todos
            .map(todo => todo.id === id ?
                {...todo, done: !todo.done} :
                todo));
    },[todo, todos])

    const onRemoveTodo = useCallback((id) => {
        setTodos(todos
            .filter(todo => todo.id !== id));
    },[todo, todos])

    const onSubmitTodo = useCallback((e) => {
        e.preventDefault();
        if(hasErrors()) return;

        setTodos([...todos, {
            ...todo,
            id: Date.now()
        }])
        setNotification();
    },[todo,todos,errors]);

    const onChangeTime = useCallback((e) => {
        const prefix = e.target.getAttribute('prefix')
        const {name, value} = e.target
        const regex = new RegExp(/^\d*$/);

        if(!regex.test(value)) {
            return;
        }

        if(name === 'hour' && value > 23 ) {
            return;
        }

        if(name === 'minute' && value > 59) {
            return;
        }

        const time = {
            ...todo.time[prefix],
            [name]: value,
        }

        if(name === 'hour') {
            const ampm = (value > 11) ? 'pm' : 'am'
            time.ampm = ampm;
        }

        setTodo({
            ...todo,
            time: {
                ...todo.time,
                [prefix]: time
            }
        });
    },[todo]);

    const onChangeText = useCallback((e) => {
        setTodo({
            ...todo,
            text: e.target.value,
        });
    },[todo])

    const hasErrors = useCallback(():boolean => {
        const {end, start} = todo.time;
        const startInMin = (parseInt(start.hour,10) * 60) + parseInt(start.minute,10);
        const endInMin = (parseInt(end.hour,10) * 60) + parseInt(end.minute,10);
        const list=[]

        if(start.hour === '' || start.minute === '') {
            list.push( {
                message: "시작시간을 입력해주세요"
            })
        }
        if(end.hour === '' || end.minute === '') {
            list.push( {
                message: "종료시간을 입력해주세요"
            })
        }
        if(todo.text === '') {
            list.push( {
                message: "할일을 입력해주세요"
            })
        }
        if(endInMin - startInMin < 0) {
            list.push( {
                message: "시작시간은 종료시간 이전으로 해주세요"
            })
        }
        setErrors(list);

        return list.length > 0;
    },[errors, todo])



    return [todo, todos, onChangeTime, onChangeText, onToggleDone, onRemoveTodo, onSubmitTodo, errors]
}

export default useTodos;