import React from 'react'
import {formatDate} from "../../util/DateUtil";

import './Tweet.css'
import Avatar from "../../ui/avatar/Avatar";
import FavIcon from "../icons/FavIcon";
import RetweetIcon from "../icons/RetweetIcon";
const Tweet = props => {

    const {tweet} = props;
    const {id, createdDate, favCount, rtCount, text, label, tweetOwner} = tweet;
    const{username, name, imageUrl} = tweetOwner;

    return (
        <div className={"tweet"}>
            <div className={"horizontal-container"}>
                <Avatar imageUrl = {imageUrl}
                        className = {"tweet-avatar"}/>
                <div>
                    <div className={"horizontal-container"}>
                        <strong className={"tweet-name"}>{name}</strong>
                        <small className={"tweet-username-and-createdDate"}>@{username} |</small>
                        <small className = {"tweet-username-and-createdDate"}>{createdDate}</small>
                    </div>
                    <p className = {"tweet-text"}>{text}</p>
                </div>
            </div>
            <div className={"interaction-container"}>
                <div><FavIcon/>{favCount}</div>
                <div><RetweetIcon/>{rtCount}</div>
            </div>
        </div>
    );
}

export default Tweet;