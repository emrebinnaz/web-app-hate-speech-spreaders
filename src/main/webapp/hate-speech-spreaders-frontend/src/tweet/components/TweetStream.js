import React from 'react'

import './TweetStream.css'
import Tweet from './Tweet'
import StreamHeader from "./StreamHeader";

const TweetStream = props => {

    const {tweets, streamHeaderText, isStreamTweetsShown} = props;


    return(
        <div className={"tweet-stream"}>
            <StreamHeader headerText = {streamHeaderText}
                          handler = {props.onClickShowStreamTweetsHandler}
                          isStreamTweetsShown = {isStreamTweetsShown}/>
            {
                tweets.map((tweet, index) => (
                    <Tweet tweet = {tweet}
                            key = {index}/>
                ))
            }
        </div>
    );
}
export default TweetStream;