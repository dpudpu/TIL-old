import React, {Component} from 'react';
import PageTemplate from './PageTemplate';
import TodoInput from './TodoInput';
import TodoList from './TodoList';

class App extends Component {
    render() {
        return (
            <div>
                <PageTemplate>
                    <TodoInput/>
                    <TodoList/>
                </PageTemplate>
            </div>
        );
    }
}

export default App;