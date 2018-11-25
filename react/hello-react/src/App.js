import React, { Component } from 'react';
import './App.css';
import ScrollBox from './ScrollBox';

class App extends Component {
  render(){
    // const text = "Hello"
    // const condition = true;
    // const style = {
    //   backgroundColor:'red',
    //   border: '1x solid black',
    //   height:Math.round(Math.random()*300)+50,
    //   width:Math.round(Math.random()*300)+50,
    //   WebkitTransition:'all',
    //   MozTransition: 'all',
    //   msTransition: 'all'
    // };
    return (
      <div>
        <ScrollBox ref={(ref) => this.ScrollBox=ref}/>
        <button onClick={()=> this.ScrollBox.ScrollToBottom()}>
        맨 밑으로</button>
      </div>
    );
  }
}

export default App;
