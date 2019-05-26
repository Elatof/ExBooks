import React, { Component } from 'react';
import {Link} from 'react-router-dom';
class BookItem extends Component {

    constructor() {
        super();
        console.log("[BookItem] constructor");
    }

    componentDidMount() {
        console.log("[BookItem] componentDidMount");
    }

    componentWillUnmount() {
        console.log("[BookItem] componentWillUnmount");
    }

    render() {
        console.log("[BookItem] render");        

        const item = this.props.item;
        return (
            <tr key={ item.id }>
                <td>{ item.user }</td>
                <td>{ item.book }</td>
                <td>{ item.announceTimestamp }</td>
                <td><Link to={"/details/" +item.id}>Details</Link></td>
            </tr>
        );
    }
}
export default BookItem;