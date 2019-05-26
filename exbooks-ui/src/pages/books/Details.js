import React, { Component } from 'react';

import {BrowserRouter as Router, Route,NavLink,Switch} from 'react-router-dom';
import Comments from './Comments/CommentsList';
import CommentsList from './Comments/CommentsList';

class Details extends Component {
    
    constructor() {
        super();
        console.log("[Details] constructor");
        this.state = {
         Book:{
            idBook: '',
            nameBook: '',
            genreBook: '',
            descriptionBook: '',
            authorBook: '',
            yearBook: '',

            idUser: '',
            firstNameUser: '',
            surnameUser: '',
            emailUser: '',
            phoneUser: ''
        }
        };
        
    }


    componentWillUnmount() {
        console.log("[Details] componentWillUnmount");
    } 
    
    componentDidMount(){
        const Id = this.props.match.params.Id;
        console.log("[Details] getbook");
        let initialItems=[];
        fetch(`http://localhost:8080/api/books/${Id}/details`)
            .then(response => {
                return response.json();
                
            }).then(data => {
                console.log(data)
                initialItems = data;
                
                this.setState({
                    Book: initialItems,
                });
        });
    }
    render() {
        console.log("[Details] render");        
        return (
            <Router>
            <div>

                <hr></hr>
                <b>Book:</b>{this.state.Book.nameBook}<br></br>
               <b>Genre:</b>{this.state.Book.genreBook}<br></br>
         <b>Description:</b>{this.state.Book.descriptionBook}<br></br>
              <b>Author:</b>{this.state.Book.authorBook}<br></br>
                <b>Year:</b>{this.state.Book.yearBook}<br></br>
              
                <hr></hr>
                <b>Owner name:</b>{this.state.Book.firstNameUser}<br></br>
               <b>Surname:</b>{this.state.Book.surnameUser}<br></br>
               <b>Email:</b>{this.state.Book.emailUser}<br></br>
              <b>Phone:</b>{this.state.Book.phoneUser}<br></br>
            </div>
            <hr></hr>
            <NavLink to ="/comments">Comments:</NavLink>
            <Route exact path="/comments" component={CommentsList}/>
            </Router>
        );
    }
}

export default Details; 