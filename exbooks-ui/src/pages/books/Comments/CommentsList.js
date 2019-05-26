import React, { Component } from 'react';



class CommentsList extends Component {
    
    constructor() {
        super();
        console.log("[CommentsList] constructor");
        
    }

    

    componentWillUnmount() {
        console.log("[CommentsList] componentWillUnmount");
    } 
    
    componentDidMount(){
        
        console.log("[CommentsList] ");
       
    }
    render() {
        console.log("[CommentsList] render");        
        return (

            <div>
                228
            </div>
        );
    }
}

export default CommentsList; 