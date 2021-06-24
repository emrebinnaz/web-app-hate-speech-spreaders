import React from 'react'
import {LOCATION_OF_HASHTAGS} from "../../constants/Constants";
import './Hashtag.css'

const Hashtag = props => {

    const {id, name} = props;

    return(
        <div className={"hashtag"} onClick={(e) => props.handler(id, name)}>
            <hr style ={{borderTop: "1px solid #F7F9FA"}}/>
            <div className={"texts-container"}>
                <small className={"location-of-hashtag-text"}>Trend at {LOCATION_OF_HASHTAGS}</small>
                <strong className={"hashtag-name"}>{name}</strong>
            </div>
        </div>
    );
}
export default Hashtag;