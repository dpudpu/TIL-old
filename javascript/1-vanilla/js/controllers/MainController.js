import FormView from '../views/FormView.js'
import ResultView from '../views/ResultView.js'
import TabView from '../Views/TabView.js'
import KeywordView from '../views/KeywordView.js'

import HistoryView from '../views/HistoryView.js'

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

        KeywordView.setup(document.querySelector('#search-keyword'))
            .on('@click', e => this.onClickKeyWord(e.detail.keyword))

        HistoryView.setup(document.querySelector('#search-history'))
            .on('@click', e => this.onClickHistory(e.detail.keyword))
            .on('@remove', e => this.onRemoveHistory(e.detail.keyword))

        ResultView.setup(document.querySelector("#search-result"))

        this.selectedTab = '추천 검색어'
        this.renderView()
    },

    renderView() {
        console.log(tag, 'renderView()')
        TabView.setActiveTab(this.selectedTab);

        if (this.selectedTab === '추천 검색어') {
            this.fetchSearchKeyword()
            HistoryView.hide()
        } else {
            this.fetchSearchHistory()
            KeywordView.hide()
        }

        ResultView.hide()
    },

    fetchSearchKeyword() {
        KeywordModel.list().then(data => {
            KeywordView.render(data)
        })
    },

    fetchSearchHistory() {
        HistoryModel.list().then(data => {
            HistoryView.render(data).bindRemoveBtn()
        })
    },

    search(query) {
        console.log(tag, 'search()', query)
        FormView.setValue(query)
        HistoryModel.add(query)
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
        this.renderView()
    },

    onSearchResult(data) {
        TabView.hide()
        KeywordView.hide()
        HistoryView.hide()
        ResultView.render(data)
    },

    onChangeTab(tabName) {
        this.selectedTab = tabName
        this.renderView()
    },

    onClickKeyWord(keyword) {
        this.search(keyword)
    },

    onClickHistory(keyword) {
        this.search(keyword)
    },

    onRemoveHistory(keyword){
        HistoryModel.remove(keyword)
        this.renderView()
    }
}