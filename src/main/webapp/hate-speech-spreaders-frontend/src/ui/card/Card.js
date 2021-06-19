import React from 'react'

import './card.css'
import CardHeader from "./CardHeader";
const Card = props => {

    return(
        <div className={"card"}>
            <CardHeader header = {props.headerText}/>
            {props.children}
        </div>
    );
}

export default Card;