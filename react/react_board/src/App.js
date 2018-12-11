import React, { Component } from 'react';

class App extends Component {
  constructor(props){
    super(props);
    this.child = React.createRef();
  }
  state = {
    maxNo:3,
    boards: [
      {
        no : 1,
        writer: 'Daejun',
        title: 'If yuu intend to live then you die',
        date: new Date()
      },
      {
        no:2,
        writer:'Daejun',
        title:'Founder for two countries',
        date: new Date()
      }
    ]
  }

  handleSaveData = (data) =>{
    let boards =this.state.boards;
    if(data.no === null || data.no === '' || data.no===undefined){
      this.setState({
        maxNo: this.state.maxNo+1,
        boards: boards.concat({no:this.state.maxNo, date: new Date(), ...data})

      });
    }else{
      this.setState({
        boards: boards.map(row=>data.no === row.no ? { ...data}:row)
      })
    }
    // this.setState({
    //   maxNo: this.state.maxNo+1, 
    //   boards: this.state.boards.concat({
    //     no : this.state.maxNo,
    //     date: new Date(),...data})
    // });
  }

  handleSelectRow = (row)=>{
    this.child.current.handleSelectRow(row);
  }
  
  handleRemove = (no) =>{
    this.setState({
      boards: this.state.boards.filter(row=> row.no !==no)
    })
  }

  render(){
    const {boards}=this.state;
    
    return(
      <div>
        <BoardForm onSaveData={this.handleSaveData} ref = {this.child}/>
        <table border="1">
          <tbody>
            <tr align="center">
              <td width="50">No.</td>
              <td width="300">Title</td>
              <td width="100">Name</td>
              <td width="100">Date</td>
            </tr>
            {
              boards.map(row =>
                  (<BoardItem key = {row.no} row = {row} onRemove={this.handleRemove} onSelectRow={this.handleSelectRow}/>)
                )
            }
          </tbody>
        </table>
      </div>
    );
  }
}

class BoardForm extends Component{
  state = {
    writer:'',
    title:''
  }
  handleSelectRow=(row)=>{
    this.setState(row);
  }

  handleChange = (e) =>{
    this.setState({
      [e.target.name]: e.target.value
    })
  }
  handleSubmit = (e) =>{
    e.preventDefault();
    this.props.onSaveData(this.state);
    this.setState({    });

  }

    render() {
      return (
        <form onSubmit={this.handleSubmit}>
        <input placeholder="title" name="title" onChange={this.handleChange}/>
        <input placeholder="name" name="writer" onChange={this.handleChange}/>
        <button type="submit">Save</button>
        </form>
      );
    }
  }


class BoardItem extends React.Component{
  handleRemove = () =>{
    const {row, onRemove} = this.props;
    onRemove(row.no);
  }
  handleSelectRow= () =>{
    const { row, onSelectRow} = this.props;
    onSelectRow(row);
  }
  render(){
    return(
      <tr>
        <td>{this.props.row.no}</td>
        <td> <button onClick={this.handleSelectRow}> {this.props.row.title} </button></td>
        <td>{this.props.row.writer}</td>
        <td>{this.props.row.date.toLocaleDateString('ko-KR')}</td>
        <td><button onClick={this.handleRemove}>삭제</button></td>
      </tr>
    );
  }
}

export default App;
