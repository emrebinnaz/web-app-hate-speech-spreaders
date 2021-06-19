import React from 'react'

import './MostInteractedUser.css'
const MostInteractedUser = props => {

    const {id, name, username, imageUrl} = props;

    return (
        <div className={"mostInteractedUser"}>
            <hr style={{borderTop: "1px solid #F7F9FA"}}/>
            <div className={"horizontal-container"}>
                <div className={"image-container"}>
                    <img src={imageUrl} className={"mostInteractedUser-imageUrl"}/>
                </div>
                <div className={"texts-container"}>
                    <strong className={"mostInteractedUser-name"}>{name}</strong>
                    <small className={"mostInteractedUser-username"}>@{username}</small>
                </div>
            </div>
        </div>
    );
}
export default MostInteractedUser;