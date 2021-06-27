import React from 'react'

import './StreamHeader.css';

const StreamHeader = props => {

    const {headerText, isStreamTweetsShown} = props;

    return(
        <div className={"stream-header"}>
            <h2>
                {headerText}
            </h2>
            <div className={"container-of-stream-header-button"}>
                {isStreamTweetsShown ?
                    <button className={"stream-header-button"}
                            onClick={(e) => props.handler()}>
                        Show Stream Tweets
                    </button>
                    :
                    null}
            </div>
        </div>);
}

export default StreamHeader;