import React from 'react'

import './StreamHeader.css';

const StreamHeader = props => {

    return(
        <div>
            <h3 className={"stream-header"}>
                {props.headerText}
            </h3>
        </div>);
}

export default StreamHeader;