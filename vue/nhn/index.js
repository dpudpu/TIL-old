Vue.component('delete-button', {
    template: `<button @click.stop="deleteTodo">삭제</button>`,
    props: {
        index: {
            type: Number,
            required: true
        }
    },
    methods: {
        deleteTodo: function () {
            this.$emit('delete-todo', this.index);
        }
    }
});

const app = new Vue({
    el: '#app',
    data: {
        todos: [],
        todoInputValue: ''
    },
    methods: {
        clicked: function (todo) {
            todo.complete = !todo.complete;
        },
        addTodo: function () {
            this.todos.push({
                title: this.todoInputValue,
                complete: false,
                context: this.todoInputContext
            });
            // this.todoInputValue = ''
        },
        onDeleteTodo: function (index) {
            this.todos.splice(index, 1);
        }
    },
    computed: {
        totalCount: function () {
            return this.todos.length;
        },
        completeCount: function () {
            return this.todos.filter(todo => todo.complete).length;
        },
        incompleteCount: function () {
            return this.todos.filter(todo => !todo.complete).length;
        }
    }
});