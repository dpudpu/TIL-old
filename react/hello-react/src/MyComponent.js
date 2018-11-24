import React, { Component } from 'react';
import Proptypes from 'prop-types';

class MyComponent extends Component {
   state = {
       number : 10
   }
    static defaultProps={
        name:'기본 이름'
    }
    static Proptypes={
        name:Proptypes.string,
        age:Proptypes.number.isRequired
    }
    render() {
        return (
            <div>
               안녕하세요, 제 이름은 {this.props.name} 입니다.
               <p>저는 {this.props.age}살 입니다.</p>
               <p>숫자 : {this.state.number}</p>
               <button onClick={()=>{
                   this.setState({
                        number: this.state.number+1
                   })
                }
               }>더하기</button>
            </div>
        );
    }
}
// MyComponent.prototype ={
//     name:Proptypes.string // name props 타입을 문자열로 설정합니다.
// }
// MyComponent.defaultProps ={
//     name:'기본이름'
// }

export default MyComponent;