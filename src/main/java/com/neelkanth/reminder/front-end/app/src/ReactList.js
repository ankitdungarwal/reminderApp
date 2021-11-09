import React, { Component } from 'react';
import { Button , ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class ReactList extends Component{
  constructor(props){
    super(props);
    this.state = {group:[],isLoading: true};
    this.remove = this.remove.bind(this);
  }

  componentDidMount(){
    this.setState({isLoading:true});

    fetch('/reminder/all').then(response=>response.json()).then(data=> this.setState({groups:data, isLoading: false}));
  }

  async remove(id){
    await fetch(`/reminder/byId/${id}`,{
      method: 'DELETE',
      headers:{
        'Accept': 'application/json',
        'Content-Type':'application/json'
      }
    }).then(()=>{
      let updatedGroups = [...this.state.groups].filter(i=>i.id!==id);
      this.setState({groups:updatedGroups});
    });
  }

  render(){
    const {groups,isLoading} = this.state;

    if(isLoading){
      return <p>Loading...</p>;
    }

    const groupList = groups.map(group=>{
      const address = `${group.id || ''} ${group.name || ''} ${group.creationDate || ''} ${group.updateDate || ''} ${group.triggerDate || ''}`;
      return <tr key={group.id}>
      <td>{address}</td>
      <td>
          <ButtonGroup>
            <Button size="sm" color="primary" tag={Link} to={"/groups/" + group.id}>Edit</Button>
            <Button size="sm" color="danger" onClick={() => this.remove(group.id)}>Delete</Button>
          </ButtonGroup>
        </td>
      </tr>
    });


  return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="float-right">
            <Button color="success" tag={Link} to="/groups/new">Add Group</Button>
          </div>
          <h3>Reminder List</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="20%">Name</th>
              <th width="20%">creationDate</th>
              <th>updateDate</th>
              <th width="10%">triggerDate</th>
            </tr>
            </thead>
            <tbody>
            {groupList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
 }
}


export default ReactList;
