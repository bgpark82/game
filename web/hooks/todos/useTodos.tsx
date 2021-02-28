import {useCallback, useState} from "react";

interface Time {
    hour: string,
    minute: string
}
interface Todo {
    id?: number,
    time: {
        start: Time,
        end: Time,
    }
    text: string,
    done: boolean
}

function useTodos() {
    const [todo, setTodo] = useState<Todo>({
        time: {
            start: {
                hour: "",
                minute: ""
            },
            end: {
                hour: "",
                minute: ""
            },
        },
        text:'',
        done:false,
    });

    const [todos, setTodos] = useState<Todo[]>([]);

    const onChangeTime = useCallback((e) => {
        const prefix = e.target.getAttribute('prefix')
        const {name, value} = e.target

        if(name === 'hour' && value > 23) {
            return;
        }

        if(name === 'minute' && value > 59) {
            return;
        }

        setTodo({
            ...todo,
            time: {
                ...todo.time,
                [prefix]: {
                    ...todo.time[prefix],
                    [name]: value
                }
            }
        });
    },[todo]);

    const onChangeText = useCallback((e) => {
        setTodo({
            ...todo,
            text: e.target.value,
        });
    },[todo])

    const onToggleDone = useCallback((id) => {
        setTodos(todos
            .map(todo => todo.id === id ?
                {...todo, done: !todo.done} :
                todo));
    },[todo, todos])

    const onSubmitTodo = useCallback((e) => {
        setTodos([...todos, {
            ...todo,
            id: Date.now()
        }])
        e.preventDefault();
    },[todo,todos]);

    return [todo, todos, onChangeTime, onChangeText, onToggleDone, onSubmitTodo]
}

export default useTodos;