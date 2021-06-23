import React from 'react'
import {formatDate} from "../../util/DateUtil";

import './Tweet.css'
import Avatar from "../../ui/avatar/Avatar";
import FavIcon from "../icons/FavIcon";
import RetweetIcon from "../icons/RetweetIcon";
import Label from "../../ui/label/Label";
const Tweet = props => {

    const {tweet} = props;
    const {createdDate, favCount, rtCount, text, label, tweetOwner} = tweet;
    const {username, name, imageUrl} = tweetOwner;

    return (
        <div className={"tweet"}>
            <div>
                <div className={"horizontal-container"}>
                    <Avatar imageUrl = {imageUrl}
                            className = {"tweet-avatar"}/>
                    <div style = {{width: '100%'}}>
                        <div className={"horizontal-container"}>
                            <strong className={"tweet-name"}>{name}</strong>
                            <small className={"tweet-username-and-createdDate"}>@{username} |</small>
                            <small className = {"tweet-username-and-createdDate"}>{formatDate(createdDate)}</small>
                            <div style = {{marginLeft: 'auto'}}>
                                <Label label = {label.toLowerCase()}/>
                            </div>
                        </div>
                        <p className = {"tweet-text"}>{text}</p>
                    </div>
                </div>
                <div className={"interaction-container"}>
                    <div><FavIcon/>{favCount}</div>
                    <div><RetweetIcon/>{rtCount}</div>
                </div>
            </div>
        </div>
    );
}

export default Tweet;