import FormView from '../views/FormView.js'
import ResultView from '../views/ResultView.js'
import TabView from '../Views/TabView.js'

import HistoryModel from '../models/HistoryModel.js'
import KeywordModel from '../models/KeywordModel.js'
import SearchModel from '../models/SearchModel.js'

const tag = '[MainController]'

export default {
    init() {
        console.log(tag)
        FormView.setup(document.querySelector('#search-form'))
            .on('@submit', e => this.onSubmit(e.detail.input))
            .on('@reset', e => this.onResetForm())

        TabView.setup(document.querySelector('#tabs'))
            .on('@change', e => this.onChangeTab(e.detail.tabName))

        ResultView.setup(document.querySelector("#search-result"))

        this.selectedTab = '최근 검색어'
        this.renderView()
    },

    renderView() {
        console.log(tag, 'renderView()')
        TabView.setActiveTab(this.selectedTab);

        ResultView.hide()
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
    },

    onChangeTab(tabName) {
    debugger
    }
}