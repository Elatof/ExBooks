import React, { Component } from 'react';
class CommentItem extends Component {

    constructor() {
        super();
        console.log("[CommentItem] constructor");
    }

    componentDidMount() {
        console.log("[CommentItem] componentDidMount");
    }

    componentWillUnmount() {
        console.log("[CommentItem] componentWillUnmount");
    }

    render() {
        console.log("[CommentItem] render");        
        const item = this.props.item;
        return (
            <tr key={ item.id }>
                <td>{ item.user }</td>
                <td>{ item.timestamp }</td>
                <td>{ item.comment}</td>
                <td>{ item.accept}</td>
            </tr>
        );
    }
}
export default CommentItem;