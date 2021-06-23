import React from 'react'

import Avatar from "../../ui/avatar/Avatar";
import "./TweetOwnerProfileInfo.css"
import TypeOfSpreader from "../../ui/type_of_spreader/TypeOfSpreader";

const TweetOwnerProfileInfo = props => {

    const {name, username, imageUrl, followers, following,typeOfSpreader} = props.ownerInfo;

    return (
        <div className={"tweetOwnerProfileInfo-card"}>
            <div style={{marginLeft: "30px"}}>
                <Avatar imageUrl = {imageUrl}
                        className = {"tweetOwnerProfileInfo-imageUrl"}/>
                <div className={"tweetOwnerProfileInfo-texts-container"}>
                    <strong className={"tweetOwnerProfileInfo-name"}>{name}</strong>
                    <small className={"tweetOwnerProfileInfo-username"}>@{username}</small>
                    <small className={"tweetOwnerProfileInfo-date"}> Joined at April 2014 </small>
                    <div className={"tweetOwnerProfileInfo-interaction-container"}>
                        <div><strong>{following} </strong> <small>Following </small></div>
                        <div><strong>{followers} </strong> <small>Followers </small></div>
                    </div>
                </div>
            </div>
            <div className={"type-of-sperader"}>
                <TypeOfSpreader type = {typeOfSpreader.toLowerCase()}/>
            </div>
        </div>
    );
}
export default TweetOwnerProfileInfo;