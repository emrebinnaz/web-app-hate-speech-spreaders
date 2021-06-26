import React from 'react'
import './Hashtag.css'

const Hashtag = props => {

    const {id, name} = props;

    return(
        <div className={"hashtag"} onClick={(e) => props.handler(id, name)}>
            <hr style ={{borderTop: "1px solid #F7F9FA"}}/>
            <div className={"texts-container"}>
                <small className={"location-of-hashtag-text"}>Trend topic</small>
                <strong className={"hashtag-name"}>{name}</strong>
            </div>
        </div>
    );
}
export default Hashtag;