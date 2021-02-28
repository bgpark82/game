import TodoInputBox from "../components/todos/TodoInputBox";
import Layout from "../components/commons/Layout";
import TodosBox from "../components/todos/TodosBox";
import useTodos from "../hooks/todos/useTodos";

function Index() {

    const [todo, todos, onChangeTime, onChangeText, onToggleDone, onSubmitTodo] = useTodos();

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
        </Layout>
    );
}

export default Index;