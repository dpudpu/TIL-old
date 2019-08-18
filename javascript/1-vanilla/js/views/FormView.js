import View from './View.js'

const tag = '[FormView]'

const FormView = Object.create(View)

FormView.setup = function (el) {
    console.log(tag)
    this.init(el)
    this.inputEl = el.querySelector('[type=text]')
    this.resetEl = el.querySelector('[type=reset]')
    this.showResetBtn(false)
    this.bindEvents()
    console.log(this)
    return this
}

// show의 default는 true
FormView.showResetBtn = function (show = true) {
    this.resetEl.style.display = show ? 'block' : 'none'
}

FormView.bindEvents = function () {
    this.on('submit', e => e.preventDefault())
    this.inputEl.addEventListener('keyup', e => this.onKeyup(e))
    this.resetEl.addEventListener('click', e => this.onClickReset(e))
}

FormView.onKeyup = function (e) {
    const ENTER = 13
    this.showResetBtn(this.inputEl.value.length)
    if (!this.inputEl.value.length) this.emit('@reset')
    if (e.keyCode !== ENTER) return
    this.emit('@submit', {input: this.inputEl.value})
}

FormView.onClickReset = function (e) {
    this.emit('@reset', null)
    this.showResetBtn(false)
}


export default FormView