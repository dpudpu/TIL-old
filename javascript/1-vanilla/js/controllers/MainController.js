import FormView from '../views/FormView.js'

const tag = '[MainController]'

export default {
    init() {
        console.log(tag)
        FormView.setup(document.querySelector('#search-form'))
            .on('@submit', e => this.onSubmit(e.detail.input))
            .on('@reset', e=>this.onResetForm())
    },

    onSubmit(input) {
        console.log(tag, 'onSubmit()', input)
    },

    onResetForm(){
      console.log(tag, 'onResetForm()')
    }
}