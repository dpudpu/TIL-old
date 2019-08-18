import FormView from '../views/FormView.js'
import ResultView from '../views/ResultView.js'

import SearchModel from '../models/SearchModel.js'


const tag = '[MainController]'

export default {
    init() {
        console.log(tag)
        FormView.setup(document.querySelector('#search-form'))
            .on('@submit', e => this.onSubmit(e.detail.input))
            .on('@reset', e => this.onResetForm())

        ResultView.setup(document.querySelector("#search-result"))
    },

    search(query) {
        console.log(tag, 'search()', query)
        SearchModel.list(query).then(data => {
            this.onSearchResult(data)
        })
    },

    onSubmit(input) {
        console.log(tag, 'onSubmit()', input)
        this.search(input)
    },

    onResetForm() {
        console.log(tag, 'onResetForm()')
        ResultView.hide();
    },

    onSearchResult(data) {
        ResultView.render(data)
    }
}