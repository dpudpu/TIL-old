import React, { Component } from 'react';

class EventPractice extends Component {
    state={
        message:'',
        name:'jun'
    }
    // constructor(props){
    //     super(props);
    //     this.handleChange = this.handleChange.bind(this);
    //     this.handleClick = this.handleClick.bind(this);
    // }

    //  handleChange(e){
    handleChange= (e) => { // 바벨의 transform-class-prope rties 문법
        this.setState({
           [e.target.name]: e.target.value
        });
    }
    handleClick = ()=>{
        alert(this.state.name+' : '+this.state.message);
        this.setState({
            name:'',
            message:''
        });
    }
    handleKeyPress = (e) => {
        if(e.key==='Enter'){
         this.handleClick();
        }
    }
    render() {
        return (
            <div>
                <h1>이벤트 연습</h1>
                <input
                    type = "text"
                    name="name"
                    placeholder="유저명"
                    value={this.state.name}
                    onChange={this.handleChange}
                />
                <input 
                    type = "text"
                    name = "message"
                    placeholder="아무거나 입력해보세요"
                    value={this.state.message}
                    onChange={this.handleChange}
                    onKeyPress={this.handleKeyPress}
                />
                <button onClick={this.handleClick}>확인</button>

                
                {/* onChange={
                (e)=>{
                    this.setState({
                        message: e.target.value
                    })
                }
                }
                />
                <button onClick={
                    ()=>{
                        alert(this.state.message+this.state.name);
                        this.setState({
                            message:' '
                        });
                    }
                }>확인</button> */}
                
         </div>
        );
    }
}

export default EventPractice;