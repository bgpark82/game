import TodoInputBox from "../components/todos/TodoInputBox";
import Layout from "../components/commons/Layout";
import TodosBox from "../components/todos/TodosBox";
import useTodos from "../hooks/todos/useTodos";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Index() {

    const [todo, todos, onChangeTime, onChangeText, onToggleDone, onSubmitTodo] = useTodos();
    const notify = () => toast("😩 아니, 아직 하고있어??!",{
        autoClose: false,
        type:toast.TYPE.DARK
    });

    return (
        <Layout>
            <TodoInputBox
                todo={todo}
                onChangeTime={onChangeTime}
                onChangeText={onChangeText}
                onSubmitTodo={onSubmitTodo}
            />
            <TodosBox
                todos={todos}
                onToggleDone={onToggleDone}
            />
            <button onClick={notify}>notify</button>
            <ToastContainer/>
        </Layout>
    );
}

export default Index;