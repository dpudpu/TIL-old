import React, {Component} from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

const initialTodos = new Array(500).fill(0).map(
    (foo, index )=> ({id:index, text:`일정 ${index}`, done:false})
);

class App extends Component {
    state = {
        input: '',
        todos: initialTodos,
    }

    id = 1
    getId = () => {
        return++ this.id;
    }

    handleToggle = (id) =>{
        const {todos} = this.state;
        const index = todos.findIndex(todo => todo.id ===id);

        const toggled = {
            ...todos[index],
            done: !todos[index].done
        };

        this.setState({
            todos:[
                ...todos.slice(0,index),
                toggled,
                ...todos.slice(index+1,todos.length)
            ]
        });
    }

    handleChange = (e) => {
        const {value} = e.target;
        this.setState({input: value});
    }

    handleInsert = () => {
        const {todos, input} = this.state;

        const newTodo = {
            text: input,
            id: this.getId(),
            done: false
        };

        this.setState({
            todos: [
                ...todos,
                newTodo
            ],
            input: ''
        })

    }

    handleRemove = (id) => {
        const {todos} = this.state;
        const index = todos.findIndex(todo=> todo.id === id);

        this.setState({
            todos:[
                ...todos.slice(0,index),
                ...todos.slice(index+1, todos.length)
            ]
        });
    }

    render() {
        const {input, todos} = this.state;
        const {handleChange, handleInsert, handleToggle, handleRemove} = this;
        return (
            <PageTemplate>
                <TodoInput onChange={handleChange} onInsert={handleInsert} value={input}/>
                <TodoList todos={todos} onToggle={handleToggle} onRemove={handleRemove}/>
            </PageTemplate>

        );
    }
}

export default App;