import React from 'react';
import './main.css';
class main extends React.Component {

    constructor() {
        super();
        console.log("[Main] constructor");
    }

    componentDidMount() {
        console.log("[Main] componentDidMount");
    }

    componentWillUnmount() {
        console.log("[Main] componentWillUnmount");
    }

    render() {
        console.log("[Main] render");        
        return (
        <div className="main">
        EXBooks-платформа для обміну книжками <br></br>
        КН-203 Корб'як Максим
        </div>
        
        );
    }

}

export default main; 