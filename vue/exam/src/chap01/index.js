let app = new Vue({
    el: '#app',
    data: {
        message: '안녕하세요 Vue!'
    }
});

let app2 = new Vue({
    el: '#app-2',
    data: {
        message: '이 페이지는 ' + new Date() + ' 에 로드 되었습니다'
    }
})

const app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
})

const app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            {text: 'JavaScript 배우기'},
            {text: 'Vue 배우기'},
            {text: '무언가 멋진 것을 만들기'}
        ]
    }
})

var app5 = new Vue({
    el: '#app-5',
    data: {
        message: '안녕하세요! Vue.js!'
    },
    methods: {
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
})

let app6 = new Vue({
    el: '#app-6',
    data: {
        message: '안녕하세요 Vue!'
    }
})

Vue.component('todo-item',{
    props: ['todo'],
    template: '<li>{{ todo.text }}</li>'
})

let app7 = new Vue({
    el: '#app-7',
    data:{
        groceryList:[
            {id:0, text: '글쓰기 피드백'},
            {id:1, text: '토비 3장'},
            {id:2, text: 'UML 읽기'},
        ]
    }
})