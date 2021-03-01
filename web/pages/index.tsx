import TodoInputBox from "../components/todos/TodoInputBox";
import Layout from "../components/commons/Layout";
import TodosBox from "../components/todos/TodosBox";
import useTodos from "../hooks/todos/useTodos";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Index() {

    const [todo, todos, onChangeTime, onChangeText, onToggleDone, onRemoveTodo, onSubmitTodo, errors] = useTodos();

    return (
        <Layout>
            <TodoInputBox
                todo={todo}
                errors={errors}
                onChangeTime={onChangeTime}
                onChangeText={onChangeText}
                onSubmitTodo={onSubmitTodo}
            />
            <TodosBox
                todos={todos}
                onToggleDone={onToggleDone}
                onRemoveTodo={onRemoveTodo}
            />

            <ToastContainer/>
        </Layout>
    );
}

export default Index;